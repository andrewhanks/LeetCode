package questions

import java.util.*


class Question_1091_Shortest_Path_in_Binary_Matrix {

    companion object {

        fun runQuestion() {
//            Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
//            Output: 4
            val grid = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 0), intArrayOf(1, 1, 0))
            val result = shortestPathBinaryMatrix(grid)
            println("Question 1091: $result")
        }

        fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
            if (grid[0][0] == 1) {
                return -1
            }
            if (grid[0][0] == 0 && grid.size == 1 && grid[0].size == 1) {
                return 1
            }
            val dirs = arrayOf(
                intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(1, -1),
                intArrayOf(0, -1), intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1),
            )
            val visited = Array(grid.size) { Array(grid[0].size) { false } }
            val queue: Queue<IntArray> = LinkedList()
            queue.add(intArrayOf(0, 0))
            visited[0][0] = true
            var ans = 1
            while (!queue.isEmpty()) {
                val size = queue.size
                for (count in 0..size - 1) {
                    val node = queue.remove()
                    // println("=======================")
                    for (dir in dirs) {
                        val x = node[0] + dir[0]
                        val y = node[1] + dir[1]
                        if (x < 0 || y < 0 || x > grid.size - 1 || y > grid[0].size - 1) {
                            continue
                        }
                        if (x == grid.size - 1 && y == grid[0].size - 1 && grid[x][y] == 0) {
                            // println("final x = $x, y = $y")
                            return ans + 1
                        }
                        if (!visited[x][y] && grid[x][y] == 0) {
                            // println("x = $x, y = $y")
                            queue.add(intArrayOf(x, y))
                            visited[x][y] = true
                        }
                    }
                }
                ans++
            }
            return -1
        }
    }
}