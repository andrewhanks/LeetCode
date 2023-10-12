package questions


class Question_48_Rotate_Image {

    companion object {

        fun runQuestion() {
//            Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//            Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
            val matrix = arrayOf(
                intArrayOf(5, 1, 9, 11),
                intArrayOf(2, 4, 8, 10),
                intArrayOf(13, 3, 6, 7),
                intArrayOf(15, 14, 12, 16)
            )
            rotate(matrix)
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
            println("Question 48: $result")
        }

        fun rotate(matrix: Array<IntArray>): Unit {
            val temp: MutableList<Int> = mutableListOf()
            for (x in 0..matrix[0].size - 1) {
                for (y in matrix.size - 1 downTo 0) {
                    temp.add(matrix[y][x])
                }
            }
            println(temp)
            for (x in 0..matrix.size - 1) {
                for (y in 0..matrix[0].size - 1) {
                    matrix[x][y] = temp[x * matrix[0].size + y]
                }
            }
        }
    }
}