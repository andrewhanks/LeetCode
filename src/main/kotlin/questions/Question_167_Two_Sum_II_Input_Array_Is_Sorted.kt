package questions

class Question_167_Two_Sum_II_Input_Array_Is_Sorted {

    companion object {

        fun runQuestion() {
            val numberArray = intArrayOf(2, 7, 11, 15)
            val target = 9
            val resultArray = twoSum(numberArray, target)
            var result = "["
            resultArray.forEachIndexed { index, i ->
                result += i
                if (index == resultArray.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 167: $result")
        }

        fun twoSum(numbers: IntArray, target: Int): IntArray {
            val result: IntArray = IntArray(2) { 0 }
            for (i in 0..numbers.size - 1) {
                for (j in i + 1..numbers.size - 1) {
                    if (target == numbers[i] + numbers[j]) {
                        result[0] = i + 1
                        result[1] = j + 1
                        break
                    }
                }
            }
            return result.sorted().toIntArray()
        }
    }
}