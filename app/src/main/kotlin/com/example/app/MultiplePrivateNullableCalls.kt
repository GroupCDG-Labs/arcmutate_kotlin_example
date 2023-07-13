package com.example.app

class MultiplePrivateNullableCalls {

    fun topLevel() : Widget = nullable()!!.also(nullable2()!!)

    private fun nullable(): Widget? = Widget()

    private fun nullable2(): Widget? = Widget()

}