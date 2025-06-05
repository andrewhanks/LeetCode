package questions


class Question_1706_Where_Will_the_Ball_Fall {

    companion object {

        fun runQuestion() {
//            Input: grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
//            Output: [1,-1,-1,-1,-1]
            val grid = arrayOf(
                intArrayOf(1, 1, 1, -1, -1),
                intArrayOf(1, 1, 1, -1, -1),
                intArrayOf(-1, -1, -1, 1, 1),
                intArrayOf(1, 1, 1, 1, -1),
                intArrayOf(-1, -1, -1, -1, -1)
            )
            val result = findBall(grid)
            println("Question 1706: ${result.contentToString()}")
        }

        fun findBall(grid: Array<IntArray>): IntArray {
            val ans = IntArray(grid[0].size) { -1 }
            for (i in 0..ans.size - 1) {
                var pos = i
                var stuck = false
                for (j in 0..grid.size - 1) {
                    if (grid[j][pos] == 1 && pos < grid[j].size - 1 && grid[j][pos + 1] == 1) {
                        pos++
                    } else if (grid[j][pos] == -1 && pos > 0 && grid[j][pos - 1] == -1) {
                        pos--
                    } else {
                        stuck = true
                    }
                }
                if (!stuck) {
                    ans[i] = pos
                }
            }
            // println("ans = ${ans.contentToString()}")
            return ans
        }
    }
}