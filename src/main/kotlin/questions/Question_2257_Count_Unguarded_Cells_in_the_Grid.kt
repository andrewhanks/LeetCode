package questions

import java.util.*


class Question_2257_Count_Unguarded_Cells_in_the_Grid {

    companion object {

        fun runQuestion() {
//            Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
//            Output: 7
            val m = 4
            val n = 6
            val guards = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 3))
            val walls = arrayOf(intArrayOf(0, 1), intArrayOf(2, 2), intArrayOf(1, 4))
            val result = countUnguarded(m, n, guards, walls)
            println("Question 2257: $result")
        }

        fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
            val result = Array(m) { CharArray(n) { 'U' } }
            for (guard in guards) {
                result[guard[0]][guard[1]] = 'G'
            }
            for (wall in walls) {
                result[wall[0]][wall[1]] = 'W'
            }
            for (guard in guards) {
                bfs(result, guard[0], guard[1])
            }
            var ans = 0
            for (i in 0..result.size - 1) {
                for (j in 0..result[0].size - 1) {
                    if (result[i][j] == 'U') {
                        ans++
                    }
                }
            }
            return ans
        }

        fun bfs(result: Array<CharArray>, x: Int, y: Int) {
            val queue: Queue<IntArray> = LinkedList()
            queue.add(intArrayOf(x, y, 0))
            queue.add(intArrayOf(x, y, 1))
            queue.add(intArrayOf(x, y, 2))
            queue.add(intArrayOf(x, y, 3))
            while (!queue.isEmpty()) {
                val node = queue.remove()
                var newx = node[0]
                var newy = node[1]
                var dir = node[2]
                when (dir) {
                    0 -> {
                        newx += 1
                    }

                    1 -> {
                        newy += 1
                    }

                    2 -> {
                        newx -= 1
                    }

                    3 -> {
                        newy -= 1
                    }
                }
                if (newx < 0 || newx > result.size - 1 || newy < 0 || newy > result[0].size - 1 || result[newx][newy] == 'G' || result[newx][newy] == 'W') {
                    continue
                }
                result[newx][newy] = 'S'
                queue.add(intArrayOf(newx, newy, dir))
            }
        }
    }
}