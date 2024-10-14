package questions

import kotlin.math.abs


class Question_2033_Minimum_Operations_to_Make_a_Uni_Value_Grid {

    companion object {

        fun runQuestion() {
//            Input: grid = [[2,4],[6,8]], x = 2
//            Output: 4
            val grid = arrayOf(intArrayOf(2, 4), intArrayOf(6, 8))
            val x = 2
            val result = minOperations(grid, x)
            println("Question 2033: $result")
        }

        fun minOperations(grid: Array<IntArray>, x: Int): Int {
            val m = grid.size
            val n = grid[0].size
            val result = MutableList<Int>(m * n) { 0 }
            for (i in 0..m - 1) {
                for (j in 0..n - 1) {
                    result[i * n + j] = grid[i][j]
                }
            }
            result.sort()
            var median = result[result.size / 2]
            var ans = 0
            for (i in 0..result.size - 1) {
                if (abs(median - result[i]) % x != 0) {
                    return -1
                }
                ans += abs(median - result[i]) / x
            }
            return ans
        }
    }
}