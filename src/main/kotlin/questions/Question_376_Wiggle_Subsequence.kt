package questions

import kotlin.math.max

class Question_376_Wiggle_Subsequence {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,17,5,10,13,15,10,5,16,8]
//            Output: 7
            val nums = intArrayOf(1, 17, 5, 10, 13, 15, 10, 5, 16, 8)
            val result = wiggleMaxLength(nums)
            println("Question 376: $result")
        }

        fun wiggleMaxLength(nums: IntArray): Int {
            if (nums.size <= 1) {
                return nums.size
            }
            val up: MutableList<Int> = MutableList(nums.size) { 1 }
            val down: MutableList<Int> = MutableList(nums.size) { 1 }
            for (count in 1..nums.size - 1) {
                if (nums[count] > nums[count - 1]) {
                    up[count] = down[count - 1] + 1
                    down[count] = down[count - 1]
                } else if (nums[count] < nums[count - 1]) {
                    up[count] = up[count - 1]
                    down[count] = up[count - 1] + 1
                } else {
                    up[count] = up[count - 1]
                    down[count] = down[count - 1]
                }
            }
            return max(up[up.size - 1], down[down.size - 1])
        }

        // https://bclin.tw/2022/07/04/leetcode-376/
        fun wiggleMaxLengthByPeakAndValley(nums: IntArray): Int {
            if (nums.size <= 1) {
                return nums.size
            }
            val diff: MutableList<Int> = mutableListOf()
            for (count in 1..nums.size - 1) {
                val temp = nums[count] - nums[count - 1]
                // println("diff.size = ${diff.size}")
                if (diff.size > 0) {
                    val diffLast = diff[diff.size - 1]
                    // println("diffLast = $diffLast, temp = $temp")
                    if ((diffLast < 0 && temp > 0) || (diffLast > 0 && temp < 0)) {
                        diff.add(temp)
                    }
                } else {
                    if (temp > 0 || temp < 0) {
                        diff.add(temp)
                    }
                }
            }
            return diff.size + 1
        }
    }
}