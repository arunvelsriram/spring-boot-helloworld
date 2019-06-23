package com.example.helloworld

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

@RunWith(SpringRunner::class)
@WebMvcTest(GreetingController::class)
class GreetingApiTest(@Autowired val mockMvc: MockMvc) : StringSpec({
    "should respond with default greeting and count on no query parameter" {
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
        result.andExpect { it.response.status shouldBe 200 }
        result.andExpect { it.response.contentAsString shouldBe """{"id":1,"content":"Hello, World"}""" }
    }

    "should respond with specific greeting and count on query parameter" {
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/greeting?name=Arun"))
        result.andExpect { it.response.status shouldBe 200 }
        result.andExpect { it.response.contentAsString shouldBe """{"id":2,"content":"Hello, Arun"}""" }
    }
})
