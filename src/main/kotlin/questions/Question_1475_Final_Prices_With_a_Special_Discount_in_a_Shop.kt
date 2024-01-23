package questions

import java.util.*

class Question_1475_Final_Prices_With_a_Special_Discount_in_a_Shop {

    companion object {

        fun runQuestion() {
//            Input: prices = [8,4,6,2,3]
//            Output: [4,2,4,2,3]
            val prices = intArrayOf(8, 4, 6, 2, 3)
            val resultList = finalPrices(prices)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 1475: $result")
        }

        fun finalPrices(prices: IntArray): IntArray {
            for (x in 0..prices.size - 1) {
                for (y in x + 1..prices.size - 1) {
                    if (prices[y] <= prices[x]) {
                        prices[x] -= prices[y]
                        break
                    }
                }
            }
            return prices
        }

        fun finalPricesWithMonotonicStack(prices: IntArray): IntArray {
            val stack: Stack<Int> = Stack()
            for (count in 0..prices.size - 1) {
                while (!stack.isEmpty() && prices[stack.peek()] >= prices[count]) {
                    prices[stack.removeLast()] -= prices[count]
                }
                stack.add(count)
            }
            return prices
        }
    }
}