package questions


class Question_2488_Count_Subarrays_With_Median_K {

    companion object {

        fun runQuestion() {
//            Input: nums = [3,2,1,4,5], k = 4
//            Output: 3
            val nums = intArrayOf(3, 2, 1, 4, 5)
            val k = 4
            val result = countSubarrays(nums, k)
            println("Question 2488: $result")
        }

        fun countSubarrays(nums: IntArray, k: Int): Int {
            var result: MutableMap<Int, Int> = mutableMapOf()
            var balance = 0
            result.put(0, 1)
            var number = 0
            var found = false
            for (num in nums) {
                if (num == k) {
                    found = true
                } else {
                    if (num < k) {
                        balance--
                    } else {
                        balance++
                    }
                }
                if (found) {
                    number += result.getOrDefault(balance, 0) + result.getOrDefault(balance - 1, 0)
                } else {
                    result[balance] = result.getOrDefault(balance, 0) + 1
                }
            }
            return number
        }
    }
}