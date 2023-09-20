package questions

import kotlin.math.abs
import kotlin.math.min

class Question_1144_Decrease_Elements_To_Make_Array_Zigzag {

    companion object {

        fun runQuestion() {
            // [9,6,1,6,2]
            val numberArray = intArrayOf(9, 6, 1, 6, 2)
            val result = movesToMakeZigzag(numberArray)
            println("Question 1144: $result")
        }

        fun movesToMakeZigzag(nums: IntArray): Int {
            if (nums.size == 1) {
                return 0
            }
            var oddResult = 0
            for (count in 0..nums.size - 1 step 2) {
                if (count == 0 && nums[count + 1] <= nums[count]) {
                    oddResult += nums[count] - nums[count + 1] + 1
                } else if (count == nums.size - 1 && nums[count - 1] <= nums[count]) {
                    oddResult += nums[count] - nums[count - 1] + 1
                } else if (count > 0 && count < nums.size - 1) {
                    val adjMin = min(nums[count - 1], nums[count + 1])
                    if (adjMin <= nums[count]) {
                        oddResult += nums[count] - adjMin + 1
                    }
                }
            }
            var evenResult = 0
            for (count in 1..nums.size - 1 step 2) {
                if (count == 0 && nums[count + 1] <= nums[count]) {
                    evenResult += nums[count] - nums[count + 1] + 1
                } else if (count == nums.size - 1 && nums[count - 1] <= nums[count]) {
                    evenResult += nums[count] - nums[count - 1] + 1
                } else if (count > 0 && count < nums.size - 1) {
                    val adjMin = min(nums[count - 1], nums[count + 1])
                    if (adjMin <= nums[count]) {
                        evenResult += nums[count] - adjMin + 1
                    }
                }
            }
            return min(oddResult, evenResult)
        }
    }
}