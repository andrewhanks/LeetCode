package questions


class Question_3153_Sum_of_Digit_Differences_of_All_Pairs {

    companion object {

        fun runQuestion() {
//            Input: nums = [13,23,12]
//            Output: 4
            val nums = intArrayOf(13, 23, 12)
            val result = sumDigitDifferences(nums)
            println("Question 3153: $result")
        }

        fun sumDigitDifferences(nums: IntArray): Long {
            val size = nums.size
            var ans = 0L
            while (nums[0] != 0) {
                val list = IntArray(10) { 0 }
                for (count in 0..nums.size - 1) {
                    list[nums[count] % 10]++
                    nums[count] = nums[count] / 10
                }
                for (count in 0..list.size - 1) {
                    if (list[count] != 0) {
                        val currentDigitCount = list[count].toLong() * (size - list[count])
                        ans = ans + currentDigitCount
                    }
                }
            }
            return ans / 2
        }

        fun sumDigitDifferencesWithMap(nums: IntArray): Long {
            val size = nums.size
            var ans = 0L
            while (nums[0] != 0) {
                val map: MutableMap<Int, Int> = mutableMapOf()
                for (count in 0..nums.size - 1) {
                    map[nums[count] % 10] = map.getOrDefault(nums[count] % 10, 0) + 1
                    nums[count] = nums[count] / 10
                }
                for ((key, value) in map) {
                    val currentDigitCount = value.toLong() * (size - value)
                    ans = ans + currentDigitCount
                }
            }
            return ans / 2
        }
    }
}