package questions

import kotlin.math.max
import kotlin.math.min

class Question_583_Delete_Operation_for_Two_Strings {

    companion object {

        fun runQuestion() {
//            Input: word1 = "sea", word2 = "eat"
//            Output: 2
            val word1 = "sea"
            val word2 = "eat"
            val result = minDistance(word1, word2)
            println("Question 583: $result")
        }

        fun minDistance(word1: String, word2: String): Int {
            val dp = Array(word1.length + 1) { IntArray(word2.length + 1) { 0 } }
            for (i in 1..dp.size - 1) {
                for (j in 1..dp[0].size - 1) {
                    var current = 0
                    if (word1[i - 1] == word2[j - 1]) {
                        current = max(current, dp[i - 1][j - 1] + 1)
                    } else {
                        current = max(dp[i - 1][j], dp[i][j - 1])
                    }
                    dp[i][j] = current
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            return word1.length + word2.length - 2 * dp[dp.size - 1][dp[0].size - 1]
        }

        fun minDistanceOldSolution(word1: String, word2: String): Int {
            val result = Array(word1.length + 1) { IntArray(word2.length + 1) { 0 } }
            for (i in 0..word1.length) {
                result[i][0] = i
            }
            for (j in 0..word2.length) {
                result[0][j] = j
            }
            for (i in 1..word1.length) {
                for (j in 1..word2.length) {
                    if (word1[i - 1] == word2[j - 1]) {
                        result[i][j] = result[i - 1][j - 1]
                    } else {
                        result[i][j] = min(result[i - 1][j], result[i][j - 1]) + 1
                    }
                }
            }
            return result[word1.length][word2.length]
        }
    }
}