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

        fun pivotIndexWithSumArray(nums: IntArray): Int {
            val left = IntArray(nums.size) { 0 }
            val right = IntArray(nums.size) { 0 }
            left[0] = nums[0]
            right[nums.size - 1] = nums[nums.size - 1]
            for (count in 1..nums.size - 1) {
                left[count] = left[count - 1] + nums[count]
                right[nums.size - 1 - count] = right[nums.size - 1 - (count - 1)] + nums[nums.size - 1 - count]
            }
            for (count in 0..nums.size - 1) {
                if (left[count] == right[count]) {
                    return count
                }
            }
            return -1
        }
    }
}