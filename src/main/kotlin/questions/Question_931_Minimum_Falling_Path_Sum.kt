package questions

import kotlin.math.min


class Question_931_Minimum_Falling_Path_Sum {

    companion object {

        fun runQuestion() {
//            Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//            Output: 13
            val grid = arrayOf(intArrayOf(2, 1, 3), intArrayOf(6, 5, 4), intArrayOf(7, 8, 9))
            val result = minFallingPathSum(grid)
            println("Question 931: $result")
        }

        fun minFallingPathSum(matrix: Array<IntArray>): Int {
            val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(-1, -1), intArrayOf(-1, 1))
            val result = Array(matrix.size) { IntArray(matrix[0].size) { 0 } }
            for (count in 0..matrix[0].size - 1) {
                result[0][count] = matrix[0][count]
            }
            for (x in 1..matrix.size - 1) {
                for (y in 0..matrix[0].size - 1) {
                    var min = Int.MAX_VALUE
                    for (dir in dirs) {
                        val prevX = x + dir[0]
                        val prevY = y + dir[1]
                        if (prevY < 0 || prevY > matrix[0].size - 1) {
                            continue
                        }
                        min = min(min, result[prevX][prevY] + matrix[x][y])
                    }
                    result[x][y] = min
                }
            }
            // println("result = ${result.contentDeepToString()}")
            var ans = Int.MAX_VALUE
            for (count in 0..matrix[0].size - 1) {
                ans = min(ans, result[result.size - 1][count])
            }
            return ans
        }
    }
}