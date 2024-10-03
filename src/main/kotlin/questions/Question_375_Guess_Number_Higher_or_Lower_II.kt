package questions

import kotlin.math.max
import kotlin.math.min

class Question_375_Guess_Number_Higher_or_Lower_II {

    companion object {

        fun runQuestion() {
//            Input: n = 10
//            Output: 16
            val n = 10
            val result = getMoneyAmount(n)
            println("Question 375: $result")
        }

        fun getMoneyAmount(n: Int): Int {
            val dp = Array(n + 2) { IntArray(n + 2) { 0 } }
            for (len in 1..n) {
                for (i in 1..n - len + 1) {
                    if (len == 1) {
                        dp[i][i] = 0
                        continue
                    }
                    val j = i + len - 1
                    var min = Int.MAX_VALUE
                    for (k in i..j) {
                        val current = max(dp[i][k - 1], dp[k + 1][j]) + k
                        min = min(min, current)
                    }
                    dp[i][j] = min
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            return dp[1][n]
        }
    }
}