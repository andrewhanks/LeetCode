package questions

import java.util.*

class Question_576_Out_of_Boundary_Paths {

    companion object {

        fun runQuestion() {
//            Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//            Output: 6
            val m = 2
            val n = 2
            val maxMove = 2
            val startRow = 0
            val startColumn = 0
            val result = findPaths(m, n, maxMove, startRow, startColumn)
            println("Question 576: $result")
        }

        fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
            val mod = 1000000007
            val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
            var ans = 0L
            val queue: Queue<IntArray> = LinkedList()
            var dp = MutableList(m) { MutableList(n) { 0L } }
            dp[startRow][startColumn] = 1
            queue.add(intArrayOf(startRow, startColumn))
            for (times in 0..maxMove - 1) {
                val size = queue.size
                val newDp = MutableList(m) { MutableList(n) { 0L } }
                for (count in 0..size - 1) {
                    val pos = queue.remove()
                    for (dir in dirs) {
                        val nextX = pos[0] + dir[0]
                        val nextY = pos[1] + dir[1]
                        if (nextX < 0 || nextX > m - 1 || nextY < 0 || nextY > n - 1) {
                            ans += dp[pos[0]][pos[1]]
                            ans = ans % mod
                        } else {
                            if (newDp[nextX][nextY] == 0L) {
                                queue.add(intArrayOf(nextX, nextY))
                            }
                            newDp[nextX][nextY] += dp[pos[0]][pos[1]]
                            newDp[nextX][nextY] = newDp[nextX][nextY] % mod
                        }
                    }
                }
                dp = newDp
            }
            return ans.toInt()
        }

        var dp: Array<Array<IntArray>> = arrayOf()
        var mod = 1000000007
        fun findPathsOldSolution(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
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