package questions

import kotlin.math.max

class Question_714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

    companion object {

        fun runQuestion() {
//            Input: prices = [1,3,7,5,10,3], fee = 3
//            Output: 6
            val prices = intArrayOf(1, 3, 7, 5, 10, 3)
            val fee = 3
            val result = maxProfit(prices, fee)
            println("Question 714: $result")
        }

        fun maxProfit(prices: IntArray, fee: Int): Int {
            val hold = IntArray(prices.size) { 0 }
            val empty = IntArray(prices.size) { 0 }
            hold[0] = -prices[0]
            empty[0] = 0
            for (count in 1..prices.size - 1) {
                hold[count] = max(hold[count - 1], empty[count - 1] - prices[count])
                empty[count] = max(empty[count - 1], hold[count - 1] + prices[count] - fee)
            }
            return empty[prices.size - 1]
        }
    }
}