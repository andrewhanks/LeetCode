package questions

class Question_2643_Row_With_Maximum_Ones {

    companion object {

        fun runQuestion() {
            val intArray1 = intArrayOf(0, 0)
            val intArray2 = intArrayOf(1, 1)
            val intArray3 = intArrayOf(0, 0)
            val twoDimenIntArray = arrayOf(intArray1, intArray2, intArray3)
            val resultList = rowAndMaximumOnes(twoDimenIntArray)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 2643: $result")
        }

        fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {
            var maxOneLine = 0
            var maxOneNumber = 0
            for (arrayLine in 0..mat.size - 1) {
                var tempMaxOneNumber = 0
                for (int in mat[arrayLine]) {
                    if (int == 1) {
                        tempMaxOneNumber++
                    }
                }
                if (tempMaxOneNumber > maxOneNumber) {
                    maxOneNumber = tempMaxOneNumber
                    maxOneLine = arrayLine
                }
            }
            return intArrayOf(maxOneLine, maxOneNumber)
        }
    }
}