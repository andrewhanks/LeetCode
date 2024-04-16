package questions


class Question_494_Target_Sum {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,1,1,1,1], target = 3
//            Output: 5
            val nums = intArrayOf(1, 1, 1, 1, 1)
            val target = 3
            val result = findTargetSumWays(nums, target)
            println("Question 494: $result")
        }

        fun findTargetSumWays(nums: IntArray, target: Int): Int {
            val sum = nums.sum()
            if (sum < target || (sum - target) % 2 != 0) {
                return 0
            }
            val sum2 = (sum - target) / 2
            val result = Array(nums.size + 1) { Array(sum2 + 1) { 0 } }
            result[0][0] = 1
            for (i in 1..result.size - 1) {
                for (j in 0..result[0].size - 1) {
                    if (nums[i - 1] <= j) {
                        result[i][j] = result[i - 1][j - nums[i - 1]] + result[i - 1][j]
                    } else {
                        result[i][j] = result[i - 1][j]
                    }
                }
            }
            return result[result.size - 1][result[0].size - 1]
        }
    }
}