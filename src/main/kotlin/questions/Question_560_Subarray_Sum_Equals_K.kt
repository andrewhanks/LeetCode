package questions


class Question_560_Subarray_Sum_Equals_K {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,3], k = 3
//            Output: 2
            val nums = intArrayOf(1, 2, 3)
            val k = 3
            val result = subarraySum(nums, k)
            println("Question 560: $result")
        }

        fun subarraySum(nums: IntArray, k: Int): Int {
            var count = 0
            for (x in 0..nums.size - 1) {
                var sum = 0
                for (y in x..nums.size - 1) {
                    sum += nums[y]
                    if (sum == k) {
                        count++
                    }
                }
            }
            return count
        }
    }
}