package questions

import kotlin.math.max


class Question_198_House_Robber {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,7,9,3,1]
//            Output: 12
            val nums = intArrayOf(2, 7, 9, 3, 1)
            val result = rob(nums)
            println("Question 198: $result")
        }

        fun rob(nums: IntArray): Int {
            val rob = IntArray(nums.size) { 0 }
            val notRob = IntArray(nums.size) { 0 }
            rob[0] = nums[0]
            notRob[0] = 0
            for (count in 1..nums.size - 1) {
                rob[count] = notRob[count - 1] + nums[count]
                notRob[count] = max(rob[count - 1], notRob[count - 1])
            }
            return max(rob[rob.size - 1], notRob[notRob.size - 1])
        }

        fun robWithIterative(nums: IntArray): Int {
            if (nums.size <= 1) {
                return nums[0]
            }
            val result = IntArray(nums.size) { 0 }
            result[0] = nums[0]
            for (count in 1..nums.size - 1) {
                val rob = if (count >= 2) {
                    result[count - 2] + nums[count]
                } else {
                    nums[count]
                }
                val notRob = result[count - 1]
                result[count] = max(rob, notRob)
            }
            return result[result.size - 1]
        }

        fun robWithRecursive(nums: IntArray): Int {
            val result = IntArray(nums.size) { -1 }
            return dpWithRecursive(nums, 0, result)
        }

        fun dpWithRecursive(nums: IntArray, index: Int, result: IntArray): Int {
            if (index >= nums.size) {
                return 0
            }
            if (index == nums.size - 1) {
                return nums[index]
            }
            if (result[index] != -1) {
                return result[index]
            }
            val max =
                max(dpWithRecursive(nums, index + 2, result) + nums[index], dpWithRecursive(nums, index + 1, result))
            result[index] = max
            return result[index]
        }

        fun robOld(nums: IntArray): Int {
            val dpIntArray = IntArray(nums.size) { -1 }
            return dpOld(nums, 0, dpIntArray)
        }

        fun dpOld(nums: IntArray, x: Int, dpIntArray: IntArray): Int {
            if (x == nums.size - 1) {
                return nums[x]
            } else if (x > nums.size - 1) {
                return 0
            } else if (dpIntArray[x] != -1) {
                return dpIntArray[x]
            }
            val pick = nums[x] + dpOld(nums, x + 2, dpIntArray)
            val notPick = dpOld(nums, x + 1, dpIntArray)
            println("x = $x, nums.size-1 = ${nums.size - 1}, pick = $pick, notPick = $notPick")
            dpIntArray[x] = max(pick, notPick)
            return max(pick, notPick)
        }
    }
}