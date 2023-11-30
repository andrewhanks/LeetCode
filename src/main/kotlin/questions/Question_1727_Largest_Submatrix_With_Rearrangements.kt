package questions

import kotlin.math.max


class Question_1727_Largest_Submatrix_With_Rearrangements {

    companion object {

        fun runQuestion() {
//            Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
//            Output: 4
            val matrix = arrayOf(intArrayOf(0, 0, 1), intArrayOf(1, 1, 1), intArrayOf(1, 0, 1))
            val result = largestSubmatrix(matrix)
            println("Question 1727: $result")
        }

        fun largestSubmatrix(matrix: Array<IntArray>): Int {
            for (x in 0..matrix.size - 1) {
                if (matrix.size == 1) {
                    break
                }
                for (y in 0..matrix[0].size - 1) {
                    if (x >= 1 && matrix[x][y] == 1) {
                        matrix[x][y] = matrix[x - 1][y] + 1
                    }
                }
            }
            var max = 0
            for (x in 0..matrix.size - 1) {
                val sortedRow = matrix[x].sortedDescending()
                for (y in 0..sortedRow.size - 1) {
                    max = max(max, (y + 1) * sortedRow[y])
                }
            }
            return max
        }
    }
}