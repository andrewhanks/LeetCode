package questions

import java.util.*


class Question_1905_Count_Sub_Islands {

    companion object {

        fun runQuestion() {
//            Input: grid1 = [[0,1,1,1,0],[1,0,1,0,1],[0,1,1,1,1],[0,0,1,0,0],[1,0,0,1,1]]
//                   grid2 = [[0,1,1,0,1],[1,0,1,1,0],[0,1,1,1,1],[0,0,1,0,0],[0,0,0,1,1]]
//            Output: 2
            val grid1 = arrayOf(
                intArrayOf(0, 1, 1, 1, 0),
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(0, 1, 1, 1, 1),
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(1, 0, 0, 1, 1)
            )
            val grid2 = arrayOf(
                intArrayOf(0, 1, 1, 0, 1),
                intArrayOf(1, 0, 1, 1, 0),
                intArrayOf(0, 1, 1, 1, 1),
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(0, 0, 0, 1, 1)
            )
            val result = countSubIslands(grid1, grid2)
            println("Question 1905: $result")
        }

        fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
            var ans = 0
            for (i in 0..grid2.size - 1) {
                for (j in 0..grid2[0].size - 1) {
                    if (grid2[i][j] == 1) {
                        if (checkBfs(grid1, grid2, i, j)) {
                            ans++
                        }
                    }
                }
            }
            return ans
        }

        fun checkBfs(grid1: Array<IntArray>, grid2: Array<IntArray>, x: Int, y: Int): Boolean {
            val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
            val queue: Queue<IntArray> = LinkedList()
            var ret = true
            queue.add(intArrayOf(x, y))
            grid2[x][y] = 0
            while (!queue.isEmpty()) {
                val size = queue.size
                for (count in 0..size - 1) {
                    val node = queue.remove()
                    if (grid1[node[0]][node[1]] == 0) {
                        ret = false
                    }
                    for (dir in dirs) {
                        val nextX = node[0] + dir[0]
                        val nextY = node[1] + dir[1]
                        if (nextX < 0 || nextX > grid2.size - 1 || nextY < 0 || nextY > grid2[0].size - 1 || grid2[nextX][nextY] != 1) {
                            continue
                        }
                        queue.add(intArrayOf(nextX, nextY))
                        grid2[nextX][nextY] = 0
                    }
                }
            }
            return ret
        }

        fun countSubIslandsDfs(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
            var ans = 0
            for (i in 0..grid2.size - 1) {
                for (j in 0..grid2[0].size - 1) {
                    if (grid2[i][j] == 1) {
                        if (checkDfs(grid1, grid2, i, j)) {
                            ans++
                        }
                    }
                }
            }
            return ans
        }

        fun checkDfs(grid1: Array<IntArray>, grid2: Array<IntArray>, x: Int, y: Int): Boolean {
            if (x < 0 || x > grid2.size - 1 || y < 0 || y > grid2[0].size - 1 || grid2[x][y] == 0) {
                return true
            }
            if (grid2[x][y] == 1 && grid1[x][y] == 0) {
                return false
            }
            grid2[x][y] = 0
            val right = checkDfs(grid1, grid2, x, y + 1)
            val down = checkDfs(grid1, grid2, x + 1, y)
            val left = checkDfs(grid1, grid2, x, y - 1)
            val up = checkDfs(grid1, grid2, x - 1, y)
            return up && down && left && right
        }
    }
}