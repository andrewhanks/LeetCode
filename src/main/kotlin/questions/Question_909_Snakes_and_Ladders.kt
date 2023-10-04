package questions

import java.util.*


class Question_909_Snakes_and_Ladders {

    companion object {

        fun runQuestion() {
//            Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
//            Output: 4
            val intArray = arrayOf(
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, 35, -1, -1, 13, -1),
                intArrayOf(-1, -1, -1, -1, -1, -1),
                intArrayOf(-1, 15, -1, -1, -1, -1)
            )
            val result = snakesAndLadders(intArray)
            println("Question 909: $result")
        }

        fun snakesAndLadders(board: Array<IntArray>): Int {
            val boardQueue: Queue<Int> = LinkedList()
            boardQueue.add(1)
            var result = 0
            while (!boardQueue.isEmpty()) {
                println("============================")
                result++
                for (size in 1..boardQueue.size) {
                    val current = boardQueue.remove()
                    for (count in 1..6) {
                        var next = current + count
                        val nextGrid = getBoardNumber(board, next)
                        next = if (board[nextGrid[0]][nextGrid[1]] == -1) {
                            next
                        } else {
                            board[nextGrid[0]][nextGrid[1]]
                        }
                        if (next >= board.size * board[0].size) {
                            return result
                        }
                        if (board[nextGrid[0]][nextGrid[1]] == -2) {
                            continue
                        }
                        boardQueue.add(next)
                        board[nextGrid[0]][nextGrid[1]] = -2
                    }
                }
            }
            return -1
        }

        fun getBoardNumber(board: Array<IntArray>, next: Int): IntArray {
            val row = board.size - 1 - ((next - 1) / board.size)
            val column = if (((next - 1) / board[0].size) % 2 == 0) {
                (next - 1) % board[0].size
            } else {
                board[0].size - 1 - (next - 1) % board[0].size
            }
            println("$row, $column, $next")
            return intArrayOf(row, column)
        }
    }
}