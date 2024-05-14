package questions

class Question_922_Sort_Array_By_Parity_II {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,2,5,7]
//            Output: [4,5,2,7]
            val nums = intArrayOf(4, 2, 5, 7)
            val result = sortArrayByParityII(nums)
            println("Question 922: ${result.contentToString()}")
        }

        fun sortArrayByParityII(nums: IntArray): IntArray {
            val result = IntArray(nums.size) { 0 }
            var even = 0
            var odd = 1
            for (count in 0..nums.size - 1) {
                if (nums[count] % 2 == 0) {
                    result[even] = nums[count]
                    even += 2
                } else {
                    result[odd] = nums[count]
                    odd += 2
                }
            }
            return result
        }
    }
}