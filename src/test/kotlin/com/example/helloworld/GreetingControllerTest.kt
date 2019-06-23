package com.example.helloworld

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class GreetingControllerTest : StringSpec({
    "should return a greeting" {
        GreetingController().greeting("Arun") shouldBe Greeting(1, "Hello, Arun")
    }

    "should keep track of request count" {
        val greetingController = GreetingController()
        greetingController.greeting("Arun") shouldBe Greeting(1, "Hello, Arun")
        greetingController.greeting("Jane") shouldBe Greeting(2, "Hello, Jane")
    }
})
