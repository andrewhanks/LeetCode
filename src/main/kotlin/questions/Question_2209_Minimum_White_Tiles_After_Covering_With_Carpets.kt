package questions

import kotlin.math.max
import kotlin.math.min

class Question_2209_Minimum_White_Tiles_After_Covering_With_Carpets {

    companion object {

        fun runQuestion() {
//            Input: floor = "10110101", numCarpets = 2, carpetLen = 2
//            Output: 2
            val floor = "10110101"
            val numCarpets = 2
            val carpetLen = 2
            val result = minimumWhiteTiles(floor, numCarpets, carpetLen)
            println("Question 2209: $result")
        }

        fun minimumWhiteTiles(floor: String, numCarpets: Int, carpetLen: Int): Int {
            val n = floor.length
            val dp = Array(n + 1) { IntArray(numCarpets + 1) }
            for (i in 1..n) {
                for (k in 0..numCarpets) {
                    val jump = dp[i - 1][k] + floor[i - 1].toInt() - '0'.toInt()
                    val cover = if (k > 0) dp[max((i - carpetLen).toDouble(), 0.0).toInt()][k - 1] else 1000
                    dp[i][k] = min(cover.toDouble(), jump.toDouble()).toInt()
                }
            }
            return dp[n][numCarpets]
        }
    }
}