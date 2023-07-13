package com.example.app;

class DefaultArguments {

    fun main() {
        foo("foo")

        foo("bar", 5000)

        foo("bar", enableRetry = false)
    }
    
    fun foo(url: String, connectTimeout: Int = 1000, enableRetry: Boolean = true) {
        println("The parameters are url = $url, connectTimeout = $connectTimeout, enableRetry = $enableRetry")
    }
}
