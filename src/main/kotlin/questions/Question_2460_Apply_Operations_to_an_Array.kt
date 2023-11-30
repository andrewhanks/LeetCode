package questions

class Question_2460_Apply_Operations_to_an_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,2,1,1,0]
//            Output: [1,4,2,0,0,0]
            val nums = intArrayOf(1, 2, 2, 1, 1, 0)
            val resultList = applyOperations(nums)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 2460: $result")
        }

        fun applyOperations(nums: IntArray): IntArray {
            val result = nums.toMutableList()
            for (count in 1..result.size - 1) {
                if (result[count] == result[count - 1]) {
                    result[count - 1] = result[count - 1] * 2
                    result[count] = 0
                }
            }
            val finalResult = result.filter { it != 0 }.toMutableList()
            val diff = nums.size - finalResult.size
            for (count in 0..diff - 1) {
                finalResult.add(0)
            }
            return finalResult.toIntArray()
        }
    }
}