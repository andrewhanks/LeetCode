package questions

import kotlin.math.max

class Question_55_Jump_Game {

    companion object {

        fun runQuestion() {
//            Input: nums = [3,2,1,0,4]
//            Output: false
            val array = intArrayOf(3, 2, 1, 0, 4)
            val result = canJump(array)
            println("Question 55: $result")
        }

        fun canJump(nums: IntArray): Boolean {
            var max = 0
            for (count in 0..nums.size - 2) {
                if (nums[count] == 0 && max <= count) {
                    return false
                }
                max = max(max, nums[count] + count)
            }
            return max >= nums.size - 1
        }

        fun canJumpOld(nums: IntArray): Boolean {
            if (nums.size == 1) {
                return true
            }
            var maxReachPos = 0
            nums.forEachIndexed { index, value ->
                if (maxReachPos < index + value) {
                    maxReachPos = index + value
                }
                if (index >= maxReachPos) {
                    return false
                }
                if (index + value >= nums.size - 1) {
                    return true
                }
            }
            return false
        }
    }
}