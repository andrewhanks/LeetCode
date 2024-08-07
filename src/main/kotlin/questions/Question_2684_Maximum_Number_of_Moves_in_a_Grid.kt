package questions

import kotlin.math.max


class Question_2684_Maximum_Number_of_Moves_in_a_Grid {

    companion object {

        fun runQuestion() {
//            Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
//            Output: 3
            val grid = arrayOf(
                intArrayOf(2, 4, 3, 5),
                intArrayOf(5, 4, 9, 3),
                intArrayOf(3, 4, 2, 11),
                intArrayOf(10, 9, 13, 15)
            )
            val result = maxMoves(grid)
            println("Question 2684: $result")
        }

        fun maxMoves(grid: Array<IntArray>): Int {
            val result = Array(grid.size) { IntArray(grid[0].size) { 0 } }
            var max = 0
            for (y in 1..grid[0].size - 1) {
                for (x in 0..grid.size - 1) {
                    dp(grid, x, y, result)
                    max = max(max, result[x][y])
                }
                if (max == 0) {
                    return 0
                }
            }
            println("result = ${result.contentDeepToString()}")
            return max
        }

        fun dp(grid: Array<IntArray>, x: Int, y: Int, result: Array<IntArray>) {
            val topLeft = if (x >= 1 && grid[x][y] > grid[x - 1][y - 1]) {
                if (y > 1 && result[x - 1][y - 1] == 0) {
                    0
                } else {
                    result[x - 1][y - 1] + 1
                }
            } else {
                0
            }
            val left = if (grid[x][y] > grid[x][y - 1]) {
                if (y > 1 && result[x][y - 1] == 0) {
                    0
                } else {
                    result[x][y - 1] + 1
                }
            } else {
                0
            }
            val bottomLeft = if (x <= grid.size - 2 && grid[x][y] > grid[x + 1][y - 1]) {
                if (y > 1 && result[x + 1][y - 1] == 0) {
                    0
                } else {
                    result[x + 1][y - 1] + 1
                }
            } else {
                0
            }
            result[x][y] = max(left, max(topLeft, bottomLeft))
        }

        var dirs = intArrayOf(-1, 0, 1)
        var m = 0
        var n: Int = 0
        var max: Int = 0

        fun maxMovesOldSolution(grid: Array<IntArray>): Int {
            m = grid.size
            n = grid[0].size
            var dp: Array<IntArray> = Array(m) { IntArray(n) { -1 } }
            for (i in 0 until m) max = max(max, maxMoves(grid, i, 0, dp))
            return max
        }

        private fun maxMoves(grid: Array<IntArray>, x: Int, y: Int, dp: Array<IntArray>): Int {
            if (y == n - 1) return 0
            if (dp[x][y] != -1) return dp[x][y]
            dp[x][y] = 0
            for (dir in dirs) {
                val x2 = x + dir
                if (x2 < 0 || x2 == m) continue
                if (grid[x2][y + 1] > grid[x][y])
                    dp[x][y] = max(dp[x][y], (1 + maxMoves(grid, x2, y + 1, dp)))
            }
            return dp[x][y]
        }
    }
}