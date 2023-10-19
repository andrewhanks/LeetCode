package questions

import kotlin.math.max
import kotlin.math.min


class Question_221_Maximal_Square {

    companion object {

        fun runQuestion() {
//            Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//            Output: 4
            val charArray = arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0')
            )
            val result = maximalSquare(charArray)
            println("Question 221: $result")
        }

        fun maximalSquare(matrix: Array<CharArray>): Int {
            return dp(matrix)
        }

        fun dp(matrix: Array<CharArray>): Int {
            val result: Array<IntArray> = Array(matrix.size) { IntArray(matrix[0].size) { 0 } }
            var ans = 0
            for (x in 0..matrix.size - 1) {
                if (matrix[x][0] == '1') {
                    result[x][0] = 1
                    ans = 1
                }
            }
            for (y in 0..matrix[0].size - 1) {
                if (matrix[0][y] == '1') {
                    result[0][y] = 1
                    ans = 1
                }
            }
            for (x in 1..matrix.size - 1) {
                for (y in 1..matrix[0].size - 1) {
                    if (matrix[x][y] == '1') {
                        val minOfUpAndLeft = min(result[x - 1][y], result[x][y - 1])
                        result[x][y] = min(result[x - 1][y - 1], minOfUpAndLeft) + 1
                        ans = max(ans, result[x][y])
                    }
                }
            }
            return ans * ans
        }

        fun maximalSquareSlow(matrix: Array<CharArray>): Int {
            if (matrix.size == 0) {
                return 0
            }
            var maxSquareSize = 0
            val minLength = min(matrix.size, matrix[0].size)
            Loop@ for (count in 1..minLength) {
                for (x in 0..matrix.size - count) {
                    for (y in 0..matrix[0].size - count) {
                        var isAllOne = true
                        for (squareSizeX in 0..count - 1) {
                            for (squareSizeY in 0..count - 1) {
                                if (matrix[x + squareSizeX][y + squareSizeY] != '1') {
                                    isAllOne = false
                                }
                            }
                        }
                        if (isAllOne) {
                            maxSquareSize = count
                            continue@Loop
                        }
                    }
                }
            }
            return maxSquareSize * maxSquareSize
        }
    }
}