package questions

import java.util.*
import kotlin.math.max

class Question_1262_Greatest_Sum_Divisible_by_Three {

    companion object {

        fun runQuestion() {
//            Input: nums = [3,6,5,1,8]
//            Output: 18
            val nums = intArrayOf(3, 6, 5, 1, 8)
            val result = maxSumDivThree(nums)
            println("Question 1262: $result")
        }

        fun maxSumDivThree(nums: IntArray): Int {
            val map: MutableMap<Int, PriorityQueue<Int>> = mutableMapOf()
            for (i in 0..nums.size - 1) {
                val rest = nums[i] % 3
                val queue = map.getOrDefault(rest, PriorityQueue { a, b -> a - b })
                queue.add(nums[i])
                map[rest] = queue
            }
            val sum = nums.sum()
            val rest1Queue = map[1]
            val rest2Queue = map[2]
            if (sum % 3 == 1) {
                if (rest1Queue != null && rest2Queue == null) {
                    return sum - rest1Queue.remove()
                } else if (rest1Queue == null && rest2Queue != null) {
                    return sum - rest2Queue.remove() - rest2Queue.remove()
                } else {
                    if (rest2Queue!!.size <= 1) {
                        return sum - rest1Queue!!.remove()
                    } else {
                        return max(sum - rest1Queue!!.remove(), sum - rest2Queue!!.remove() - rest2Queue!!.remove())
                    }
                }
            } else if (sum % 3 == 2) {
                if (rest1Queue != null && rest2Queue == null) {
                    return sum - rest1Queue.remove() - rest1Queue.remove()
                } else if (rest1Queue == null && rest2Queue != null) {
                    return sum - rest2Queue.remove()
                } else {
                    if (rest1Queue!!.size <= 1) {
                        return sum - rest2Queue!!.remove()
                    } else {
                        return max(sum - rest1Queue!!.remove() - rest1Queue!!.remove(), sum - rest2Queue!!.remove())
                    }
                }
            } else {
                return sum
            }
        }

        fun maxSumDivThreeDpWithMultipleTakenCases(nums: IntArray): Int {
            val dp = Array(nums.size) { IntArray(3) { -1 } }
            if (nums[0] % 3 == 0) {
                dp[0][0] = nums[0]
            } else if (nums[0] % 3 == 1) {
                dp[0][1] = nums[0]
            } else {
                dp[0][2] = nums[0]
            }
            for (i in 1..nums.size - 1) {
                for (j in 0..2) {
                    val k = nums[i] % 3
                    val taken = if (dp[i - 1][(j - k + 3) % 3] != -1) {
                        dp[i - 1][(j - k + 3) % 3] + nums[i]
                    } else if (j == k && dp[i - 1][j] == -1) {
                        nums[i]
                    } else {
                        -1
                    }
                    val notTaken = dp[i - 1][j]
                    dp[i][j] = max(taken, notTaken)
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            if (dp[dp.size - 1][0] == -1) {
                return 0
            } else {
                return dp[dp.size - 1][0]
            }
        }

        fun maxSumDivThreeDp(nums: IntArray): Int {
            val dp = Array(nums.size + 1) { IntArray(3) { 0 } }
            dp[0][0] = 0
            dp[0][1] = Int.MIN_VALUE
            dp[0][2] = Int.MIN_VALUE
            for (i in 1..dp.size - 1) {
                for (j in 0..2) {
                    val k = nums[i - 1] % 3
                    dp[i][j] = max(dp[i - 1][(j - k + 3) % 3] + nums[i - 1], dp[i - 1][j])
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            return dp[dp.size - 1][0]
        }
    }
}