package questions

class Question_416_Partition_Equal_Subset_Sum {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,5,11,5]
//            Output: true
            val nums = intArrayOf(1, 5, 11, 5)
            val result = canPartition(nums)
            println("Question 416: $result")
        }

        fun canPartition(nums: IntArray): Boolean {
            val sum = nums.sum()
            if (sum % 2 == 1) {
                return false
            }
            val result: Array<Array<Boolean?>> = Array(nums.size + 1) { Array(sum / 2 + 1) { null } }
            val finalResult = dp(nums, result, result.size - 1, result[0].size - 1)
            // println("result = ${result.contentDeepToString()}")
            return finalResult
        }

        fun dp(nums: IntArray, result: Array<Array<Boolean?>>, i: Int, j: Int): Boolean {
            if (j == 0) {
                result[i][j] = true
                return true
            }
            if (i == 0) {
                result[i][j] = false
                return false
            }
            if (result[i][j] != null) {
                return result[i][j]!!
            }
            if (nums[i - 1] <= j) {
                result[i][j] = dp(nums, result, i - 1, j - nums[i - 1]) || dp(nums, result, i - 1, j)
            } else {
                result[i][j] = dp(nums, result, i - 1, j)
            }
            return result[i][j]!!
        }

        fun canPartitionBottomUp(nums: IntArray): Boolean {
            val total = nums.sum()
            if (total % 2 != 0) {
                return false
            }
            val half = total / 2
            val result = Array(nums.size + 1) { Array<Boolean>(half + 1) { false } }
            for (i in 0..result.size - 1) {
                for (j in 0..result[0].size - 1) {
                    if (j == 0) {
                        result[i][j] = true
                    }
                }
            }
            for (i in 1..result.size - 1) {
                for (j in 1..result[0].size - 1) {
                    if (nums[i - 1] <= j) {
                        result[i][j] = result[i - 1][j - nums[i - 1]] || result[i - 1][j]
                    } else {
                        result[i][j] = result[i - 1][j]
                    }
                }
            }
            return result[nums.size][half]
        }
    }
}