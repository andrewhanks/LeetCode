package questions


class Question_1254_Number_of_Closed_Islands {

    companion object {

        fun runQuestion() {
//            Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
//            Output: 2
            val grid = arrayOf(
                intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
                intArrayOf(1, 0, 0, 0, 0, 1, 1, 0),
                intArrayOf(1, 0, 1, 0, 1, 1, 1, 0),
                intArrayOf(1, 0, 0, 0, 0, 1, 0, 1),
                intArrayOf(1, 1, 1, 1, 1, 1, 1, 0)
            )
            val result = closedIsland(grid)
            println("Question 1254: $result")
        }

        fun closedIsland(grid: Array<IntArray>): Int {
            var ans = 0
            for (i in 0..grid.size - 1) {
                for (j in 0..grid[0].size - 1) {
                    if (grid[i][j] == 0 && isClosedIsland(grid, i, j)) {
                        ans++
                    }
                }
            }
            // println("grid = ${grid.contentDeepToString()}")
            return ans
        }

        fun isClosedIsland(grid: Array<IntArray>, x: Int, y: Int): Boolean {
            if (x < 0 || x > grid.size - 1 || y < 0 || y > grid[0].size - 1) {
                return false
            }
            if (grid[x][y] == 1 || grid[x][y] == 2) {
                return true
            }
            if (grid[x][y] == 0) {
                grid[x][y] = 2
            }
            val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
            var closed = true
            for (dir in dirs) {
                val isDirClosed = isClosedIsland(grid, x + dir[0], y + dir[1])
                closed = closed && isDirClosed
            }
            return closed
        }
    }
}