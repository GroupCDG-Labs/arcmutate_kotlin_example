package com.example.app

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BasicCoroutine {

    fun main() = runBlocking {
        println("A")

        launch {
            delay(1000L)
            println("B!")
        }
        println("C")
    }

    fun anotherMethod() {
        println("D")
    }
}