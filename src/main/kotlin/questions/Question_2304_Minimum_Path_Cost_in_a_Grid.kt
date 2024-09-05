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