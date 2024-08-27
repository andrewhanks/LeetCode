package questions

import kotlin.math.abs
import kotlin.math.min


class Question_1975_Maximum_Matrix_Sum {

    companion object {

        fun runQuestion() {
//            Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
//            Output: 16
            val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(-1, -2, -3), intArrayOf(1, 2, 3))
            val result = maxMatrixSum(grid)
            println("Question 1975: $result")
        }

        fun maxMatrixSum(matrix: Array<IntArray>): Long {
            var min = Int.MAX_VALUE
            var negativeNumber = 0
            var sum = 0L
            for (i in 0..matrix.size - 1) {
                for (j in 0..matrix[i].size - 1) {
                    min = min(min, abs(matrix[i][j]))
                    sum += abs(matrix[i][j])
                    if (matrix[i][j] < 0) {
                        negativeNumber++
                    }
                }
            }
            if (negativeNumber % 2 == 0) {
                return sum
            } else {
                return sum - 2 * min
            }
        }
    }
}