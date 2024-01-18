package questions

class Question_338_Counting_Bits {

    companion object {

        fun runQuestion() {
//            Input: n = 5
//            Output: [0,1,1,2,1,2]
            val n = 5
            val resultList = countBits(n)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 338: $result")
        }

        fun countBits(n: Int): IntArray {
            val result = IntArray(n + 1)
            for (count in 0..n) {
                var temp = count
                var numberCount = 0
                while (temp != 0) {
                    numberCount += temp % 2
                    temp = temp / 2
                }
                result[count] = numberCount
            }
            return result
        }

        fun countBitsWithBuiltInFunction(n: Int): IntArray {
            val result = IntArray(n + 1)
            for (count in 0..n) {
                val binary = Integer.toBinaryString(count)
                val binaryStringBuilder = StringBuilder(binary)
                result[count] = binaryStringBuilder.filter { it == '1' }.count()
            }
            return result
        }
    }
}