package questions


class Question_377_Combination_Sum_IV {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,3], target = 4
//            Output: 7
//            Explanation:
//            The possible combination ways are:
//            (1, 1, 1, 1)
//            (1, 1, 2)
//            (1, 2, 1)
//            (1, 3)
//            (2, 1, 1)
//            (2, 2)
//            (3, 1)
//            Note that different sequences are counted as different combinations.
            val nums = intArrayOf(1, 2, 3)
            val target = 4
            val result = combinationSum4(nums, target)
            println("Question 494: $result")
        }

        fun combinationSum4(nums: IntArray, target: Int): Int {
            val result = Array(nums.size + 1) { Array(target + 1) { -1 } }
            val returnValue = dp(nums, target, nums.size, result)
            // println("returnValue = $returnValue, result = ${result.contentDeepToString()}")
            return result[result.size - 1][result[0].size - 1]
        }

        fun dp(nums: IntArray, target: Int, n: Int, result: Array<Array<Int>>): Int {
            if (target < 0 || n < 1) {
                return 0
            }
            if (target == 0) {
                result[n][target] = 1
                return result[n][target]
            }
            if (result[n][target] != -1) {
                return result[n][target]
            }
            result[n][target] = dp(nums, target, n - 1, result) + dp(nums, target - nums[n - 1], nums.size, result)
            return result[n][target]
        }
    }
}