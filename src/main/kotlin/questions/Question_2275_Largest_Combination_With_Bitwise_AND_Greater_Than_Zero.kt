package questions

import kotlin.math.max

class Question_2275_Largest_Combination_With_Bitwise_AND_Greater_Than_Zero {

    companion object {

        fun runQuestion() {
//            Input: candidates = [16,17,71,62,12,24,14]
//            Output: 4
            val candidates = intArrayOf(16, 17, 71, 62, 12, 24, 14)
            val result = largestCombination(candidates)
            println("Question 122: $result")
        }

        fun largestCombination(candidates: IntArray): Int {
            val result = IntArray(32) { 0 }
            for (count in 0..candidates.size - 1) {
                calculateBinaryNumber(result, candidates[count])
            }
            // println("result = ${result.contentToString()}")
            return result.max()
        }

        fun calculateBinaryNumber(result: IntArray, number: Int) {
            var temp = number
            var count = 0
            while (temp != 0) {
                val times = temp / 2
                val rest = temp % 2
                if (rest != 0) {
                    result[count]++
                }
                temp = temp / 2
                count++
            }
        }

        fun largestCombinationWithBinaryOperation(candidates: IntArray): Int {
            var max = 0
            for (i in 0..31) {
                var count = 0
                for (j in 0..candidates.size - 1) {
                    val compare = 1 shl i
                    // println("candidates[$j] = ${candidates[j]}, compare = $compare, (candidates[j] and compare) = ${(candidates[j] and compare)}")
                    if ((candidates[j] and compare) != 0) {
                        count++
                    }
                }
                max = max(max, count)
            }
            return max
        }
    }
}