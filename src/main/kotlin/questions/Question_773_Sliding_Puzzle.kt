package questions

import java.util.*


class Question_773_Sliding_Puzzle {

    companion object {

        fun runQuestion() {
//            Input: board = [[4,1,2],[5,0,3]]
//            Output: 5
            val board = arrayOf(intArrayOf(4, 1, 2), intArrayOf(5, 0, 3))
            val result = slidingPuzzle(board)
            println("Question 773: $result")
        }

        fun slidingPuzzle(board: Array<IntArray>): Int {
            val dirs = listOf(listOf(1, 0), listOf(-1, 0), listOf(0, 1), listOf(0, -1))
            val queue: Queue<List<Int>> = LinkedList()
            val currBoardQueue: Queue<MutableList<MutableList<Int>>> = LinkedList()
            val visited: MutableList<MutableList<MutableList<Int>>> = mutableListOf()
            val current: MutableList<MutableList<Int>> = mutableListOf()
            for (i in 0..board.size - 1) {
                val list = mutableListOf<Int>()
                for (j in 0..board[0].size - 1) {
                    if (board[i][j] == 0) {
                        queue.add(listOf(i, j, 0))
                    }
                    list.add(board[i][j])
                }
                current.add(list)
            }
            currBoardQueue.add(current)
            if (isSolved(current)) {
                return 0
            }
            while (!queue.isEmpty()) {
                val item = queue.remove()
                val currentBoard = currBoardQueue.remove()
                // println("item = $item, currentBoard = $currentBoard")
                for (dir in dirs) {
                    val x = item[0] + dir[0]
                    val y = item[1] + dir[1]
                    if (x < 0 || x > board.size - 1 || y < 0 || y > board[0].size - 1) {
                        continue
                    }
                    val temp: MutableList<MutableList<Int>> = mutableListOf()
                    for (i in 0..currentBoard.size - 1) {
                        val list = mutableListOf<Int>()
                        for (j in 0..currentBoard[0].size - 1) {
                            list.add(currentBoard[i][j])
                        }
                        temp.add(list)
                    }
                    val number = temp[x][y]
                    temp[x][y] = temp[item[0]][item[1]]
                    temp[item[0]][item[1]] = number
                    // println("temp = $temp")
                    if (isSolved(temp)) {
                        return item[2] + 1
                    }
                    if (visited.contains(temp)) {
                        continue
                    }
                    visited.add(temp)
                    queue.add(listOf(x, y, item[2] + 1))
                    currBoardQueue.add(temp)
                }
            }
            return -1
        }

        fun isSolved(board: MutableList<MutableList<Int>>): Boolean {
            // println("=============================board = $board")
            for (i in 0..board.size - 1) {
                for (j in 0..board[0].size - 1) {
                    // println("board[$i][$j] = ${board[i][j]}, i*board[0].size+j+1 = ${i*board[0].size+j+1}")
                    if (i == board.size - 1 && j == board[0].size - 1) {
                        return true
                    }
                    if (board[i][j] != i * board[0].size + j + 1) {
                        return false
                    }
                }
            }
            return true
        }

        fun slidingPuzzleWithString(board: Array<IntArray>): Int {
            val dirs = listOf(listOf(1, 0), listOf(-1, 0), listOf(0, 1), listOf(0, -1))
            val queue: Queue<String> = LinkedList()
            val visited: MutableList<String> = mutableListOf()
            var str = ""
            for (i in 0..board.size - 1) {
                for (j in 0..board[0].size - 1) {
                    str += board[i][j]
                }
            }
            if (str == "123450") {
                return 0
            }
            queue.add(str)
            visited.add(str)
            var times = 0
            while (!queue.isEmpty()) {
                val size = queue.size
                for (i in 0..size - 1) {
                    val item = queue.remove()
                    val index = item.indexOf('0')
                    for (dir in dirs) {
                        val x = index / 3 + dir[0]
                        val y = index % 3 + dir[1]
                        if (x < 0 || x > board.size - 1 || y < 0 || y > board[0].size - 1) {
                            continue
                        }
                        val index2 = x * 3 + y
                        val temp = StringBuilder(item)
                        val number = temp[index]
                        temp[index] = temp[index2]
                        temp[index2] = number
                        val tempStr = temp.toString()
                        if (tempStr == "123450") {
                            return times + 1
                        }
                        if (visited.contains(tempStr)) {
                            continue
                        }
                        visited.add(tempStr)
                        queue.add(tempStr)
                    }
                }
                times++
            }
            return -1
        }
    }
}