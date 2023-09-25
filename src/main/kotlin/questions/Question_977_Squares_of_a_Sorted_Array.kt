package questions

class Question_977_Squares_of_a_Sorted_Array {

    companion object {

        fun runQuestion() {
            // [-4,-1,0,3,10]
            val inputArray = intArrayOf(-4, -1, 0, 3, 10)
            val resultList = sortedSquares(inputArray)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 977: $result")
        }

        fun sortedSquares(nums: IntArray): IntArray {
            val resultArray: MutableList<Int> = mutableListOf()
            nums.forEach { value ->
                resultArray.add(value * value)
            }
            return resultArray.sorted().toIntArray()
        }
    }
}