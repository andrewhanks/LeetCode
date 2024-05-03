package questions

import kotlin.math.max


class Question_695_Max_Area_of_Island {

    companion object {

        fun runQuestion() {
//            Input: grid = [
//                [0,0,1,0,0,0,0,1,0,0,0,0,0],
//                [0,0,0,0,0,0,0,1,1,1,0,0,0],
//                [0,1,1,0,1,0,0,0,0,0,0,0,0],
//                [0,1,0,0,1,1,0,0,1,0,1,0,0],
//                [0,1,0,0,1,1,0,0,1,1,1,0,0],
//                [0,0,0,0,0,0,0,0,0,0,1,0,0],
//                [0,0,0,0,0,0,0,1,1,1,0,0,0],
//                [0,0,0,0,0,0,0,1,1,0,0,0,0]
//            ]
//            Output: 6
            val grid =
                arrayOf(
                    intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                    intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
                )
            val result = maxAreaOfIsland(grid)
            println("Question 695: $result")
        }

        fun maxAreaOfIsland(grid: Array<IntArray>): Int {
            var max = 0
            for (i in 0..grid.size - 1) {
                for (j in 0..grid[0].size - 1) {
                    if (grid[i][j] == 1) {
                        val count = find(grid, i, j)
                        max = max(max, count)
                    }
                }
            }
            return max
        }

        fun find(grid: Array<IntArray>, i: Int, j: Int): Int {
            if (i < 0 || i > grid.size - 1 || j < 0 || j > grid[0].size - 1) {
                return 0
            }
            if (grid[i][j] != 1) {
                return 0
            }
            grid[i][j] = 2
            return find(grid, i - 1, j) + find(grid, i + 1, j) + find(grid, i, j - 1) + find(grid, i, j + 1) + 1
        }
    }
}