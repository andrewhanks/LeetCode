package questions

class Question_1673_Find_the_Most_Competitive_Subsequence {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,4,3,3,5,4,9,6], k = 4
//            Output: [2,3,3,4]
            val nums = intArrayOf(2, 4, 3, 3, 5, 4, 9, 6)
            val k = 4
            val result = mostCompetitive(nums, k)
            println("Question 167: ${result.contentToString()}")
        }

        fun mostCompetitive(nums: IntArray, k: Int): IntArray {
            val result: MutableList<Int> = mutableListOf()
            var tempK = k
            for (i in 0..nums.size - 1) {
                if (result.isEmpty()) {
                    result.add(nums[i])
                    tempK--
                } else {
                    // println("num[$i] = ${nums[i]}, tempK = $tempK, nums.size-i+1 = ${nums.size-i+1}, result.size = ${result.size}")
                    while (result.size > 0 && nums[i] < result[result.size - 1] && nums.size - 1 - i + 1 + result.size >= k + 1) {
                        result.removeAt(result.size - 1)
                        tempK++
                    }
                    if (tempK > 0) {
                        result.add(nums[i])
                        tempK--
                    }
                }
            }
            return result.toIntArray()
        }
    }
}