package questions


class Question_130_Surrounded_Regions {

    companion object {

        fun runQuestion() {
//            Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
//            Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
            val board = arrayOf(
                charArrayOf('X', 'X', 'X', 'X'),
                charArrayOf('X', 'O', 'O', 'X'),
                charArrayOf('X', 'X', 'O', 'X'),
                charArrayOf('X', 'O', 'X', 'X')
            )
            solve(board)
            println("Question 130: ${board.contentDeepToString()}")
        }

        fun solve(board: Array<CharArray>): Unit {
            for (i in 0..board.size - 1) {
                for (j in 0..board[0].size - 1) {
                    if (i == 0 || i == board.size - 1 || j == 0 || j == board[0].size - 1) {
                        check(board, i, j)
                    }
                }
            }
            for (i in 0..board.size - 1) {
                for (j in 0..board[0].size - 1) {
                    if (board[i][j] != 'T') {
                        board[i][j] = 'X'
                    } else {
                        board[i][j] = 'O'
                    }
                }
            }
        }

        fun check(board: Array<CharArray>, i: Int, j: Int) {
            if (i < 0 || i > board.size - 1 || j < 0 || j > board[0].size - 1) {
                return
            }
            if (board[i][j] != 'O') {
                return
            }
            board[i][j] = 'T'
            check(board, i - 1, j)
            check(board, i + 1, j)
            check(board, i, j - 1)
            check(board, i, j + 1)
        }

        fun solveOldSolution(board: Array<CharArray>): Unit {
            for (i in 0..board.size - 1) {
                if (board[i][0] == 'O') {
                    dfs(board, i, 0)
                }
                if (board[i][board[0].size - 1] == 'O') {
                    dfs(board, i, board[0].size - 1)
                }
            }
            for (i in 0..board[0].size - 1) {
                if (board[0][i] == 'O') {
                    dfs(board, 0, i)
                }
                if (board[board.size - 1][i] == 'O') {
                    dfs(board, board.size - 1, i)
                }
            }
            for (x in 0..board.size - 1) {
                for (y in 0..board[0].size - 1) {
                    if (board[x][y] == 'P') {
                        board[x][y] = 'O'
                    } else if (board[x][y] == 'O') {
                        board[x][y] = 'X'
                    }
                }
            }
        }

        fun dfs(board: Array<CharArray>, x: Int, y: Int) {
            if (x < 0 || y < 0 || x >= board.size || y >= board[0].size || board[x][y] != 'O') {
                return
            }
            board[x][y] = 'P'
            dfs(board, x + 1, y)
            dfs(board, x - 1, y)
            dfs(board, x, y + 1)
            dfs(board, x, y - 1)
        }
    }
}