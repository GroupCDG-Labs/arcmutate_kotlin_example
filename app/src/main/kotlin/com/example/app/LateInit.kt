package com.example.app

class LateInit {

    private lateinit var aString: String

    fun doStuff(id: String): String {
        println("leave me");
        aString = heavyFunctionCall(id)

        if (id.equals("foo")) {
            println("leave me");
        }
        return aString;
    }

    private fun heavyFunctionCall(id: String): String {
      return "b$id";
    }
}