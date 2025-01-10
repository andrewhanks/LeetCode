package questions

import kotlin.math.max


class Question_1567_Maximum_Length_of_Subarray_With_Positive_Product {

    companion object {

        fun runQuestion() {
//            Input: nums = [0,1,-2,-3,-4]
//            Output: 3
            val nums = intArrayOf(0, 1, -2, -3, -4)
            val result = getMaxLen(nums)
            println("Question 1567: $result")
        }

        fun getMaxLen(nums: IntArray): Int {
            val negPos: MutableList<Int> = mutableListOf()
            var ans = 0
            var prev = 0
            for (i in 0..nums.size - 1) {
                if (nums[i] == 0) {
                    if (negPos.size % 2 == 1) {
                        val rangeMax = max((i - 1) - (negPos[0] + 1) + 1, (negPos[negPos.size - 1] - 1) - prev + 1)
                        ans = max(ans, rangeMax)
                    } else {
                        ans = max(ans, (i - 1) - prev + 1)
                    }
                    negPos.clear()
                    prev = i + 1
                } else if (nums[i] < 0) {
                    negPos.add(i)
                }
            }
            if (negPos.size % 2 == 1) {
                val rangeMax = max((nums.size - 1) - (negPos[0] + 1) + 1, (negPos[negPos.size - 1] - 1) - prev + 1)
                ans = max(ans, rangeMax)
            } else {
                ans = max(ans, (nums.size - 1) - prev + 1)
            }
            return ans
        }
    }
}