package questions

import kotlin.math.max
import kotlin.math.min

class Question_2929_Distribute_Candies_Among_Children_II {

    companion object {

        fun runQuestion() {
//            Input: n = 5, limit = 2
//            Output: 3
            val n = 5
            val limit = 2
            val result = distributeCandies(n, limit)
            println("Question 2929: $result")
        }

        fun distributeCandies(n: Int, limit: Int): Long {
            var j = 0L
            for (i in 0..min(limit, n)) {
                val min = max(0, n - i - limit)
                val max = min(limit, n - i)
                // println("min = $min, max = $max")
                if (max - min >= 0) {
                    j += (max - min + 1)
                }
            }
            return j
        }
    }
}