package questions

import kotlin.math.max


class Question_1219_Path_with_Maximum_Gold {

    companion object {

        fun runQuestion() {
//            Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
//            Output: 24
            val grid = arrayOf(
                intArrayOf(0, 6, 0),
                intArrayOf(5, 8, 7),
                intArrayOf(0, 9, 0)
            )
            val result = getMaximumGold(grid)
            println("Question 1219: $result")
        }

        fun getMaximumGold(grid: Array<IntArray>): Int {
            var ans = 0
            for (x in 0..grid.size - 1) {
                for (y in 0..grid[0].size - 1) {
                    if (grid[x][y] == 0) {
                        continue
                    }
                    val visited = Array(grid.size) { Array(grid[0].size) { false } }
                    ans = max(ans, calculate(grid, visited, x, y))
                }
            }
            return ans
        }

        fun calculate(grid: Array<IntArray>, visited: Array<Array<Boolean>>, x: Int, y: Int): Int {
            val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
            if (x < 0 || x > grid.size - 1 || y < 0 || y > grid[0].size - 1) {
                return 0
            }
            if (visited[x][y]) {
                return 0
            }
            if (grid[x][y] == 0) {
                return 0
            }
            visited[x][y] = true
            var max = 0
            for (dir in dirs) {
                max = max(max, calculate(grid, visited, x + dir[0], y + dir[1]))
            }
            visited[x][y] = false
            return max + grid[x][y]
        }

        fun getMaximumGoldWithSumParameter(grid: Array<IntArray>): Int {
            var ans = 0
            for (x in 0..grid.size - 1) {
                for (y in 0..grid[0].size - 1) {
                    if (grid[x][y] == 0) {
                        continue
                    }
                    val visited = Array(grid.size) { Array(grid[0].size) { false } }
                    ans = max(ans, calculateWithSumParameter(grid, visited, x, y, 0))
                }
            }
            return ans
        }

        fun calculateWithSumParameter(
            grid: Array<IntArray>,
            visited: Array<Array<Boolean>>,
            x: Int,
            y: Int,
            sum: Int
        ): Int {
            val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
            if (x < 0 || x > grid.size - 1 || y < 0 || y > grid[0].size - 1) {
                return sum
            }
            if (visited[x][y]) {
                return sum
            }
            if (grid[x][y] == 0) {
                return sum
            }
            visited[x][y] = true
            var max = 0
            for (dir in dirs) {
                max = max(max, calculateWithSumParameter(grid, visited, x + dir[0], y + dir[1], sum + grid[x][y]))
            }
            visited[x][y] = false
            return max
        }
    }
}