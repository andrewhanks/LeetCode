package questions

class Question_688_Knight_Probability_in_Chessboard {

    companion object {

        fun runQuestion() {
//            Input: n = 3, k = 2, row = 0, column = 0
//            Output: 0.06250
            val n = 3
            val k = 2
            val row = 0
            val column = 0
            val result = knightProbability(n, k, row, column)
            println("Question 688: $result")
        }

        fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
            val dirs = arrayOf(
                intArrayOf(-2, 1), intArrayOf(-1, 2), intArrayOf(1, 2), intArrayOf(2, 1),
                intArrayOf(2, -1), intArrayOf(1, -2), intArrayOf(-1, -2), intArrayOf(-2, -1)
            )
            var result = MutableList(n) { MutableList(n) { 0.0 } }
            result[row][column] = 1.0
            for (i in 0..k - 1) {
                val newResult = MutableList(n) { MutableList(n) { 0.0 } }
                for (i in 0..result.size - 1) {
                    for (j in 0..result[0].size - 1) {
                        for (dir in dirs) {
                            val nextX = i + dir[0]
                            val nextY = j + dir[1]
                            if (nextX < 0 || nextX > result.size - 1 || nextY < 0 || nextY > result[0].size - 1) {
                                continue
                            }
                            newResult[nextX][nextY] += result[i][j] / 8.0
                        }
                    }
                }
                result = newResult.toMutableList()
            }
            var ans = 0.0
            for (i in 0..result.size - 1) {
                for (j in 0..result[0].size - 1) {
                    ans += result[i][j]
                }
            }
            return ans
        }
    }
}