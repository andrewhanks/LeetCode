package questions


class Question_2302_Count_Subarrays_With_Score_Less_Than_K {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,1,4,3,5], k = 10
//            Output: 6
            val arr = intArrayOf(2, 1, 4, 3, 5)
            val k = 10L
            val result = countSubarrays(arr, k)
            println("Question 2302: $result")
        }

        fun countSubarrays(nums: IntArray, k: Long): Long {
            val sum = LongArray(nums.size + 1) { 0L }
            for (i in 0..nums.size - 1) {
                sum[i + 1] = sum[i] + nums[i]
            }
            var ans = 0L
            for (i in 1..sum.size - 1) {
                if (nums[i - 1] >= k) {
                    continue
                }
                // start, end and mid are numbers of subarray
                var start = 1
                var end = nums.size - i + 1
                while (start < end) {
                    var mid = end - (end - start) / 2
                    if ((sum[i + mid - 1] - sum[i - 1]) * mid < k) {
                        start = mid
                    } else {
                        end = mid - 1
                    }
                }
                ans += start
            }
            return ans
        }

        fun countSubarraysWithTwoPointers(nums: IntArray, k: Long): Long {
            var ans = 0L
            var sum = 0L
            var start = 0
            for (end in 0..nums.size - 1) {
                sum = sum + nums[end]
                while (sum * (end - start + 1) >= k) {
                    sum -= nums[start]
                    start++
                }
                ans += end - start + 1
            }
            return ans
        }
    }
}