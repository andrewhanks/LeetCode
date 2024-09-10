package questions


class Question_1958_Check_if_Move_is_Legal {

    companion object {

        fun runQuestion() {
//            Input: board = [
//                    [".",".",".","B",".",".",".","."],
//                    [".",".",".","W",".",".",".","."],
//                    [".",".",".","W",".",".",".","."],
//                    [".",".",".","W",".",".",".","."],
//                    ["W","B","B",".","W","W","W","B"],
//                    [".",".",".","B",".",".",".","."],
//                    [".",".",".","B",".",".",".","."],
//                    [".",".",".","W",".",".",".","."]],
//                rMove = 4, cMove = 3, color = "B"
//            Output: true
            val board = arrayOf(
                charArrayOf('.', '.', '.', 'B', '.', '.', '.', '.'),
                charArrayOf('.', '.', '.', 'W', '.', '.', '.', '.'),
                charArrayOf('.', '.', '.', 'W', '.', '.', '.', '.'),
                charArrayOf('.', '.', '.', 'W', '.', '.', '.', '.'),
                charArrayOf('W', 'B', 'B', '.', 'W', 'W', 'W', 'B'),
                charArrayOf('.', '.', '.', 'B', '.', '.', '.', '.'),
                charArrayOf('.', '.', '.', 'B', '.', '.', '.', '.'),
                charArrayOf('.', '.', '.', 'W', '.', '.', '.', '.')
            )
            val rMove = 4
            val cMove = 3
            val color = 'B'
            val result = checkMove(board, rMove, cMove, color)
            println("Question 1958: $result")
        }

        fun checkMove(board: Array<CharArray>, rMove: Int, cMove: Int, color: Char): Boolean {
            val dirs = arrayOf(
                intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(1, -1),
                intArrayOf(0, -1), intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1)
            )
            board[rMove][cMove] = color
            for (dir in dirs) {
                if (check(board, rMove, cMove, color, dir)) {
                    return true
                }
            }
            return false
        }

        fun check(board: Array<CharArray>, x: Int, y: Int, color: Char, dir: IntArray): Boolean {
            var length = 1
            var endX = x
            var endY = y
            var secondColor = if (color == 'B') {
                'W'
            } else {
                'B'
            }
            while (endX + dir[0] >= 0 && endX + dir[0] <= board.size - 1 && endY + dir[1] >= 0 && endY + dir[1] <= board[0].size - 1 &&
                board[endX + dir[0]][endY + dir[1]] == secondColor
            ) {
                length++
                endX = endX + dir[0]
                endY = endY + dir[1]
            }
            if (endX + dir[0] >= 0 && endX + dir[0] <= board.size - 1 && endY + dir[1] >= 0 && endY + dir[1] <= board[0].size - 1 &&
                board[endX + dir[0]][endY + dir[1]] == color
            ) {
                length++
                endX = endX + dir[0]
                endY = endY + dir[1]
            } else {
                return false
            }
            if (length < 3) {
                return false
            }
            return true
        }
    }
}