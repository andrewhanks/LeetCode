package questions

class Question_376_Wiggle_Subsequence {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,17,5,10,13,15,10,5,16,8]
//            Output: 7
            val nums = intArrayOf(1, 17, 5, 10, 13, 15, 10, 5, 16, 8)
            val result = wiggleMaxLength(nums)
            println("Question 376: $result")
        }

        fun wiggleMaxLength(nums: IntArray): Int {
            if (nums.size <= 1) {
                return nums.size
            }
            val diff: MutableList<Int> = mutableListOf()
            for (count in 1..nums.size - 1) {
                val temp = nums[count] - nums[count - 1]
                // println("diff.size = ${diff.size}")
                if (diff.size > 0) {
                    val diffLast = diff[diff.size - 1]
                    // println("diffLast = $diffLast, temp = $temp")
                    if ((diffLast < 0 && temp > 0) || (diffLast > 0 && temp < 0)) {
                        diff.add(temp)
                    }
                } else {
                    if (temp > 0 || temp < 0) {
                        diff.add(temp)
                    }
                }
            }
            return diff.size + 1
        }
    }
}