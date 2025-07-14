package questions

class Question_1510_Stone_Game_IV {

    companion object {

        fun runQuestion() {
//            Input: n = 4
//            Output: true
            val n = 4
            val result = winnerSquareGame(n)
            println("Question 1510: $result")
        }

        fun winnerSquareGame(n: Int): Boolean {
            val dp = Array(n + 1) { false }
            dp[0] = false
            for (i in 1..n) {
                var temp = 1
                while (temp * temp <= i) {
                    if (!dp[i - temp * temp]) {
                        dp[i] = true
                        break
                    }
                    temp++
                }
            }
            return dp[n]
        }

        fun winnerSquareGameRecursive(n: Int): Boolean {
            val dp = IntArray(n + 1) { -1 }
            return recursive(n, dp)
        }

        fun recursive(n: Int, dp: IntArray): Boolean {
            if (dp[n] != -1) {
                return if (dp[n] == 0) {
                    false
                } else {
                    true
                }
            }
            var temp = 1
            while (temp * temp <= n) {
                if (!recursive(n - temp * temp, dp)) {
                    dp[n] = 1
                    return true
                }
                temp++
            }
            dp[n] = 0
            return false
        }
    }
}