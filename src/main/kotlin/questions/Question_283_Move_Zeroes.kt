package questions

class Question_283_Move_Zeroes {

    companion object {

        fun runQuestion283() {
            val inputIntArray = intArrayOf(0, 1, 0, 3, 12)
            val resultList = moveZeroes(inputIntArray)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 283: $result")
        }

        fun moveZeroes(nums: IntArray): IntArray {
            var position = 0
            for (i in 0..nums.size - 1) {
                if (nums[position] == 0) {
                    for (j in position..nums.size - 2) {
                        nums[j] = nums[j + 1]
                    }
                    nums[nums.size - 1] = 0
                    position -= 1
                }
                position += 1
            }
            return nums
        }
    }
}