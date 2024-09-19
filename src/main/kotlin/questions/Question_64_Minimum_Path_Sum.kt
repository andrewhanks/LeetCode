package questions

import kotlin.math.min


class Question_64_Minimum_Path_Sum {

    companion object {

        fun runQuestion() {
//            Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//            Output: 7
            val grid = arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))
            val result = minPathSum(grid)
            println("Question 64: $result")
        }

        fun minPathSum(grid: Array<IntArray>): Int {
            val min: Array<IntArray> = Array(grid.size) { IntArray(grid[0].size) { 0 } }
            for (x in 0..grid.size - 1) {
                for (y in 0..grid[0].size - 1) {
                    if (x == 0 && y == 0) {
                        min[x][y] = grid[x][y]
                    } else if (x == 0) {
                        min[x][y] = min[x][y - 1] + grid[x][y]
                    } else if (y == 0) {
                        min[x][y] = min[x - 1][y] + grid[x][y]
                    } else {
                        min[x][y] = min(min[x][y - 1], min[x - 1][y]) + grid[x][y]
                    }
                }
            }
            return min[grid.size - 1][grid[0].size - 1]
        }

        fun minPathSumWithRecursive(grid: Array<IntArray>): Int {
            val result = Array(grid.size) { IntArray(grid[0].size) { -1 } }
            val ans = recursive(grid, result, result.size - 1, result[0].size - 1)
            // println("result = ${result.contentDeepToString()}")
            return ans
        }

        fun recursive(grid: Array<IntArray>, result: Array<IntArray>, x: Int, y: Int): Int {
            if (x < 0 || x > grid.size - 1 || y < 0 || y > grid[0].size - 1) {
                return 10000000
            }
            if (result[x][y] != -1) {
                return result[x][y]
            }
            if (x == 0 && y == 0) {
                result[x][y] = grid[x][y]
                return result[x][y]
            }
            result[x][y] = min(recursive(grid, result, x, y - 1), recursive(grid, result, x - 1, y)) + grid[x][y]
            // println("result[$x][$y] = ${result[x][y]}")
            return result[x][y]
        }
    }
}