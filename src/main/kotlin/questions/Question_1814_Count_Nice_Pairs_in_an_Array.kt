package questions

class Question_1814_Count_Nice_Pairs_in_an_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [42,11,1,97]
//            Output: 2
            val nums = intArrayOf(42, 11, 1, 97)
            val result = countNicePairs(nums)
            println("Question 1814: $result")
        }

        fun countNicePairs(nums: IntArray): Int {
            val modulo = 1000000007
            val result: MutableMap<Int, Long> = mutableMapOf()
            var total = 0L
            for (count in 0..nums.size - 1) {
                val diff = nums[count] - rev(nums[count])
                if (result.contains(diff)) {
                    result[diff] = result[diff]!! + 1
                } else {
                    result.put(diff, 1)
                }
            }
            for ((key, value) in result) {
                if (value >= 2) {
                    total = total + value * (value - 1) / 2
                }
            }
            return (total % modulo).toInt()
        }

        fun rev(n: Int): Int {
            var temp = n
            var result = 0
            while (temp != 0) {
                val rest = temp % 10
                temp = temp / 10
                result = result * 10 + rest
            }
            return result
        }
    }
}