package questions


class Question_1283_Find_the_Smallest_Divisor_Given_a_Threshold {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,5,9], threshold = 6
//            Output: 5
            val nums = intArrayOf(1, 2, 5, 9)
            val threshold = 6
            val result = smallestDivisor(nums, threshold)
            println("Question 1283: $result")
        }

        fun smallestDivisor(nums: IntArray, threshold: Int): Int {
            var start = 1
            var end = Int.MAX_VALUE
            while (start < end) {
                val mid = start + (end - start) / 2
                if (check(nums, mid, threshold)) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return start
        }

        fun check(nums: IntArray, divisor: Int, threshold: Int): Boolean {
            var result = 0
            for (count in 0..nums.size - 1) {
                val times = nums[count] / divisor
                val rest = nums[count] % divisor
                if (rest != 0) {
                    result = result + times + 1
                } else {
                    result = result + times
                }
            }
            if (result <= threshold) {
                return true
            } else {
                return false
            }
        }
    }
}