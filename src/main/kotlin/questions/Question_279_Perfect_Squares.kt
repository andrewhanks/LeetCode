package questions

import kotlin.math.min

class Question_279_Perfect_Squares {

    companion object {

        fun runQuestion() {
//            Input: n = 12
//            Output: 3
            val n = 12
            val result = numSquares(n)
            println("Question 279: $result")
        }

        fun numSquares(n: Int): Int {
            val dp = IntArray(n + 1) { -1 }
            return dfs(n, dp)
        }

        fun dfs(n: Int, dp: IntArray): Int {
            if (n <= 0) return 0
            if (dp[n] != -1) return dp[n]

            var ans = n
            var i = 1
            while (i * i <= n) {
                ans = min(ans, (1 + dfs(n - i * i, dp)))
                i++
            }
            dp[n] = ans
            return dp[n]
        }
    }
}