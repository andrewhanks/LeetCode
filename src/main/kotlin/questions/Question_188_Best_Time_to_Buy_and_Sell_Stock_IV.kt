package questions

import kotlin.math.max

class Question_188_Best_Time_to_Buy_and_Sell_Stock_IV {

    companion object {

        fun runQuestion() {
//            Input: k = 2, prices = [3,2,6,5,0,3]
//            Output: 7
            val k = 2
            val prices = intArrayOf(3, 2, 6, 5, 0, 3)
            val result = maxProfit(k, prices)
            println("Question 188: $result")
        }

        fun maxProfit(k: Int, prices: IntArray): Int {
            val buy: IntArray = IntArray(k) { Int.MIN_VALUE }
            val sell: IntArray = IntArray(k) { 0 }
            for (x in 0..prices.size - 1) {
                for (y in 0..k - 1) {
                    if (y == 0) {
                        buy[y] = max(buy[y], -prices[x])
                    } else {
                        buy[y] = max(buy[y], sell[y - 1] - prices[x])
                    }
                    sell[y] = max(sell[y], buy[y] + prices[x])
                }
            }
            return sell[k - 1]
        }
    }
}