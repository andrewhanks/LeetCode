package questions


class Question_1253_Reconstruct_a_2_Row_Binary_Matrix {

    companion object {

        fun runQuestion() {
            // Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
            // Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
            val upper = 5
            val lower = 5
            val intArray = intArrayOf(2, 1, 2, 0, 1, 0, 1, 2, 0, 1)
            val resultList = reconstructMatrix(upper, lower, intArray)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            if (']' != result.last()) {
                result += "]"
            }
            println("Question 15: $result")
        }

        fun reconstructMatrix(upper: Int, lower: Int, colsum: IntArray): List<List<Int>> {
            val emptyList = listOf<List<Int>>()
            if (colsum.sum() != upper + lower) {
                return emptyList
            }
            val resultArray: MutableList<MutableList<Int>> = MutableList(2) { MutableList(colsum.size) { 0 } }
            var usedUpper = upper - colsum.filter { it == 2 }.size
            var usedLower = lower - colsum.filter { it == 2 }.size
            println("usedUpper = " + usedUpper + ", usedLower = " + usedLower)
            if (usedUpper < 0 || usedLower < 0) {
                return emptyList
            }
            colsum.forEachIndexed { index, value ->
                when (value) {
                    2 -> {
                        resultArray[0][index] = 1
                        resultArray[1][index] = 1
                    }

                    1 -> {
                        if (usedUpper - 1 >= 0) {
                            resultArray[0][index] = 1
                            usedUpper--
                        } else if (usedLower - 1 >= 0) {
                            resultArray[1][index] = 1
                            usedLower--
                        }
                    }

                    0 -> {
                        resultArray[0][index] = 0
                        resultArray[1][index] = 0
                    }
                }
            }
            return resultArray
        }
    }
}