package questions

import java.util.*
import kotlin.math.max


class Question_994_Rotting_Oranges {

    companion object {

        fun runQuestion() {
//            Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//            Output: 4
            val grid =
                arrayOf(
                    intArrayOf(2, 1, 1),
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 1, 1)
                )
            val result = orangesRotting(grid)
            println("Question 994: $result")
        }

        fun orangesRotting(grid: Array<IntArray>): Int {
            // var status:Array<Array<Boolean>> = Array(grid.size){Array(grid[0].size){false}}
            val queue: Queue<IntArray> = LinkedList()
            var result = 0
            for (i in 0..grid.size - 1) {
                for (j in 0..grid[0].size - 1) {
                    if (grid[i][j] == 2) {
                        queue.add(intArrayOf(i, j))
                    }
                }
            }
            while (!queue.isEmpty()) {
//                println(queue.size)
                var oneMore = false
                for (count in 0..queue.size - 1) {
                    val pos = queue.remove()
                    // status = Array(grid.size){Array(grid[0].size){false}}
                    // status[pos[0]][pos[1]] = true
                    if (pos[0] - 1 >= 0 && grid[pos[0] - 1][pos[1]] == 1) {
                        oneMore = true
                        queue.add(intArrayOf(pos[0] - 1, pos[1]))
                        grid[pos[0] - 1][pos[1]] = 2
                    }
                    if (pos[0] + 1 <= grid.size - 1 && grid[pos[0] + 1][pos[1]] == 1) {
                        oneMore = true
                        queue.add(intArrayOf(pos[0] + 1, pos[1]))
                        grid[pos[0] + 1][pos[1]] = 2
                    }
                    if (pos[1] - 1 >= 0 && grid[pos[0]][pos[1] - 1] == 1) {
                        oneMore = true
                        queue.add(intArrayOf(pos[0], pos[1] - 1))
                        grid[pos[0]][pos[1] - 1] = 2
                    }
                    if (pos[1] + 1 <= grid[0].size - 1 && grid[pos[0]][pos[1] + 1] == 1) {
                        oneMore = true
                        queue.add(intArrayOf(pos[0], pos[1] + 1))
                        grid[pos[0]][pos[1] + 1] = 2
                    }
                }
                // println(grid.contentDeepToString())
                if (oneMore) {
                    result++
                }
            }
            for (i in 0..grid.size - 1) {
                for (j in 0..grid[0].size - 1) {
                    if (grid[i][j] == 1) {
                        return -1
                    }
                }
            }
            return result
        }

        fun orangesRottingDfs(grid: Array<IntArray>): Int {
            for (i in 0..grid.size - 1) {
                for (j in 0..grid[0].size - 1) {
                    if (grid[i][j] == 2) {
                        dfs(grid, i, j, 2)
                    }
                }
            }
            // println(grid.contentDeepToString())
            var max = 2
            for (i in 0..grid.size - 1) {
                for (j in 0..grid[0].size - 1) {
                    if (grid[i][j] == 1) {
                        return -1
                    } else {
                        max = max(max, grid[i][j])
                    }
                }
            }
            return max - 2
        }

        fun dfs(grid: Array<IntArray>, i: Int, j: Int, count: Int) {
            if (i < 0 || i > grid.size - 1 || j < 0 || j > grid[0].size - 1) {
                return
            }
            if (grid[i][j] > 1 && grid[i][j] < count) {
                return
            }
            if (grid[i][j] == 0) {
                return
            }
            grid[i][j] = count
            dfs(grid, i - 1, j, count + 1)
            dfs(grid, i + 1, j, count + 1)
            dfs(grid, i, j - 1, count + 1)
            dfs(grid, i, j + 1, count + 1)
        }
    }
}