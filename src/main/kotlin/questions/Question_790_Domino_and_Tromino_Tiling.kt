package questions

class Question_790_Domino_and_Tromino_Tiling {

    companion object {

        fun runQuestion() {
//            Input: n = 3
//            Output: 5
            val n = 3
            val result = numTilings(n)
            println("Question 790: $result")
        }

        fun numTilings(n: Int): Int {
            val mod = 1000000007
            val dp = Array(n + 1) { 0L }
            dp[0] = 1
            dp[1] = 1
            for (i in 2..dp.size - 1) {
                var current = 0L
                for (j in i - 1 downTo 0) {
                    val increased = if (i - j <= 2) {
                        dp[j]
                    } else {
                        dp[j] * 2
                    }
                    current += increased
                    current = current % mod
                }
                dp[i] = current
            }
            // println("dp = ${dp.contentToString()}")
            return dp[dp.size - 1].toInt()
        }

        fun numTilingsQuicker(n: Int): Int {
            val mod = 1000000007
            val dp = Array(n + 1) { 0L }
            dp[0] = 1
            dp[1] = 1
            var current = 0L
            for (i in 2..dp.size - 1) {
                dp[i] = (2 * current + dp[i - 1] + dp[i - 2]) % mod
                current = (current + dp[i - 2]) % mod
            }
            // println("dp = ${dp.contentToString()}")
            return dp[dp.size - 1].toInt()
        }
    }
}