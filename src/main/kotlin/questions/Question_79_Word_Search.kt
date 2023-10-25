package questions


class Question_79_Word_Search {

    companion object {

        fun runQuestion() {
//            Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//            Output: true
            val board = arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            )
            val word = "ABCCED"
            val result = exist(board, word)
            println("Question 79: $result")
        }

        fun exist(board: Array<CharArray>, word: String): Boolean {
            val path: Array<IntArray> = Array(board.size) { IntArray(board[0].size) { 0 } }
            for (i in 0..board.size - 1) {
                for (j in 0..board[i].size - 1) {
                    if (board[i][j] == word[0]) {
                        if (checkExistence(board, path, word, i, j, 0, 0)) {
                            return true
                        }
                    }
                }
            }
            return false
        }

//        0->no move
//        1->from up
//        2->from right
//        3->from down
//        4->from left
        fun checkExistence(
            board: Array<CharArray>,
            path: Array<IntArray>,
            word: String,
            i: Int,
            j: Int,
            count: Int,
            from: Int
        ): Boolean {
            if (i < 0 || i > board.size - 1 || j < 0 || j > board[0].size - 1 || board[i][j] != word[count]) {
                return false
            }
            if (path[i][j] == 1) {
                return false
            }
            if (count == word.length - 1 && board[i][j] == word[count]) {
                return true
            }
            path[i][j] = 1
            val toUp = checkExistence(board, path, word, i - 1, j, count + 1, 3)
            val toDown = checkExistence(board, path, word, i + 1, j, count + 1, 1)
            val toLeft = checkExistence(board, path, word, i, j - 1, count + 1, 2)
            val toRight = checkExistence(board, path, word, i, j + 1, count + 1, 4)
            if (!toUp && !toDown && !toLeft && !toRight) {
                path[i][j] = 0
            }
            if (from == 1) {
                return toDown || toLeft || toRight
            } else if (from == 2) {
                return toUp || toDown || toLeft
            } else if (from == 3) {
                return toUp || toLeft || toRight
            } else if (from == 4) {
                return toUp || toDown || toRight
            } else {
                return toUp || toDown || toLeft || toRight
            }
        }
    }
}