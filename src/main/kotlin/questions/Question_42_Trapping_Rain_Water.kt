package questions

import kotlin.math.max

class Question_42_Trapping_Rain_Water {

    companion object {

        fun runQuestion() {
//            Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//            Output: 6
            val height = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
            val result = trap(height)
            println("Question 42: $result")
        }

        fun trap(height: IntArray): Int {
            var max = height.max()
            var maxIndex = height.indexOf(max)
            // println("max = $max, maxIndex = $maxIndex")
            var leftMax = 0
            var result = 0
            for (count in 0..maxIndex - 1) {
                leftMax = max(leftMax, height[count])
                result += (leftMax - height[count])
            }
            var rightMax = 0
            for (count in height.size - 1 downTo maxIndex + 1) {
                rightMax = max(rightMax, height[count])
                result += (rightMax - height[count])
            }
            return result
        }
    }
}