package questions

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


class Question_2400_Number_of_Ways_to_Reach_a_Position_After_Exactly_k_Steps {

    companion object {

        fun runQuestion() {
//            Input: startPos = 1, endPos = 2, k = 3
//            Output: 3
            val startPos = 1
            val endPos = 2
            val k = 3
            val result = numberOfWays(startPos, endPos, k)
            println("Question 2400: $result")
        }

        fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {
            val mod = 1000000007
            val distance = abs(endPos - startPos)
            if (k < distance || (k - distance) % 2 == 1) {
                return 0
            }
            val minPos = min(startPos, endPos) - (k - distance) / 2
            val maxPos = max(startPos, endPos) + (k - distance) / 2
            val result = Array(k + 1) { LongArray(maxPos - minPos + 1) { 0L } }
            // println("minPos = $minPos, maxPos = $maxPos, startPos = $startPos, endPos = $endPos")
            for (i in 0..maxPos - minPos) {
                if (i + minPos == startPos) {
                    result[0][i] = 1L
                }
            }
            var sum = 0L
            for (i in 1..k) {
                for (j in 0..maxPos - minPos) {
                    sum = 0L
                    if (j - 1 >= 0) {
                        sum = result[i - 1][j - 1]
                    }
                    if (j + 1 <= result[i].size - 1) {
                        sum += result[i - 1][j + 1]
                    }
                    result[i][j] = sum % mod
                }
            }
            // println("result = ${result.contentDeepToString()}")
            return result[k][endPos - minPos].toInt()
        }
    }
}