package questions

import java.util.*
import kotlin.math.min


class Question_1289_Minimum_Falling_Path_Sum_II {

    companion object {

        fun runQuestion() {
//            Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
//            Output: 13
            val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
            val result = minFallingPathSum(grid)
            println("Question 1289: $result")
        }

        fun minFallingPathSum(grid: Array<IntArray>): Int {
            val dp = Array(grid.size) { IntArray(grid[0].size) { 0 } }
            for (j in 0..grid[0].size - 1) {
                dp[0][j] = grid[0][j]
            }
            for (i in 1..grid.size - 1) {
                for (j in 0..grid[0].size - 1) {
                    var min = Int.MAX_VALUE
                    for (count in 0..grid[0].size - 1) {
                        if (j == count) {
                            continue
                        }
                        min = min(min, grid[i][j] + dp[i - 1][count])
                    }
                    dp[i][j] = min
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            val ans = dp[dp.size - 1].min()
            return ans
        }

        fun minFallingPathSumQuicker(grid: Array<IntArray>): Int {
            val dp = Array(grid.size) { IntArray(grid[0].size) { 0 } }
            val queue = PriorityQueue<IntArray> { a, b ->
                a[1] - b[1]
            }
            for (j in 0..grid[0].size - 1) {
                dp[0][j] = grid[0][j]
                queue.add(intArrayOf(j, grid[0][j]))
            }
            for (i in 1..grid.size - 1) {
                val first = queue.remove()
                val second = queue.remove()
                queue.clear()
                for (j in 0..grid[0].size - 1) {
                    var min = Int.MAX_VALUE
                    if (first[0] == j) {
                        min = second[1] + grid[i][j]
                    } else {
                        min = first[1] + grid[i][j]
                    }
                    dp[i][j] = min
                    queue.add(intArrayOf(j, min))
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            val ans = dp[dp.size - 1].min()
            return ans
        }
    }
}