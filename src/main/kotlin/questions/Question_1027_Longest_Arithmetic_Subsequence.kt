package questions

import kotlin.math.max

class Question_1027_Longest_Arithmetic_Subsequence {

    companion object {

        fun runQuestion() {
//            Input: nums = [20,1,15,3,10,5,8]
//            Output: 4
            val nums = intArrayOf(20, 1, 15, 3, 10, 5, 8)
            val result = longestArithSeqLength(nums)
            println("Question 1027: $result")
        }

        fun longestArithSeqLength(nums: IntArray): Int {
            var ans = 0
            for (i in 0..nums.size - 1) {
                var map: MutableMap<Int, Int> = mutableMapOf()
                for (j in i + 1..nums.size - 1) {
                    val diff = nums[j] - nums[i]
                    for ((key, value) in map) {
                        if (diff == key * (value + 1)) {
                            map[key] = map[key]!! + 1
                            ans = max(ans, map[key]!! + 1)
                        }
                    }
                    if (!map.contains(diff)) {
                        map[diff] = 1
                        ans = max(ans, 2)
                    }
                }
            }
            return ans
        }

        fun longestArithSeqLengthDp(nums: IntArray): Int {
            val dp: Array<MutableMap<Int, Int>> = Array(nums.size) { mutableMapOf() }
            var ans = 0
            for (i in 0..nums.size - 1) {
                for (j in i + 1..nums.size - 1) {
                    val diff = nums[j] - nums[i]
                    dp[j][diff] = dp[i].getOrDefault(diff, 1) + 1
                    ans = max(ans, dp[j][diff]!!)
                }
            }
            return ans
        }
    }
}