package questions


class Question_1005_Maximize_Sum_Of_Array_After_K_Negations {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,-3,-1,5,-4], k = 2
//            Output: 13
            val nums = intArrayOf(2, -3, -1, 5, -4)
            val k = 2
            val result = largestSumAfterKNegations(nums, k)
            println("Question 1005: $result")
        }

        fun largestSumAfterKNegations(nums: IntArray, k: Int): Int {
            var count = 0
            var tempK = k
            nums.sort()
            var sorted = false
            while (tempK > 0) {
                if (count < nums.size && nums[count] < 0) {
                    nums[count] = -nums[count]
                    tempK--
                    count++
                } else {
                    if (!sorted) {
                        nums.sort()
                        sorted = true
                    }
                    // println(nums.contentToString())
                    nums[0] = -nums[0]
                    tempK--
                }
            }
            return nums.sum()
        }
    }
}