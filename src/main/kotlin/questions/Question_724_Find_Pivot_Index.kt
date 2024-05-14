package questions

class Question_724_Find_Pivot_Index {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,7,3,6,5,6]
//            Output: 3
            val array = intArrayOf(1, 7, 3, 6, 5, 6)
            val result = pivotIndex(array)
            println("Question 724: $result")
        }

        fun pivotIndex(nums: IntArray): Int {
            var result = 0
            while (result <= nums.size - 1) {
                var left = 0
                for (count in 0..result - 1) {
                    left += nums[count]
                }
                var right = 0
                for (count in result + 1..nums.size - 1) {
                    right += nums[count]
                }
                if (left == right) {
                    return result
                }
                result++
            }
            return -1
        }
    }
}