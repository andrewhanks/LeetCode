package questions

class Question_2653_Sliding_Subarray_Beauty {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,-1,-3,-2,3], k = 3, x = 2
//            Output: [-1,-2,-2]
            val nums = intArrayOf(1, -1, -3, -2, 3)
            val k = 3
            val x = 2
            val result = getSubarrayBeauty(nums, k, x)
            println("Question 2653: ${result.contentToString()}")
        }

        fun getSubarrayBeauty(nums: IntArray, k: Int, x: Int): IntArray {
            val freq = IntArray(51) { 0 }
            var n = 0
            var ans: MutableList<Int> = mutableListOf()
            for (i in 0..nums.size - 1) {
                if (nums[i] < 0) {
                    freq[-nums[i]]++
                }
                n++
                if (n > k) {
                    if (nums[i - k] < 0) {
                        freq[-nums[i - k]]--
                    }
                    n--
                }
                if (i < k - 1) {
                    continue
                }
                var count = 0
                for (j in freq.size - 1 downTo 0) {
                    count += freq[j]
                    if (count >= x) {
                        ans.add(-j)
                        break
                    }
                }
                if (count < x) {
                    ans.add(0)
                }
            }
            return ans.toIntArray()
        }
    }
}