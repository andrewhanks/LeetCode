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
            println("Question 377: $result")
        }

        fun combinationSum4(nums: IntArray, target: Int): Int {
            val result = IntArray(target + 1) { -1 }
            val ans = dp(nums, target, result)
//            println(result.contentToString())
            return ans
        }

        fun dp(nums: IntArray, target: Int, result: IntArray): Int {
            if (target < 0) {
                return 0
            }
            if (target == 0) {
                result[target] = 1
                return 1
            }
            if (target == nums.min()) {
                result[target] = 1
                return 1
            }
            if (result[target] != -1) {
                return result[target]
            }
            var sum = 0
            for (count in 0..nums.size - 1) {
                sum += dp(nums, target - nums[count], result)
            }
            result[target] = sum
            return result[target]
        }

        fun combinationSum4OldSolution(nums: IntArray, target: Int): Int {
            val result = Array(nums.size + 1) { Array(target + 1) { -1 } }
            val returnValue = dpOldSolution(nums, target, nums.size, result)
            // println("returnValue = $returnValue, result = ${result.contentDeepToString()}")
            return result[result.size - 1][result[0].size - 1]
        }

        fun dpOldSolution(nums: IntArray, target: Int, n: Int, result: Array<Array<Int>>): Int {
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
            result[n][target] = dpOldSolution(nums, target, n - 1, result) + dpOldSolution(
                nums,
                target - nums[n - 1],
                nums.size,
                result
            )
            return result[n][target]
        }
    }
}