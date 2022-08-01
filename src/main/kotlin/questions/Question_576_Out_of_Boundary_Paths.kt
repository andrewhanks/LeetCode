package questions

class Question_576_Out_of_Boundary_Paths {

    companion object {

        fun runQuestion() {
            val number1 = 2
            val number2 = 2
            val number3 = 2
            val number4 = 0
            val number5 = 0
            val result = findPaths(number1, number2, number3, number4, number5)
            println("Question 576: $result")
        }

        var dp: Array<Array<IntArray>> = arrayOf()
        var mod = 1000000007
        fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
            dp = Array(m) { Array(n) { IntArray(maxMove + 1) } }
            for (i in 0 until m) for (j in 0 until n) for (k in 0..maxMove) dp[i][j][k] = -1
            return findPathsAtPosition(m, n, maxMove, startRow, startColumn) % mod
        }

        private fun findPathsAtPosition(m: Int, n: Int, move: Int, r: Int, c: Int): Int {
            if (r < 0 || c < 0 || r >= m || c >= n) return 1
            if (move <= 0) return 0
            if (dp[r][c][move] != -1) return dp[r][c][move] % mod
            val pathNumberFromDown = findPathsAtPosition(m, n, move - 1, r + 1, c)
            val pathNumberFromUp = findPathsAtPosition(m, n, move - 1, r - 1, c)
            val pathNumberFromRight = findPathsAtPosition(m, n, move - 1, r, c + 1)
            val pathNumberFromLeft = findPathsAtPosition(m, n, move - 1, r, c - 1)
            dp[r][c][move] = ((pathNumberFromDown % mod + pathNumberFromUp % mod) % mod +
                    (pathNumberFromRight % mod + pathNumberFromLeft % mod) % mod) % mod
            return dp[r][c][move] % mod
        }
    }
}