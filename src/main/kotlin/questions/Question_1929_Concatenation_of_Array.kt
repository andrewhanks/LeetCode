package questions

class Question_1929_Concatenation_of_Array {

    companion object {

        fun runQuestion() {
            val numberArray = intArrayOf(1, 3, 2, 1)
            val resultList = getConcatenation(numberArray)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 1929: $result")
        }

        fun getConcatenation(nums: IntArray): IntArray {
            val ans: MutableList<Int> = mutableListOf()
            nums.forEach {
                ans.add(it)
            }
            nums.forEach {
                ans.add(it)
            }
            return ans.toIntArray()
        }
    }
}