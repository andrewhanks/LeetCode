package questions

class Question_66_Plus_One {

    companion object {

        fun runQuestion() {
//            Input: digits = [9]
//            Output: [1,0]
            val digits = intArrayOf(9)
            val resultList = plusOne(digits)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 66: $result")
        }

        fun plusOne(digits: IntArray): IntArray {
            val size = digits.size
            if (digits[size - 1] != 9) {
                digits[size - 1]++
                return digits
            } else {
                var count = size - 1
                while (count >= 0 && digits[count] == 9) {
                    digits[count] = 0
                    count--
                }
                if (count < 0) {
                    val result = digits.toMutableList()
                    result.add(0, 1)
                    return result.toIntArray()
                } else {
                    digits[count]++
                }
                return digits
            }
        }
    }
}