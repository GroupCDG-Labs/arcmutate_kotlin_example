package com.example.app

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PointlessTest {

    @Test
    fun aTest() {
        assertEquals(1, Pointless().addThings(1, 2))
    }
}