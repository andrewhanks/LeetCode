package questions

class Question_136_Single_Number {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,1,2,1,2]
//            Output: 4
            val array = intArrayOf(4, 1, 2, 1, 2)
            val result = singleNumber(array)
            println("Question 136: $result")
        }

        fun singleNumber(nums: IntArray): Int {
            val result: MutableMap<Int, Int> = mutableMapOf()
            for (count in 0..nums.size - 1) {
                if (result.containsKey(nums[count])) {
                    result[nums[count]] = result[nums[count]]!! + 1
                } else {
                    result.put(nums[count], 1)
                }
            }
            for ((key, value) in result) {
                if (value == 1) {
                    return key
                }
            }
            return -1
        }

        fun singleNumberSort(nums: IntArray): Int {
            if (nums.size == 1) {
                return nums[0]
            }
            nums.sort()
            var currentNumber = -50000
            var times = 0
            for (count in 0..nums.size - 1) {
                if (currentNumber != nums[count]) {
                    if (times == 2 || times == 0) {
                        currentNumber = nums[count]
                        times = 1
                    } else {
                        return currentNumber
                    }
                } else {
                    times++
                }
            }
            return nums[nums.size - 1]
        }
    }
}