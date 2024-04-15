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