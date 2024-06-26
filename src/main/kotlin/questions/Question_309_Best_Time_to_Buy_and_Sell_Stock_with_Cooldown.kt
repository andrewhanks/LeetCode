package questions

import kotlin.math.max

class Question_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    companion object {

        fun runQuestion() {
//            Input: prices = [1,2,3,0,2]
//            Output: 3
            val prices = intArrayOf(1, 2, 3, 0, 2)
            val result = maxProfit(prices)
            println("Question 309: $result")
        }

        fun maxProfit(prices: IntArray): Int {
            val empty = IntArray(prices.size) { 0 }
            val hold = IntArray(prices.size) { 0 }
            val cooldown = IntArray(prices.size) { 0 }
            empty[0] = 0
            hold[0] = -prices[0]
            cooldown[0] = 0
            for (count in 1..prices.size - 1) {
                empty[count] = max(empty[count - 1], cooldown[count - 1])
                hold[count] = max(hold[count - 1], empty[count - 1] - prices[count])
                cooldown[count] = hold[count - 1] + prices[count]
            }
            // println(empty.contentToString())
            // println(hold.contentToString())
            // println(cooldown.contentToString())
            return max(empty[prices.size - 1], cooldown[prices.size - 1])
        }

        fun maxProfitDp(prices: IntArray): Int {
            if (prices.size <= 1) {
                return 0
            }
            val result = IntArray(prices.size) { 0 }
            result[1] = if (prices[1] > prices[0]) {
                prices[1] - prices[0]
            } else {
                0
            }
            for (i in 2..prices.size - 1) {
                var maxProfit = result[i - 1]
                for (j in 0..i - 1) {
                    if (prices[j] > prices[i]) {
                        continue
                    }
                    val preProfit = if (j >= 2) {
                        result[j - 2]
                    } else {
                        0
                    }
                    maxProfit = max(maxProfit, preProfit + prices[i] - prices[j])
                }
                result[i] = maxProfit
            }
            return result[result.size - 1]
        }
    }
}