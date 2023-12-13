package questions

class Question_2395_Find_Subarrays_With_Equal_Sum {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,2,4]
//            Output: true
            val nums = intArrayOf(4, 2, 4)
            val result = findSubarrays(nums)
            println("Question 2395: $result")
        }

        fun findSubarrays(nums: IntArray): Boolean {
            val result: MutableSet<Int> = mutableSetOf()
            for (count in 1..nums.size - 1) {
                val sum = nums[count] + nums[count - 1]
                if (result.contains(sum)) {
                    return true
                } else {
                    result.add(sum)
                }
            }
            return false
        }
    }
}