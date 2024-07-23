package questions

import kotlin.math.max

class Question_962_Maximum_Width_Ramp {

    companion object {

        fun runQuestion() {
//            Input: nums = [9,8,1,0,1,9,4,0,4,1]
//            Output: 7
            val nums = intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1)
            val result = maxWidthRamp(nums)
            println("Question 962: $result")
        }

        fun maxWidthRamp(nums: IntArray): Int {
            var rightStart = 0
            var ans = 0
            for (left in 0..nums.size - 1) {
                val tempStart = rightStart
                for (tempRight in nums.size - 1 downTo max(tempStart, left)) {
                    if (nums[tempRight] >= nums[left]) {
                        rightStart = tempRight
                        ans = max(ans, rightStart - left)
                        break
                    }
                }
                // println("ans = $ans, rightStart = $rightStart, left = $left")
            }
            return ans
        }
    }
}