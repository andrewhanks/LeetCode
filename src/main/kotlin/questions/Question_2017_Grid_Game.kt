package questions

import kotlin.math.max
import kotlin.math.min


class Question_2017_Grid_Game {

    companion object {

        fun runQuestion() {
//            Input: grid = [[2,5,4],[1,5,1]]
//            Output: 4
            val grid = arrayOf(intArrayOf(2, 5, 4), intArrayOf(1, 5, 1))
            val result = gridGame(grid)
            println("Question 2017: $result")
        }

        fun gridGame(grid: Array<IntArray>): Long {
            var row1Total = 0L
            for (i in 0..grid[0].size - 1) {
                row1Total += grid[0][i]
            }
            var row2Total = 0L
            for (i in 0..grid[1].size - 1) {
                row2Total += grid[1][i]
            }
            var row1NotPick: Long = 0L
            var row2Pick: Long = grid[1][grid[1].size - 1].toLong()
            var ans: Long = row2Total - row2Pick
            // println("row1Total = $row1Total, row2Total = $row2Total, row1NotPick = $row1NotPick, row2Pick = $row2Pick, ans = $ans")
            for (i in grid[0].size - 2 downTo 0) {
                row1NotPick += grid[0][i + 1]
                row2Pick += grid[1][i]
                ans = min(ans, max(row1NotPick, row2Total - row2Pick))
                // println("row1NotPick = $row1NotPick, row2Pick = $row2Pick, ans = $ans")
            }
            return ans
        }
    }
}