package questions

import kotlin.math.max

class Question_3201_Find_the_Maximum_Length_of_Valid_Subsequence_I {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,3,4]
//            Output: 4
            val nums = intArrayOf(1, 2, 3, 4)
            val result = maximumLength(nums)
            println("Question 3201: $result")
        }

        fun maximumLength(nums: IntArray): Int {
            for (count in 0..nums.size - 1) {
                nums[count] = nums[count] % 2
            }
            println(nums.contentToString())
            val allZeroNumber = nums.filter { it == 0 }.count()
            val allOneNumber = nums.filter { it == 1 }.count()
            var zeroOneNumber = 0
            var now = 0
            for (count in 0..nums.size - 1) {
                if (now == 0 && nums[count] == 0) {
                    zeroOneNumber++
                    now = 1
                } else if (now == 1 && nums[count] == 1) {
                    zeroOneNumber++
                    now = 0
                }
            }
            var oneZeroNumber = 0
            now = 1
            for (count in 0..nums.size - 1) {
                println("now = $now, nums[$count] = ${nums[count]}")
                if (now == 1 && nums[count] == 1) {
                    oneZeroNumber++
                    now = 0
                } else if (now == 0 && nums[count] == 0) {
                    oneZeroNumber++
                    now = 1
                }
            }
            return max(max(allZeroNumber, allOneNumber), max(zeroOneNumber, oneZeroNumber))
        }
    }
}