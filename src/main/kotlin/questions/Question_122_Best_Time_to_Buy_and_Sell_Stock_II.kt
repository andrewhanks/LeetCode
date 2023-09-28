package questions

class Question_122_Best_Time_to_Buy_and_Sell_Stock_II {

    companion object {

        fun runQuestion() {
            // [7,1,5,3,6,4]
            val array = intArrayOf(7, 1, 5, 3, 6, 4)
            val result = maxProfit(array)
            println("Question 122: $result")
        }

        fun maxProfit(prices: IntArray): Int {
            var buyPrice = 100000
            var result = 0
            prices.forEachIndexed { index, value ->
                if (value < buyPrice) {
                    buyPrice = value
                }
                if (index + 1 < prices.size && prices[index + 1] < value) {
                    result += value - buyPrice
                    buyPrice = 100000
                }
                if (index == prices.size - 1) {
                    if (value > buyPrice) {
                        result += value - buyPrice
                        buyPrice = 100000
                    }
                }
            }
            return result
        }
    }
}