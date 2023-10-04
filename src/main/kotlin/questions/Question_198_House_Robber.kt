package questions

import kotlin.math.max


class Question_198_House_Robber {

    companion object {

        fun runQuestion() {
            //[2,7,9,3,1]
            val intArray = intArrayOf(2, 7, 9, 3, 1)
            val result = rob(intArray)
            println("Question 198: $result")
        }

        fun rob(nums: IntArray): Int {
            val dpIntArray = IntArray(nums.size) { -1 }
            return dp(nums, 0, dpIntArray)
        }

        fun dp(nums: IntArray, x: Int, dpIntArray: IntArray): Int {
            if (x == nums.size - 1) {
                return nums[x]
            } else if (x > nums.size - 1) {
                return 0
            } else if (dpIntArray[x] != -1) {
                return dpIntArray[x]
            }
            val pick = nums[x] + dp(nums, x + 2, dpIntArray)
            val notPick = dp(nums, x + 1, dpIntArray)
            println("x = $x, nums.size-1 = ${nums.size - 1}, pick = $pick, notPick = $notPick")
            dpIntArray[x] = max(pick, notPick)
            return max(pick, notPick)
        }

        fun robDp(nums: IntArray): Int {
            return dp(nums, 0)
        }

        fun dp(nums: IntArray, x: Int): Int {
            if (x == nums.size - 1) {
                return nums[x]
            } else if (x > nums.size - 1) {
                return 0
            }
            val pick = nums[x] + dp(nums, x + 2)
            val notPick = dp(nums, x + 1)
            println("x = $x, nums.size - 1 = ${nums.size - 1}, pick = $pick, notPick = $notPick")
            return max(pick, notPick)
        }
    }
}