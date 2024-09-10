package questions

import kotlin.math.min


class Question_2304_Minimum_Path_Cost_in_a_Grid {

    companion object {

        fun runQuestion() {
//            Input: grid = [[5,3],[4,0],[2,1]], moveCost = [[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]
//            Output: 17
            val grid = arrayOf(intArrayOf(5, 3), intArrayOf(4, 0), intArrayOf(2, 1))
            val moveCost = arrayOf(
                intArrayOf(9, 8),
                intArrayOf(1, 5),
                intArrayOf(10, 12),
                intArrayOf(18, 6),
                intArrayOf(2, 4),
                intArrayOf(14, 3)
            )
            val result = minPathCost(grid, moveCost)
            println("Question 2304: $result")
        }

        fun minPathCost(grid: Array<IntArray>, moveCost: Array<IntArray>): Int {
            val dp = Array(grid.size) { IntArray(grid[0].size) { -1 } }
            for (count in 0..grid[0].size - 1) {
                dp[0][count] = grid[0][count]
            }
            dp(grid, moveCost, dp, 1)
            // println("dp = ${dp.contentDeepToString()}")
            return dp[dp.size - 1].min()
        }

        fun dp(grid: Array<IntArray>, moveCost: Array<IntArray>, dp: Array<IntArray>, x: Int) {
            if (x > grid.size - 1) {
                return
            }
            for (i in 0..grid[x].size - 1) {
                var min = Int.MAX_VALUE
                for (j in 0..grid[x - 1].size - 1) {
                    val node = grid[x - 1][j]
                    min = min(min, dp[x - 1][j] + moveCost[node][i])
                }
                dp[x][i] = min + grid[x][i]
            }
            dp(grid, moveCost, dp, x + 1)
        }

        fun minPathCostWithIterative(grid: Array<IntArray>, moveCost: Array<IntArray>): Int {
            var result = IntArray(grid[0].size) { 0 }
            for (i in 0..grid.size - 2) {
                val temp = MutableList<Int>(grid[0].size) { -1 }
                for (j in 0..grid[0].size - 1) {
                    for (k in 0..grid[0].size - 1) {
                        if (temp[k] == -1) {
                            temp[k] = result[j] + grid[i][j] + moveCost[grid[i][j]][k]
                        } else {
                            temp[k] = min(temp[k], result[j] + grid[i][j] + moveCost[grid[i][j]][k])
                        }
                    }
                }
                result = temp.toIntArray()
            }
            for (count in 0..result.size - 1) {
                result[count] = result[count] + grid[grid.size - 1][count]
            }
            return result.min()
        }
    }
}