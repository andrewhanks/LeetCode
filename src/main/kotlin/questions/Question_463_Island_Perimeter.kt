package questions


class Question_463_Island_Perimeter {

    companion object {

        fun runQuestion() {
//            Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//            Output: 16
            val grid =
                arrayOf(intArrayOf(0, 1, 0, 0), intArrayOf(1, 1, 1, 0), intArrayOf(0, 1, 0, 0), intArrayOf(1, 1, 0, 0))
            val result = islandPerimeter(grid)
            println("Question 463: $result")
        }

        fun islandPerimeter(grid: Array<IntArray>): Int {
            var dropEdge = 0
            for (i in 0..grid.size - 1) {
                for (j in 0..grid[0].size - 1) {
                    if (grid[i][j] == 0) {
                        continue
                    }
                    if (checkAround(grid, i, j - 1)) {
                        dropEdge++
                    }
                    if (checkAround(grid, i, j + 1)) {
                        dropEdge++
                    }
                    if (checkAround(grid, i - 1, j)) {
                        dropEdge++
                    }
                    if (checkAround(grid, i + 1, j)) {
                        dropEdge++
                    }
                }
            }
            var edgeCount = 0
            for (count in 0..grid.size - 1) {
                edgeCount += grid[count].filter { it == 1 }.count()
            }
            val result = edgeCount * 4 - dropEdge
            return result
        }

        fun checkAround(grid: Array<IntArray>, i: Int, j: Int): Boolean {
            if (i < 0 || i > grid.size - 1 || j < 0 || j > grid[0].size - 1) {
                return false
            }
            if (grid[i][j] == 0) {
                return false
            }
            return true
        }
    }
}