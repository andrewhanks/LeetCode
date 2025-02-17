package questions

import java.util.*
import kotlin.math.min


class Question_3341_Find_Minimum_Time_to_Reach_Last_Room_I {

    companion object {

        fun runQuestion() {
//            Input: moveTime = [[0,4],[4,4]]
//            Output: 6
            val grid = arrayOf(intArrayOf(0, 4), intArrayOf(4, 4))
            val result = minTimeToReach(grid)
            println("Question 3341: $result")
        }

        fun minTimeToReach(moveTime: Array<IntArray>): Int {
            val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
            val result = Array(moveTime.size) { IntArray(moveTime[0].size) { Int.MAX_VALUE } }
            val visited = Array(moveTime.size) { Array(moveTime[0].size) { false } }
            val queue = PriorityQueue<IntArray> { a, b ->
                a[2] - b[2]
            }
            result[0][0] = 0
            queue.add(intArrayOf(0, 0, 0))
            while (!queue.isEmpty()) {
                val node = queue.remove()
                visited[node[0]][node[1]] = true
                for (i in 0..dirs.size - 1) {
                    val x = node[0] + dirs[i][0]
                    val y = node[1] + dirs[i][1]
                    if (x < 0 || y < 0 || x > result.size - 1 || y > result[0].size - 1 || visited[x][y]) {
                        continue
                    }
                    val currentValue = if (result[node[0]][node[1]] + 1 < moveTime[x][y] + 1) {
                        moveTime[x][y] + 1
                    } else {
                        result[node[0]][node[1]] + 1
                    }
                    if (currentValue < result[x][y]) {
                        result[x][y] = min(result[x][y], currentValue)
                        queue.add(intArrayOf(x, y, currentValue))
                    }
                }
            }
            // println("visited = ${visited.contentDeepToString()}")
            // println("result = ${result.contentDeepToString()}")
            return result[result.size - 1][result[0].size - 1]
        }
    }
}