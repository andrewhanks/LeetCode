package questions

import kotlin.math.min


class Question_2944_Minimum_Number_of_Coins_for_Fruits {

    companion object {

        fun runQuestion() {
//            Input: prices = [38,23,27,32,47,45,48,24,39,26,37,42,24,45,27,26,15,16,26,6]
//            Output: 132
            val prices = intArrayOf(38, 23, 27, 32, 47, 45, 48, 24, 39, 26, 37, 42, 24, 45, 27, 26, 15, 16, 26, 6)
            val result = minimumCoins(prices)
            println("Question 2944: $result")
        }

        fun minimumCoins(prices: IntArray): Int {
            val dp = IntArray(prices.size) { 0 }
            for (i in prices.size - 1 downTo 0) {
                dp[i] = prices[i]
                if (2 * i + 2 > prices.size - 1) {
                    continue
                }
                var min = Int.MAX_VALUE
                for (j in i + 1..2 * i + 2) {
                    min = min(min, dp[j])
                }
                dp[i] += min
            }
            return dp[0]
        }
    }
}