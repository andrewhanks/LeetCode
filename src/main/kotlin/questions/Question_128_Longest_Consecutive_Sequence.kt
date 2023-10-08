package questions

class Question_128_Longest_Consecutive_Sequence {

    companion object {

        fun runQuestion() {
//            Input: nums = [0,3,7,2,5,8,4,6,0,1]
//            Output: 9
            val input = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)
            val result = longestConsecutive(input)
            println("Question 128: $result")
        }

        fun longestConsecutive(nums: IntArray): Int {
            if (nums.size <= 1) {
                return nums.size
            }
            val result = nums.toMutableList().sorted()
            var number: MutableList<Int> = mutableListOf()
            number.add(1)
            for (count in 1..result.size - 1) {
                if (result[count] - result[count - 1] == 1) {
                    number[number.size - 1]++
                } else if (result[count] == result[count - 1]) {
                } else {
                    number.add(1)
                }
            }
            return number.sortedDescending()[0]
        }
    }
}