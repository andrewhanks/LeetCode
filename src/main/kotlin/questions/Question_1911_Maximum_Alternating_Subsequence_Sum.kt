package questions

class Question_1911_Maximum_Alternating_Subsequence_Sum {

    companion object {

        fun runQuestion() {
//            Input: nums = [6,2,1,2,4,5]
//            Output: 10
            val array = intArrayOf(6, 2, 1, 2, 4, 5)
            val result = maxAlternatingSum(array)
            println("Question 1911: $result")
        }

        fun maxAlternatingSum(nums: IntArray): Long {
            var ans = 0L
            for (i in 0..nums.size - 2) {
                if (nums[i] > nums[i + 1]) {
                    ans += (nums[i].toLong() - nums[i + 1])
                }
            }
            ans += nums[nums.size - 1]
            return ans
        }
    }
}