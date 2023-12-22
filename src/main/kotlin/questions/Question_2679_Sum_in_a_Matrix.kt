package questions


class Question_2679_Sum_in_a_Matrix {

    companion object {

        fun runQuestion() {
//            Input: nums = [[7,2,1],[6,4,2],[6,5,3],[3,2,1]]
//            Output: 15
            val nums = arrayOf(intArrayOf(7, 2, 1), intArrayOf(6, 4, 2), intArrayOf(6, 5, 3), intArrayOf(3, 2, 1))
            val result = matrixSum(nums)
            println("Question 2679: $result")
        }

        fun matrixSum(nums: Array<IntArray>): Int {
            var score = 0
            for (count in 0..nums.size - 1) {
                nums[count].sortDescending()
            }
            for (y in 0..nums[0].size - 1) {
                val temp: MutableList<Int> = mutableListOf()
                for (x in 0..nums.size - 1) {
                    temp.add(nums[x][y])
                }
                val temp1 = temp.sortedDescending()
                //println(temp1)
                score += temp1[0]
                //println(score)
            }
            return score
        }
    }
}