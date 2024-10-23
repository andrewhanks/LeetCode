package questions

class Question_2317_Maximum_XOR_After_Operations {

    companion object {

        fun runQuestion() {
//            Input: nums = [3,2,4,6]
//            Output: 7
            val nums = intArrayOf(3, 2, 4, 6)
            val result = maximumXOR(nums)
            println("Question 2317: $result")
        }

        fun maximumXOR(nums: IntArray): Int {
            var ans = 0
            for (i in 0..nums.size - 1) {
                ans = ans or nums[i]
            }
            return ans
        }
    }
}