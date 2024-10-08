package questions

import kotlin.math.max

class Question_121_Best_Time_to_Buy_and_Sell_Stock {

    companion object {

        fun runQuestion() {
//            Input: prices = [7,1,5,3,6,4]
//            Output: 5
            val prices = intArrayOf(7, 1, 5, 3, 6, 4)
            val result = maxProfit(prices)
            println("Question 121: $result")
        }

        fun maxProfit(prices: IntArray): Int {
            var min = Int.MAX_VALUE
            var max = 0
            var ans = 0
            for (count in 0..prices.size - 1) {
                if (prices[count] < min) {
                    ans = max(ans, max - min)
                    min = prices[count]
                    max = min
                } else {
                    max = max(max, prices[count])
                }
            }
            ans = max(ans, max - min)
            return ans
        }

        fun maxProfitAnotherSolution(prices: IntArray): Int {
            var buy = Int.MIN_VALUE
            var sell = 0
            for (count in 0..prices.size - 1) {
                buy = max(buy, -prices[count])
                sell = max(sell, buy + prices[count])
            }
            return sell
        }
    }
}