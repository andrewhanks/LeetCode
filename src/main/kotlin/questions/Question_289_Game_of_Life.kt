package questions


class Question_289_Game_of_Life {

    companion object {

        fun runQuestion() {
//            Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//            Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
            val matrix = arrayOf(intArrayOf(0, 1, 0), intArrayOf(0, 0, 1), intArrayOf(1, 1, 1), intArrayOf(0, 0, 0))
            gameOfLife(matrix)
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
            println("Question 289: $result")
        }

        fun gameOfLife(board: Array<IntArray>): Unit {
            val toZero: MutableList<IntArray> = mutableListOf()
            val toOne: MutableList<IntArray> = mutableListOf()
            for (x in 0..board.size - 1) {
                for (y in 0..board[x].size - 1) {
                    val oneNumber = checkOneNumber(board, x, y)
                    if (board[x][y] == 1 && (oneNumber < 2 || oneNumber > 3)) {
                        toZero.add(intArrayOf(x, y))
                    } else if (board[x][y] == 0 && oneNumber == 3) {
                        toOne.add(intArrayOf(x, y))
                    }
                }
            }
            for (count in 0..toZero.size - 1) {
                val pos = toZero[count]
                board[pos[0]][pos[1]] = 0
            }
            for (count in 0..toOne.size - 1) {
                val pos = toOne[count]
                board[pos[0]][pos[1]] = 1
            }
        }

        fun checkOneNumber(board: Array<IntArray>, x: Int, y: Int): Int {
            var oneNumber = 0
            if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == 1) {
                oneNumber++
            }
            if (x - 1 >= 0 && board[x - 1][y] == 1) {
                oneNumber++
            }
            if (x - 1 >= 0 && y + 1 <= board[0].size - 1 && board[x - 1][y + 1] == 1) {
                oneNumber++
            }
            if (y - 1 >= 0 && board[x][y - 1] == 1) {
                oneNumber++
            }
            if (y + 1 <= board[0].size - 1 && board[x][y + 1] == 1) {
                oneNumber++
            }
            if (x + 1 <= board.size - 1 && y - 1 >= 0 && board[x + 1][y - 1] == 1) {
                oneNumber++
            }
            if (x + 1 <= board.size - 1 && board[x + 1][y] == 1) {
                oneNumber++
            }
            if (x + 1 <= board.size - 1 && y + 1 <= board[0].size - 1 && board[x + 1][y + 1] == 1) {
                oneNumber++
            }
            return oneNumber
        }
    }
}