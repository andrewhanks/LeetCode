package questions

import java.util.*
import kotlin.math.max
import kotlin.math.min


class Question_3181_Maximum_Total_Reward_Using_Operations_II {

    companion object {

        fun runQuestion() {
//            Input: prices = [4,16,13,19,9,9]
//            Output: 36
            val array = intArrayOf(4, 16, 13, 19, 9, 9)
            val result = maxTotalReward(array)
            println("Question 3181: $result")
        }

        fun maxTotalReward(rewardValues: IntArray): Int {
            val result: MutableMap<Int, Int> = mutableMapOf()
            val nums: MutableList<Int> = mutableListOf()
            for (value in rewardValues.sorted()) {
                if (!nums.contains(value)) {
                    nums.add(value)
                }
            }
            println("nums = $nums")
            val limit = nums[nums.size - 1]
            val reward = limit + dp(nums, limit, result)
            println("result = $result")
            return reward
        }

        fun dp(nums: MutableList<Int>, limit: Int, result: MutableMap<Int, Int>): Int {
            if (limit == 0) {
                return 0
            }
            if (result.contains(limit)) {
                return result[limit]!!
            }
            if (nums.contains(limit - 1)) {
                return limit - 1
            }
            var max = 0
            for (count in 0..nums.size - 1) {
                if (nums[count] >= limit) {
                    break
                }
                max = max(max, nums[count] + dp(nums, min(nums[count], limit - nums[count]), result))
                println("nums[$count] = ${nums[count]}, limit = $limit, max = $max")
            }
            result.put(limit, max)
            return result[limit]!!
        }
    }
}