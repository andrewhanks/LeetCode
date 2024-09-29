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
            val symbol = intArrayOf(1, -1)
            val sum = nums.sum()
            if (sum < target || target < -sum) {
                return 0
            }
            val result = Array(nums.size) { IntArray(2 * sum + 1) { 0 } }
            result[0][-nums[0] + sum]++
            result[0][nums[0] + sum]++
            for (i in 1..result.size - 1) {
                for (j in 0..result[0].size - 1) {
                    var ans = 0
                    for (k in 0..symbol.size - 1) {
                        val preX = i - 1
                        val preY = j + symbol[k] * nums[i]
                        if (preX < 0 || preX > result.size - 1 || preY < 0 || preY > result[0].size - 1) {
                            continue
                        }
                        ans += result[preX][preY]
                    }
                    result[i][j] = ans
                }
            }
            // println("result = ${result.contentDeepToString()}")
            return result[result.size - 1][target + sum]
        }

        fun findTargetSumWaysOldSolution(nums: IntArray, target: Int): Int {
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