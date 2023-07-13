package com.example.app

class GameOfLife {
    fun advance(grid: Array<BooleanArray>): Array<BooleanArray> {
        val next = copy(grid)
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                val count = neighbourCount(row, col, grid)
                if (count > 3 || count < 2) {
                    next[row][col] = false
                } else if (count == 3) {
                    next[row][col] = true
                }
            }
        }
        return next
    }

    private fun copy(grid: Array<BooleanArray>): Array<BooleanArray> {
        val next = Array(grid.size) {
            BooleanArray(
                grid[0].size
            )
        }
        for (row in grid.indices) {
            next[row] = grid[row].copyOf(grid[row].size)
        }
        return next
    }

    private fun neighbourCount(row: Int, col: Int, grid: Array<BooleanArray>): Int {
        return (countCell(row, col + 1, grid)
                + countCell(row, col - 1, grid)
                + countCell(row + 1, col - 1, grid)
                + countCell(row + 1, col, grid)
                + countCell(row + 1, col + 1, grid)
                + countCell(row - 1, col - 1, grid)
                + countCell(row - 1, col, grid)
                + countCell(row - 1, col + 1, grid))
    }

    private inline fun countCell(row: Int, col: Int, grid: Array<BooleanArray>): Int {
        return if (!isLive(row, col, grid)) {
            0
        } else 1
    }

    private fun isLive(row: Int, col: Int, grid: Array<BooleanArray>): Boolean {
        return if (row < 0 || col < 0 || row == grid.size || col == grid[0].size) {
            false
        } else grid[row][col]
    }
}