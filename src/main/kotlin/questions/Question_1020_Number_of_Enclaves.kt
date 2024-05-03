package questions


class Question_1020_Number_of_Enclaves {

    companion object {

        fun runQuestion() {
//            Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//            Output: 3
            val grid =
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(1, 0, 1, 0),
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0)
                )
            val result = numEnclaves(grid)
            println("Question 1020: $result")
        }

        fun numEnclaves(grid: Array<IntArray>): Int {
            for (i in 0..grid.size - 1) {
                for (j in 0..grid[0].size - 1) {
                    if ((i == 0 || j == 0 || i == grid.size - 1 || j == grid[0].size - 1) && grid[i][j] == 1) {
                        changeType(grid, i, j)
                    }
                }
            }
            var result = 0
            for (count in 0..grid.size - 1) {
                println(grid[count].filter { it == 1 }.count())
                result += grid[count].filter { it == 1 }.count()
            }
            return result
        }

        fun changeType(grid: Array<IntArray>, i: Int, j: Int) {
            if (i < 0 || i > grid.size - 1 || j < 0 || j > grid[0].size - 1) {
                return
            }
            if (grid[i][j] != 1) {
                return
            }
            grid[i][j] = 2
            changeType(grid, i - 1, j)
            changeType(grid, i + 1, j)
            changeType(grid, i, j - 1)
            changeType(grid, i, j + 1)
        }
    }
}