package questions


class Question_2568_Minimum_Impossible_OR {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,1]
//            Output: 4
            val nums = intArrayOf(2, 1)
            val result = minImpossibleOR(nums)
            println("Question 2568: $result")
        }

        fun minImpossibleOR(nums: IntArray): Int {
            val set: MutableSet<Int> = mutableSetOf()
            var num = 1
            for (i in 0..nums.size - 1) {
                set.add(nums[i])
            }
            for (i in 0..31) {
                if (!set.contains(num)) {
                    return num
                }
                num = num * 2
            }
            return -1
        }
    }
}