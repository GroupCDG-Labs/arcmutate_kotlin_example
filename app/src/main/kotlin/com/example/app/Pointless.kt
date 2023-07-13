package com.example.app

class Pointless {

    inline fun addThings(a : Int, b : Int ) : Int =
        if (a > 10) {
            a + b
        } else {
            a
        }

    fun boo() {
        println("boo")
    }
}