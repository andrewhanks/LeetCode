package questions

import kotlin.math.max

class Question_123_Best_Time_to_Buy_and_Sell_Stock_III {

    companion object {

        fun runQuestion() {
//            Input: prices = [3,3,5,0,0,3,1,4]
//            Output: 6
            val array = intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)
            val result = maxProfit(array)
            println("Question 123: $result")
        }

        fun maxProfit(prices: IntArray): Int {
            val result = Array(5) { IntArray(prices.size) { 0 } }
            result[0][0] = 0
            result[1][0] = -prices[0]
            result[2][0] = 0
            result[3][0] = -prices[0]
            result[4][0] = 0
            for (count in 1..prices.size - 1) {
                result[0][count] = 0
                result[1][count] = max(result[1][count - 1], result[0][count - 1] - prices[count])
                result[2][count] = max(result[2][count - 1], result[1][count - 1] + prices[count])
                result[3][count] = max(result[3][count - 1], result[2][count - 1] - prices[count])
                result[4][count] = max(result[4][count - 1], result[3][count - 1] + prices[count])
            }
            return result[4][result[4].size - 1]
        }

        fun maxProfitAnotherSolution(prices: IntArray): Int {
//            First assume that we have no money, so buy1 means that we have to borrow money from others,
//            we want to borrow less so that we have to make our balance as max as we can(because this is negative).
//            sell1 means we decide to sell the stock, after selling it we have price[i] money and we have to give back the money we owed,
//            so we have price[i] - |buy1| = prices[i ] + buy1, we want to make this max.
//            buy2 means we want to buy another stock, we already have sell1 money,
//            so after buying stock2 we have buy2 = sell1 - price[i] money left, we want more money left, so we make it max
//            sell2 means we want to sell stock2, we can have price[i] money after selling it, and we have buy2 money left before,
//            so sell2 = buy2 + prices[i], we make this max.
//            So sell2 is the most money we can have.
            var sell1 = 0
            var sell2 = 0
            var buy1 = Int.MIN_VALUE
            var buy2 = Int.MIN_VALUE
            println(prices.toMutableList())
            for (i in prices.indices) {
                buy1 = max(buy1, -prices[i])
                sell1 = max(sell1, buy1 + prices[i])
                buy2 = max(buy2, sell1 - prices[i])
                sell2 = max(sell2, buy2 + prices[i])
                println("i = $i, buy1 = $buy1, sell1 = $sell1, buy2 = $buy2, sell2 = $sell2")
            }
            return sell2
        }
    }
}