package questions

import kotlin.math.max


class Question_3290_Maximum_Multiplication_Score {

    companion object {

        fun runQuestion() {
//            Input: a = [3,2,5,6], b = [2,-6,4,-5,-3,2,-7]
//            Output: 26
            val a = intArrayOf(3, 2, 5, 6)
            val b = intArrayOf(2, -6, 4, -5, -3, 2, -7)
            val result = maxScore(a, b)
            println("Question 3290: $result")
        }

        fun maxScore(a: IntArray, b: IntArray): Long {
            val result = Array(a.size) { LongArray(b.size) { Long.MIN_VALUE } }
            result[0][0] = a[0] * b[0].toLong()
            for (count in 1..result[0].size - 1) {
                result[0][count] = max(result[0][count - 1], a[0] * b[count].toLong())
            }
            for (i in 1..result.size - 1) {
                for (j in i..result[0].size - 1) {
                    result[i][j] = max(result[i][j - 1], result[i - 1][j - 1] + a[i] * b[j].toLong())
                }
            }
            // println("result = ${result.contentDeepToString()}")
            return result[a.size - 1][b.size - 1]
        }
    }
}