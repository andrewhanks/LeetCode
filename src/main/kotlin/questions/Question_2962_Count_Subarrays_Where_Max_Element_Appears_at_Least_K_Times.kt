package questions


class Question_2962_Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,3,2,3,3], k = 2
//            Output: 6
            val nums = intArrayOf(1, 3, 2, 3, 3)
            val k = 2
            val result = countSubarrays(nums, k)
            println("Question 2962: $result")
        }

        fun countSubarrays(nums: IntArray, k: Int): Long {
            val max = nums.max()
            var maxNumber = 0
            var ans = 0L
            var left = 0
            for (right in 0..nums.size - 1) {
                if (nums[right] == max) {
                    maxNumber++
                }
                if (maxNumber == k) {
                    while (nums[left] != max) {
                        ans += (nums.size - 1 - right + 1)
                        left++
                    }
                    ans += (nums.size - 1 - right + 1)
                    left++
                    maxNumber--
                    // println("left = $left, right = $right, ans = $ans")
                }
            }
            return ans
        }
    }
}