package questions

class Question_935_Knight_Dialer {

    companion object {

        fun runQuestion() {
//            Input: n = 3131
//            Output: 136006598
            val input = 3131
            val result = knightDialer(input)
            println("Question 935: $result")
        }

        fun knightDialer(n: Int): Int {
            val mod = 1000000007
            val dirs = arrayOf(
                intArrayOf(-2, 1), intArrayOf(-1, 2), intArrayOf(1, 2), intArrayOf(2, 1),
                intArrayOf(2, -1), intArrayOf(1, -2), intArrayOf(-1, -2), intArrayOf(-2, -1)
            )
            var dp = MutableList(4) { MutableList(3) { 1L } }
            dp[3][0] = 0
            dp[3][2] = 0
            for (i in 1..n - 1) {
                val newDp = MutableList(4) { MutableList(3) { 0L } }
                for (j in 0..dp.size - 1) {
                    for (k in 0..dp[0].size - 1) {
                        for (dir in dirs) {
                            val nextX = j + dir[0]
                            val nextY = k + dir[1]
                            if (nextX < 0 || nextX > dp.size - 1 || nextY < 0 || nextY > dp[0].size - 1 ||
                                (nextX == 3 && nextY == 0) || (nextX == 3 && nextY == 2)
                            ) {
                                continue
                            }
                            newDp[nextX][nextY] += dp[j][k]
                            newDp[nextX][nextY] = newDp[nextX][nextY] % mod
                        }
                    }
                }
                dp = newDp.toMutableList()
            }
            var ans = 0L
            for (i in 0..dp.size - 1) {
                for (j in 0..dp[0].size - 1) {
                    ans += dp[i][j]
                    ans %= mod
                }
            }
            return ans.toInt()
        }

        fun knightDialerAnotherSolution(n: Int): Int {
            val mod = 1000000007
            var dp = MutableList(10) { 1L }
            for (i in 1..n - 1) {
                val newDp = MutableList(10) { 0L }
                newDp[0] = (dp[4] + dp[6]) % mod
                newDp[1] = (dp[6] + dp[8]) % mod
                newDp[2] = (dp[7] + dp[9]) % mod
                newDp[3] = (dp[4] + dp[8]) % mod
                newDp[4] = ((dp[0] + dp[3]) % mod + dp[9]) % mod
                newDp[5] = 0
                newDp[6] = ((dp[0] + dp[1]) % mod + dp[7]) % mod
                newDp[7] = (dp[2] + dp[6]) % mod
                newDp[8] = (dp[1] + dp[3]) % mod
                newDp[9] = (dp[2] + dp[4]) % mod
                dp = newDp
            }
            var ans = 0L
            for (count in 0..9) {
                ans += dp[count]
                ans = ans % mod
            }
            return ans.toInt()
        }
    }
}