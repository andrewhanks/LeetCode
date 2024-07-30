package questions

import kotlin.math.max
import kotlin.math.min


class Question_2145_Count_the_Hidden_Sequences {

    companion object {

        fun runQuestion() {
//            Input: differences = [3,-4,5,1,-2], lower = -4, upper = 5
//            Output: 4
            val differences = intArrayOf(3, -4, 5, 1, -2)
            val lower = -4
            val upper = 5
            val result = numberOfArrays(differences, lower, upper)
            println("Question 2145: $result")
        }

        fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
            var min = 0L
            var max = 0L
            var sum = 0L
            for (count in 0..differences.size - 1) {
                sum += differences[count].toLong()
                min = min(min, sum)
                max = max(max, sum)
                // println("max = $max, min = $min, sum = $sum")
            }
            // println("upper = $upper, lower = $lower, max = $max, min = $min")
            val ans = (upper - lower) - (max - min) + 1
            if (ans < 0L) {
                return 0
            } else {
                return ans.toInt()
            }
        }
    }
}