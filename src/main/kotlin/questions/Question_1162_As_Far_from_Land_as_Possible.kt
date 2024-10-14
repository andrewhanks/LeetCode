package questions

import java.util.*
import kotlin.math.max


class Question_1162_As_Far_from_Land_as_Possible {

    companion object {

        fun runQuestion() {
//            Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
//            Output: 2
            val grid = arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, 0, 0), intArrayOf(1, 0, 1))
            val result = maxDistance(grid)
            println("Question 1162: $result")
        }

        fun maxDistance(grid: Array<IntArray>): Int {
            val dirs = arrayOf(intArrayOf(0, -1), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0))
            val queue: Queue<IntArray> = LinkedList()
            for (i in 0..grid.size - 1) {
                for (j in 0..grid[0].size - 1) {
                    if (grid[i][j] == 1) {
                        queue.add(intArrayOf(i, j))
                    }
                }
            }
            if (queue.isEmpty() || queue.size == grid.size * grid[0].size) {
                return -1
            }
            var ans = -1
            while (!queue.isEmpty()) {
                val size = queue.size
                ans++
                for (k in 0..size - 1) {
                    val node = queue.remove()
                    for (dir in dirs) {
                        val nextx = node[0] + dir[0]
                        val nexty = node[1] + dir[1]
                        if (nextx < 0 || nextx > grid.size - 1 || nexty < 0 || nexty > grid[0].size - 1 ||
                            grid[nextx][nexty] != 0
                        ) {
                            continue
                        }
                        queue.add(intArrayOf(nextx, nexty))
                        grid[nextx][nexty] = 2
                    }
                }
            }
            return ans
        }
    }
}