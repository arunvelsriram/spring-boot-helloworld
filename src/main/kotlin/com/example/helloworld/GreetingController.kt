package com.example.helloworld

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

data class Greeting(val id: Long, val content: String)

@RestController
class GreetingController {
    val counter = AtomicLong()

    companion object {
        private val logger = LoggerFactory.getLogger(GreetingController::class.java)
    }

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        logger.info("Received name: $name")
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }
}