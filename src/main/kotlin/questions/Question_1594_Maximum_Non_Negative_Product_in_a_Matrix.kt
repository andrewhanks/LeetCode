package questions

import kotlin.math.max
import kotlin.math.min


class Question_1594_Maximum_Non_Negative_Product_in_a_Matrix {

    companion object {

        fun runQuestion() {
//            Input: grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
//            Output: 8
            val grid = arrayOf(intArrayOf(1, -2, 1), intArrayOf(1, -2, 1), intArrayOf(3, -4, 1))
            val result = maxProductPath(grid)
            println("Question 1594: $result")
        }

        fun maxProductPath(grid: Array<IntArray>): Int {
            val mod = 1000000007
            val m = grid.size
            val n = grid[0].size
            val dpMax = Array(m) { LongArray(n) { 0L } }
            val dpMin = Array(m) { LongArray(n) { 0L } }
            dpMax[0][0] = grid[0][0].toLong()
            dpMin[0][0] = grid[0][0].toLong()
            for (j in 1..n - 1) {
                dpMax[0][j] = dpMax[0][j - 1] * grid[0][j]
                dpMin[0][j] = dpMin[0][j - 1] * grid[0][j]
            }
            for (i in 1..m - 1) {
                dpMax[i][0] = dpMax[i - 1][0] * grid[i][0]
                dpMin[i][0] = dpMin[i - 1][0] * grid[i][0]
            }
            for (i in 1..m - 1) {
                for (j in 1..n - 1) {
                    dpMax[i][j] = max(
                        max(dpMax[i - 1][j] * grid[i][j], dpMin[i - 1][j] * grid[i][j]),
                        max(dpMax[i][j - 1] * grid[i][j], dpMin[i][j - 1] * grid[i][j])
                    )
                    dpMin[i][j] = min(
                        min(dpMax[i - 1][j] * grid[i][j], dpMin[i - 1][j] * grid[i][j]),
                        min(dpMax[i][j - 1] * grid[i][j], dpMin[i][j - 1] * grid[i][j])
                    )
                }
            }
            val result = dpMax[m - 1][n - 1] % mod
            return if (result < 0L) {
                -1
            } else {
                result.toInt()
            }
        }
    }
}