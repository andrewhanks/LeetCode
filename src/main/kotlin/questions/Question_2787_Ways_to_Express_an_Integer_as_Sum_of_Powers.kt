package questions

import kotlin.math.pow

class Question_2787_Ways_to_Express_an_Integer_as_Sum_of_Powers {

    companion object {

        fun runQuestion() {
//            Input: n = 4, x = 1
//            Output: 2
            val n = 4
            val x = 1
            val result = numberOfWays(n, x)
            println("Question 2787: $result")
        }

        fun numberOfWays(n: Int, x: Int): Int {
            val mode = 1000000007
            val dp: Array<LongArray> = Array(n + 1) { LongArray(n + 1) { 0L } }
            dp[0][0] = 1L
            for (i in 0..n) {
                for (j in 1..n) {
                    val prev = j.toDouble().pow(x).toInt()
                    if (prev <= i) {
                        dp[i][j] = (dp[i][j - 1] + dp[i - prev][j - 1]) % mode
                    } else {
                        dp[i][j] = dp[i][j - 1]
                    }
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            return dp[n][n].toInt()
        }
    }
}