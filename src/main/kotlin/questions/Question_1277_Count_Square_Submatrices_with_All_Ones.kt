package questions

import kotlin.math.min


class Question_1277_Count_Square_Submatrices_with_All_Ones {

    companion object {

        fun runQuestion() {
//            Input: matrix =
//            [
//                [0,1,1,1],
//                [1,1,1,1],
//                [0,1,1,1]
//            ]
//            Output: 15
            val matrix = arrayOf(intArrayOf(0, 1, 1, 1), intArrayOf(1, 1, 1, 1), intArrayOf(0, 1, 1, 1))
            val result = countSquares(matrix)
            println("Question 1277: $result")
        }

        fun countSquares(matrix: Array<IntArray>): Int {
            val dp = Array(matrix.size) { IntArray(matrix[0].size) { 0 } }
            val allOnes = Array(matrix.size) { IntArray(matrix[0].size) { 0 } }
            if (matrix[0][0] == 1) {
                dp[0][0] = 1
                allOnes[0][0] = 1
            } else {
                dp[0][0] = 0
                allOnes[0][0] = 0
            }
            for (count in 1..matrix.size - 1) {
                if (matrix[count][0] == 1) {
                    dp[count][0] = dp[count - 1][0] + 1
                    allOnes[count][0] = 1
                } else {
                    dp[count][0] = dp[count - 1][0]
                    allOnes[count][0] = 0
                }
            }
            for (count in 1..matrix[0].size - 1) {
                if (matrix[0][count] == 1) {
                    dp[0][count] = dp[0][count - 1] + 1
                    allOnes[0][count] = 1
                } else {
                    dp[0][count] = dp[0][count - 1]
                    allOnes[0][count] = 0
                }
            }
            for (i in 1..dp.size - 1) {
                for (j in 1..dp[i].size - 1) {
                    if (matrix[i][j] == 0) {
                        allOnes[i][j] = 0
                    } else {
                        allOnes[i][j] = min(allOnes[i - 1][j - 1], min(allOnes[i - 1][j], allOnes[i][j - 1])) + 1
                    }
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + allOnes[i][j]
                }
            }
            // println("allOnes = ${allOnes.contentDeepToString()}, dp = ${dp.contentDeepToString()}")
            return dp[dp.size - 1][dp[0].size - 1]
        }
    }
}