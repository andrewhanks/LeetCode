package questions

import kotlin.math.min

class Question_1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,5,0,10,14]
//            Output: 1
            val array = intArrayOf(1, 5, 0, 10, 14)
            val result = minDifference(array)
            println("Question 1509: $result")
        }

        fun minDifference(nums: IntArray): Int {
            if (nums.size <= 3) {
                return 0
            }
            val numsSorted = nums.sorted()
            var min = Int.MAX_VALUE
            for (count in 0..3) {
                val currentMin = numsSorted[numsSorted.size - 4 + count] - numsSorted[count]
                min = min(min, currentMin)
            }
            return min
        }
    }
}