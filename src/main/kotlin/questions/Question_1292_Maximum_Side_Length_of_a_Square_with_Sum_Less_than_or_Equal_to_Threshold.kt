package questions

import kotlin.math.min


class Question_1292_Maximum_Side_Length_of_a_Square_with_Sum_Less_than_or_Equal_to_Threshold {

    companion object {

        fun runQuestion() {
//            Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
//            Output: 2
            val mat = arrayOf(
                intArrayOf(1, 1, 3, 2, 4, 3, 2),
                intArrayOf(1, 1, 3, 2, 4, 3, 2),
                intArrayOf(1, 1, 3, 2, 4, 3, 2)
            )
            val threshold = 4
            val result = maxSideLength(mat, threshold)
            println("Question 1292: $result")
        }

        fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
            val presum = Array(mat.size + 1) { IntArray(mat[0].size + 1) { 0 } }
            for (i in 1..mat.size) {
                for (j in 1..mat[0].size) {
                    presum[i][j] = presum[i - 1][j] + presum[i][j - 1] - presum[i - 1][j - 1] + mat[i - 1][j - 1]
                }
            }
            // println("presum = ${presum.contentDeepToString()}")
            var start = 0
            var end = min(mat.size, mat[0].size)
            while (start < end) {
                val mid = end - (end - start) / 2
                // println("start = $start, end = $end, mid = $mid")
                if (check(presum, mid, threshold)) {
                    start = mid
                } else {
                    end = mid - 1
                }
            }
            return start
        }

        fun check(presum: Array<IntArray>, n: Int, threshold: Int): Boolean {
            for (i in n..presum.size - 1) {
                for (j in n..presum[0].size - 1) {
                    val sum = presum[i][j] - presum[i - n][j] - presum[i][j - n] + presum[i - n][j - n]
                    // println("i = $i, j = $j, sum = $sum")
                    if (sum <= threshold) {
                        return true
                    }
                }
            }
            return false
        }
    }
}