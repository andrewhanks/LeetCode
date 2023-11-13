package questions

class Question_228_Summary_Ranges {

    companion object {

        fun runQuestion() {
//            Input: nums = [0,2,3,4,6,8,9]
//            Output: ["0","2->4","6","8->9"]
            val nums = intArrayOf(0, 2, 3, 4, 6, 8, 9)
            val resultList = summaryRanges(nums)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 228: $result")
        }

        fun summaryRanges(nums: IntArray): List<String> {
            if (nums.size == 0) {
                return listOf<String>()
            }
            var currentValue = 0
            var rangeNumber: MutableList<Int> = mutableListOf()
            val range: MutableList<MutableList<Int>> = mutableListOf()
            for (count in 0..nums.size - 1) {
                if (count == 0) {
                    rangeNumber.add(nums[count])
                } else if (nums[count] - nums[count - 1] == 1) {
                    rangeNumber.add(nums[count])
                } else {
                    range.add(ArrayList(rangeNumber))
                    rangeNumber.clear()
                    rangeNumber.add(nums[count])
                }
            }
            val result: MutableList<String> = mutableListOf()
            range.add(ArrayList(rangeNumber))
            for (count in 0..range.size - 1) {
                if (range[count].size == 1) {
                    result.add(range[count][0].toString())
                } else {
                    val ranges = range[count][0].toString() + "->" + range[count][range[count].size - 1].toString()
                    result.add(ranges)
                }
            }
            return result
        }
    }
}