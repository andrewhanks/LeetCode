package questions

import java.util.*

class Question_2335_Minimum_Amount_of_Time_to_Fill_Cups {

    companion object {

        fun runQuestion() {
//            Input: amount = [5,4,4]
//            Output: 7
            val amount = intArrayOf(5, 4, 4)
            val result = fillCups(amount)
            println("Question 2335: $result")
        }

        fun fillCups(amount: IntArray): Int {
            var total = 0
            while (amount[0] > 0 || amount[1] > 0 || amount[2] > 0) {
                amount.sortDescending()
                amount[0]--
                if (amount[1] > 0) {
                    amount[1]--
                }
                total++
            }
            return total
        }

        fun fillCupsPriorityQueue(amount: IntArray): Int {
            var total = 0
            val result: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
            for (count in 0..amount.size - 1) {
                if (amount[count] != 0) {
                    result.add(amount[count])
                }
            }
            while (result.size > 1) {
                val max = result.remove() - 1
                val mid = result.remove() - 1
                total++
                if (max != 0) {
                    result.add(max)
                }
                if (mid != 0) {
                    result.add(mid)
                }
            }
            if (result.size > 0) {
                total += result.remove()
            }

            return total
        }
    }
}