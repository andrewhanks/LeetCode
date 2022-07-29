package questions

class Question_442_Find_All_Duplicates_in_an_Array {

    companion object {

        fun runQuestion442() {
            val inputIntArray = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
            val resultList = findDuplicatesWebSolution(inputIntArray)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 442: $result")
        }

        // Mapping (values - 1) in this array to indexes
        fun findDuplicatesWebSolution(nums: IntArray): List<Int> {
            val res = ArrayList<Int>()
            for (i in 0..nums.size - 1) {
                val index = Math.abs(nums[i]) - 1
                if (nums[index] < 0) {
                    res.add(Math.abs(index + 1))
                }
                nums[index] = -nums[index]
            }
            return res
        }
    }
}