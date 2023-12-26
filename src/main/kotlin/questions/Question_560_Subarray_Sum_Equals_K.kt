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

        fun subarraySumWithPrefixSum(nums: IntArray, k: Int): Int {
            var result: MutableMap<Int, Int> = mutableMapOf()
            var temp = 0
            result.put(0, 1)
            var number = 0
            for (count in 0..nums.size - 1) {
                temp += nums[count]
                if (result.contains(temp - k)) {
                    number += result[temp - k]!!
                }
                if (result.contains(temp)) {
                    result[temp] = result[temp]!! + 1
                } else {
                    result.put(temp, 1)
                }
            }
            return number
        }

        fun subarraySumWithPrefixSumOptimize(nums: IntArray, k: Int): Int {
            var count = 0
            val n = nums.size
            val map: MutableMap<Int, Int> = HashMap() //sum - count
            map[0] = 1
            var temp = 0
            for (i in 0 until n) {
                temp += nums[i]
                count += map.getOrDefault(temp - k, 0)
                map[temp] = map.getOrDefault(temp, 0) + 1
            }
            return count
        }
    }
}