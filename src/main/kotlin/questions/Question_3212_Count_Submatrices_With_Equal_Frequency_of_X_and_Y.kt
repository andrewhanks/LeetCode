package questions


class Question_3212_Count_Submatrices_With_Equal_Frequency_of_X_and_Y {

    companion object {

        fun runQuestion() {
//            Input: grid = [["X","Y","."],["Y",".","."]]
//            Output: 3
            val grid = arrayOf(
                charArrayOf('X', 'Y', '.'),
                charArrayOf('Y', '.', '.')
            )
            val result = numberOfSubmatrices(grid)
            println("Question 3212: $result")
        }

        fun numberOfSubmatrices(grid: Array<CharArray>): Int {
            val result = Array(grid.size) { Array(grid[0].size) { IntArray(2) { 0 } } }
            for (count in 0..grid.size - 1) {
                if (grid[count][0] == 'X') {
                    if (count == 0) {
                        result[count][0][0] = 1
                        result[count][0][1] = 0
                    } else {
                        result[count][0][0] = result[count - 1][0][0] + 1
                        result[count][0][1] = result[count - 1][0][1]
                    }
                } else if (grid[count][0] == 'Y') {
                    if (count == 0) {
                        result[count][0][0] = 0
                        result[count][0][1] = 1
                    } else {
                        result[count][0][0] = result[count - 1][0][0]
                        result[count][0][1] = result[count - 1][0][1] + 1
                    }
                } else {
                    if (count > 0) {
                        result[count][0][0] = result[count - 1][0][0]
                        result[count][0][1] = result[count - 1][0][1]
                    }
                }
            }
            for (count in 0..grid[0].size - 1) {
                if (grid[0][count] == 'X') {
                    if (count == 0) {
                        result[0][count][0] = 1
                        result[0][count][1] = 0
                    } else {
                        result[0][count][0] = result[0][count - 1][0] + 1
                        result[0][count][1] = result[0][count - 1][1]
                    }
                } else if (grid[0][count] == 'Y') {
                    if (count == 0) {
                        result[0][count][0] = 0
                        result[0][count][1] = 1
                    } else {
                        result[0][count][0] = result[0][count - 1][0]
                        result[0][count][1] = result[0][count - 1][1] + 1
                    }
                } else {
                    if (count > 0) {
                        result[0][count][0] = result[0][count - 1][0]
                        result[0][count][1] = result[0][count - 1][1]
                    }
                }
            }
            for (i in 1..grid.size - 1) {
                for (j in 1..grid[i].size - 1) {
                    if (grid[i][j] == 'X') {
                        result[i][j][0] = result[i - 1][j][0] + result[i][j - 1][0] - result[i - 1][j - 1][0] + 1
                        result[i][j][1] = result[i - 1][j][1] + result[i][j - 1][1] - result[i - 1][j - 1][1]
                    } else if (grid[i][j] == 'Y') {
                        result[i][j][0] = result[i - 1][j][0] + result[i][j - 1][0] - result[i - 1][j - 1][0]
                        result[i][j][1] = result[i - 1][j][1] + result[i][j - 1][1] - result[i - 1][j - 1][1] + 1
                    } else {
                        result[i][j][0] = result[i - 1][j][0] + result[i][j - 1][0] - result[i - 1][j - 1][0]
                        result[i][j][1] = result[i - 1][j][1] + result[i][j - 1][1] - result[i - 1][j - 1][1]
                    }
                }
            }
            // println(result.contentDeepToString())
            var ret = 0
            for (i in 0..result.size - 1) {
                for (j in 0..result[i].size - 1) {
                    if (result[i][j][0] >= 1 && result[i][j][0] == result[i][j][1]) {
                        ret++
                    }
                }
            }
            return ret
        }
    }
}