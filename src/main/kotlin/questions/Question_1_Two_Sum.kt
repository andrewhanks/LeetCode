package questions

class Question_1_Two_Sum {

    companion object {

        fun runQuestion() {
            val numberArray = intArrayOf(2, 7, 11, 15)
            val numberSum = 9
            val resultArray = twoSum(numberArray, numberSum)
            var result = "["
            resultArray.forEachIndexed { index, i ->
                result += i
                if (index == resultArray.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 1: $result")
        }

        fun twoSum(nums: IntArray, target: Int): IntArray {
            nums.forEachIndexed { firstNumber, i ->
                for (secondNumber in (firstNumber + 1)..(nums.size - 1)) {
                    if (target == nums[firstNumber] + nums[secondNumber]) {
                        return intArrayOf(firstNumber, secondNumber)
                    }
                }
            }
            return intArrayOf(0)
        }
    }
}