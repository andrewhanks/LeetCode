package questions

import java.util.*


class Question_1926_Nearest_Exit_from_Entrance_in_Maze {

    companion object {

        fun runQuestion() {
//            Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
//            Output: 2
            val maze = arrayOf(charArrayOf('+', '+', '+'), charArrayOf('.', '.', '.'), charArrayOf('+', '+', '+'))
            val entrance = intArrayOf(1, 0)
            val result = nearestExit(maze, entrance)
            println("Question 1926: $result")
        }

        fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
            val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
            var ans = 0
            val queue: Queue<IntArray> = LinkedList()
            queue.add(entrance)
            while (!queue.isEmpty()) {
                val size = queue.size
                for (count in 0..size - 1) {
                    val node = queue.remove()
                    if (isValidExit(maze, node[0], node[1], entrance)) {
                        return ans
                    }
                    maze[node[0]][node[1]] = 'v'
                    for (dir in directions) {
                        val x = node[0] + dir[0]
                        val y = node[1] + dir[1]
                        if (isValid(maze, x, y, entrance)) {
                            queue.add(intArrayOf(x, y))
                            maze[x][y] = 'v'
                        }
                    }
                }
                ans++
            }
            return -1
        }

        fun isValidExit(maze: Array<CharArray>, x: Int, y: Int, entrance: IntArray): Boolean {
            return (x == 0 || y == 0 || x == maze.size - 1 || y == maze[0].size - 1) && !(x == entrance[0] && y == entrance[1])
        }

        fun isValid(maze: Array<CharArray>, x: Int, y: Int, entrance: IntArray): Boolean {
            if (x < 0 || y < 0 || x > maze.size - 1 || y > maze[0].size - 1) {
                return false
            }
            if (maze[x][y] != '.' || (x == entrance[0] && y == entrance[1])) {
                return false
            }
            return true
        }
    }
}