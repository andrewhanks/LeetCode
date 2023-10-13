package questions


class Question_73_Set_Matrix_Zeroes {

    companion object {

        fun runQuestion() {
//            Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//            Output: [[1,0,1],[0,0,0],[1,0,1]]
            val matrix = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1))
            setZeroes(matrix)
            var result = "["
            matrix.forEachIndexed { firstIndex, firstI ->
                matrix[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == matrix[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == matrix.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            if (']' != result.last()) {
                result += "]"
            }
            println("Question 73: $result")
        }

        fun setZeroes(matrix: Array<IntArray>): Unit {
            val zeroX: MutableList<Int> = mutableListOf()
            val zeroY: MutableList<Int> = mutableListOf()
            for (x in 0..matrix.size - 1) {
                for (y in 0..matrix[x].size - 1) {
                    if (matrix[x][y] == 0) {
                        zeroX.add(x)
                        zeroY.add(y)
                    }
                }
            }
            println(zeroX)
            println(zeroY)
            for (x in 0..zeroX.size - 1) {
                val row = zeroX[x]
                for (y in 0..matrix[row].size - 1) {
                    matrix[row][y] = 0
                }
            }
            for (y in 0..zeroY.size - 1) {
                val column = zeroY[y]
                for (x in 0..matrix.size - 1) {
                    matrix[x][column] = 0
                }
            }
        }
    }
}