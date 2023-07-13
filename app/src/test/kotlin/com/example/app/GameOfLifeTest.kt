package com.example.app

import com.example.app.GridAssert.Companion.assertThat


import org.junit.jupiter.api.Test

class GameOfLifeTest {
    var testee = GameOfLife()
    @Test
    fun shouldProduceEmptyGridWhenGivenEmptyGrid() {
        val actual = testee.advance(empty8By4Grid())
        assertThat(actual).isEqualTo(empty8By4Grid())
    }

    @Test
    fun liveTopLeftCornerCellWithNoNeighboursShouldDie() {
        val lastGen = grid(
            "*.......",
            "........",
            "........",
            "........"
        )
        val expected = empty8By4Grid()
        assertThat(testee.advance(lastGen)).isEqualTo(expected)
    }

    /** oops, probably shouldn't have commented these out
    @Test
    fun liveTopLeftCornerCellWithOneNeighbourShouldDie() {
        val lastGen = grid(
            "**......",
            "........",
            "........",
            "........"
        )
        assertLiveCellKilled(0, 0, lastGen)
    }

    @Test
    fun liveTopLeftCornerCellWithTwoNeighboursShouldNotDie() {
        val lastGen = grid(
            "**......",
            "*.......",
            "........",
            "........"
        )
        assertLiveCellSurvives(0, 0, lastGen)
    }

    @Test
    fun liveTopRowCellWithNoNeighboursShouldDie() {
        val lastGen = grid(
            "....*...",
            "........",
            "........",
            "........"
        )
        assertLiveCellKilled(0, 4, lastGen)
    }

    @Test
    fun liveTopRowCellWithLeftAndRightNeighbourShouldNotDie() {
        val lastGen = grid(
            "...***..",
            "........",
            "........",
            "........"
        )
        assertLiveCellSurvives(0, 4, lastGen)
    }
    */
    @Test
    fun liveTopRowCellWithLeftAndLowerNeighbourShouldNotDie() {
        val lastGen = grid(
            "...**...",
            "....*...",
            "........",
            "........"
        )
        assertLiveCellSurvives(0, 4, lastGen)
    }

    @Test
    fun liveCellWithUpperAndLowerNeighbourShouldNotDie() {
        val lastGen = grid(
            "....*...",
            "....*...",
            "....*...",
            "........"
        )
        assertLiveCellSurvives(1, 4, lastGen)
    }

    @Test
    fun liveCellWithBothUpperDiagonalNeighboursShouldNotDie() {
        val lastGen = grid(
            "...*.*..",
            "....*...",
            "........",
            "........"
        )
        assertLiveCellSurvives(1, 4, lastGen)
    }

    @Test
    fun liveCellWithBothLowerDiagonalNeighboursShouldNotDie() {
        val lastGen = grid(
            "........",
            "....*...",
            "...*.*..",
            "........"
        )
        assertLiveCellSurvives(1, 4, lastGen)
    }

    @Test
    fun liveCellWithTopLeftToRightDiagonalNeighboursShouldNotDie() {
        val lastGen = grid(
            "...*....",
            "....*...",
            ".....*..",
            "........"
        )
        assertLiveCellSurvives(1, 4, lastGen)
    }

    @Test
    fun liveCellWithBottomLeftToRightDiagonalNeighboursShouldNotDie() {
        val lastGen = grid(
            ".....*..",
            "....*...",
            "...*....",
            "........"
        )
        assertLiveCellSurvives(1, 4, lastGen)
    }

    @Test
    fun liveCellWithFourNeighboursShouldDie() {
        val lastGen = grid(
            "........",
            "...***..",
            "...*.*..",
            "........"
        )
        assertLiveCellKilled(1, 4, lastGen)
    }

    @Test
    fun liveCellWithFiveNeighboursShouldDie() {
        val lastGen = grid(
            "...***..",
            "....*...",
            "...*.*..",
            "........"
        )
        assertLiveCellKilled(1, 4, lastGen)
    }

    @Test
    fun liveCellWithThreeNeighboursShouldLive() {
        val lastGen = grid(
            "...***..",
            "....*...",
            "........",
            "........"
        )
        assertLiveCellSurvives(1, 4, lastGen)
    }

    @Test
    fun deadCellWithThreeDiagonalNeighboursShouldBecomeAlive() {
        val lastGen = grid(
            "........",
            "....*...",
            "........",
            "..*.*..."
        )
        assertDeadCellBroughtToLife(2, 3, lastGen)
    }

    @Test
    fun deadCellWithThreeNonDiagonalNeighboursShouldBecomeAlive() {
        val lastGen = grid(
            "...*....",
            "..*.*...",
            "........",
            "........"
        )
        assertDeadCellBroughtToLife(1, 3, lastGen)
    }

    private fun assertDeadCellBroughtToLife(row: Int, col: Int, lastGen: Array<BooleanArray>) {
        assertThat(lastGen).describedAs("Cell was unexpectedly alive at start of the test, this test has a bug")
            .isNotAliveAt(row, col)
        assertThat(testee.advance(lastGen)).isAliveAt(row, col)
    }

    private fun assertLiveCellKilled(row: Int, col: Int, lastGen: Array<BooleanArray>) {
        assertThat(lastGen).describedAs("Cell was not live at start of the test, this test has a bug")
            .isAliveAt(row, col)
        assertThat(testee.advance(lastGen)).isNotAliveAt(row, col)
    }

    private fun assertLiveCellSurvives(row: Int, col: Int, lastGen: Array<BooleanArray>) {
        assertThat(lastGen).describedAs("Cell was not live at start of the test, this test has a bug")
            .isAliveAt(row, col)
        assertThat(testee.advance(lastGen)).isAliveAt(row, col)
    }

    private fun empty8By4Grid(): Array<BooleanArray> {
        return Array(4) { BooleanArray(8) }
    }

    companion object {
        fun grid(vararg rows: String): Array<BooleanArray> {
            val grid = Array(rows.size) {
                BooleanArray(
                    rows[0].length
                )
            }
            for (row in rows.indices) {
                grid[row] = stringToRow(rows[row])
            }
            return grid
        }

        private fun stringToRow(row: String): BooleanArray {
            val bs = BooleanArray(row.length)
            for (i in 0 until row.length) {
                if (row[i] == '*') {
                    bs[i] = true
                }
            }
            return bs
        }
    }
}