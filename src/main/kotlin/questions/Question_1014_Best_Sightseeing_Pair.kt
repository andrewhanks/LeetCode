package questions

import kotlin.math.max

class Question_1014_Best_Sightseeing_Pair {

    companion object {

        fun runQuestion() {
//            Input: values = [8,1,5,2,6]
//            Output: 11
            val intArray = intArrayOf(8, 1, 5, 2, 6)
            val result = maxScoreSightseeingPair(intArray)
            println("Question 1014: $result")
        }

        fun maxScoreSightseeingPair(values: IntArray): Int {
            var leftMax = values[0]
            var totalMax = Int.MIN_VALUE
            for (i in 1..values.size - 1) {
                totalMax = max(totalMax, leftMax + values[i] - i)
                leftMax = max(leftMax, values[i] + i)
            }
            return totalMax
        }
    }
}