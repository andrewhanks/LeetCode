package questions


class Question_974_Subarray_Sums_Divisible_by_K {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,5,0,-2,-3,1], k = 5
//            Output: 7
            val nums = intArrayOf(4, 5, 0, -2, -3, 1)
            val k = 5
            val result = subarraysDivByK(nums, k)
            println("Question 974: $result")
        }

        fun subarraysDivByK(nums: IntArray, k: Int): Int {
            val map: MutableMap<Int, Int> = mutableMapOf()
            map.put(0, 1)
            var ans = 0
            var sum = 0
            for (i in 0..nums.size - 1) {
                sum += nums[i]
                val remain = if (sum % k < 0) {
                    sum % k + k
                } else {
                    sum % k
                }
                ans += map.getOrDefault(remain, 0)
                map[remain] = map.getOrDefault(remain, 0) + 1
            }
            return ans
        }
    }
}