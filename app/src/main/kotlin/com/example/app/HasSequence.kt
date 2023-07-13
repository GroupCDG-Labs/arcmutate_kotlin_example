package com.example.app

import java.util.concurrent.Callable

class HasSequence : Callable<Boolean> {
    override fun call() : Boolean = mutateMe().count() == 0

    private fun mutateMe() = sequenceOf(1,2,3)
}