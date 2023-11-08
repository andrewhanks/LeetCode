package questions

class Question_52_N_Queens_II {

    companion object {

        fun runQuestion() {
//            Input: n = 4
//            Output: 2
            val n = 4
            val result = totalNQueens(n)
            println("Question 52: $result")
        }

        fun totalNQueens(n: Int): Int {
            val result: Array<IntArray> = Array(n) { IntArray(n) { 0 } }
            return dfs(result, 0)
        }

        fun dfs(result: Array<IntArray>, column: Int): Int {
            if (column == result.size) {
                return 1
            }
            var count = 0
            for (row in 0..result.size - 1) {
                if (isSafe(result, row, column)) {
                    result[row][column] = 1
                    count += dfs(result, column + 1)
                    result[row][column] = 0
                }
            }
            return count
        }

        fun isSafe(result: Array<IntArray>, row: Int, column: Int): Boolean {
            var tempRow = row
            var tempColumn = column
            while (tempRow >= 0 && tempColumn >= 0) {
                if (result[tempRow][tempColumn] == 1) {
                    return false
                }
                tempRow--
                tempColumn--
            }
            tempRow = row
            tempColumn = column
            while (tempColumn >= 0) {
                if (result[tempRow][tempColumn] == 1) {
                    return false
                }
                tempColumn--
            }
            tempRow = row
            tempColumn = column
            while (tempRow <= result.size - 1 && tempColumn >= 0) {
                if (result[tempRow][tempColumn] == 1) {
                    return false
                }
                tempRow++
                tempColumn--
            }
            return true
        }
    }
}