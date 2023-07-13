package com.example.app

class Destructure {
  fun foo(d: DestructureMe) {
    val (a, b, c) = d
    println("" + a + b + c)
  }
}