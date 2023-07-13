package com.example.app

import org.assertj.core.api.AbstractAssert


class GridAssert(actual: Array<BooleanArray>) :
    AbstractAssert<GridAssert, Array<BooleanArray>>(actual, GridAssert::class.java) {
    fun isEqualTo(expected: Array<BooleanArray>): GridAssert {
        isNotNull

        // check equality long hand. there is a reason for this but I'm not telling
        if (!sameDimension(expected) || !gridsMatch(expected)) {
            failWithMessage("Expected %s but got %s", gridToString(expected), gridToString(actual))
        }
        return this
    }

    fun isNotEqualTo(expected: Array<BooleanArray>): GridAssert {
        isNotNull

        // check equality long hand. there is a reason for this but I'm not telling
        if (sameDimension(expected) && gridsMatch(expected)) {
            failWithMessage("Expected %s not to be equal to %s", gridToString(expected), gridToString(actual))
        }
        return this
    }

    fun isAliveAt(row: Int, col: Int): GridAssert {
        isNotNull
        if (!actual!![row][col]) {
            failWithMessage("Expected cell at [%s][%s] to be alive. Grid looks like %s", row, col, gridToString(actual))
        }
        return this
    }

    fun isNotAliveAt(row: Int, col: Int): GridAssert {
        isNotNull
        if (actual!![row][col]) {
            failWithMessage("Expected cell at [%s][%s] to be dead. Grid looks like %s", row, col, gridToString(actual))
        }
        return this
    }

    private fun sameDimension(expected: Array<BooleanArray>): Boolean {
        return actual!!.size == expected.size && actual!![0].size == expected[0].size
    }

    private fun gridsMatch(expected: Array<BooleanArray>): Boolean {
        for (row in expected.indices) {
            for (col in expected[0].indices) {
                if (actual!![row][col] != expected[row][col]) {
                    return false
                }
            }
        }
        return true
    }

    private fun gridToString(grid: Array<BooleanArray>): String {
        val sb = StringBuilder()
        sb.append("\n")
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col]) {
                    sb.append("*")
                } else {
                    // use + for dead cells as it formats more nicely with default eclipse font
                    // you may want to change this depending on how your IDE is setup
                    sb.append("+")
                }
            }
            sb.append("\n")
        }
        return sb.toString()
    }

    companion object {
        fun assertThat(actual: Array<BooleanArray>): GridAssert {
            return GridAssert(actual)
        }
    }
}