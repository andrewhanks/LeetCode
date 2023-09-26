package questions

import kotlin.math.max
import kotlin.math.min

class Question_2733_Neither_Minimum_nor_Maximum {

    companion object {

        fun runQuestion() {
            // [3,2,1,4]
            val numberArray = intArrayOf(3, 2, 1, 4)
            val result = findNonMinOrMax(numberArray)
            println("Question 2733: $result")
        }

        fun findNonMinOrMax(nums: IntArray): Int {
            if (nums.size <= 2) {
                return -1
            }
            val resultArray = nums.sorted()
            return resultArray[1]
        }

        fun findNonMinOrMaxQuick(nums: IntArray): Int {
            if (nums.size <= 2) {
                return -1
            }
            return max(min(max(nums[0], nums[1]), nums[2]), min(nums[0], nums[1]))
        }
    }
}