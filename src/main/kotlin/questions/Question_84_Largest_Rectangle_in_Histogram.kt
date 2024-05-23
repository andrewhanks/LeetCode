package questions

import kotlin.math.max

class Question_84_Largest_Rectangle_in_Histogram {

    companion object {

        fun runQuestion() {
//            Input: heights = [2,1,5,6,2,3]
//            Output: 10
            val height = intArrayOf(2, 1, 5, 6, 2, 3)
            val result = largestRectangleArea(height)
            println("Question 84: $result")
        }

        fun largestRectangleArea(heights: IntArray): Int {
            val result = IntArray(heights.max() + 1) { 0 }
            var finalResult = 0
            for (i in 0..heights.size - 1) {
                for (j in 0..result.size - 1) {
                    if (j <= heights[i]) {
                        result[j]++
                    } else {
                        finalResult = max(finalResult, result[j] * j)
                        result[j] = 0
                    }
                }
            }
            for (count in 0..heights[heights.size - 1]) {
                finalResult = max(finalResult, result[count] * count)
            }
            return finalResult
        }
    }
}