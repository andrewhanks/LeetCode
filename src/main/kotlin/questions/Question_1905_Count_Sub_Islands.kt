package questions


class Question_1905_Count_Sub_Islands {

    companion object {

        fun runQuestion() {
//            Input: grid1 = [[0,1,1,1,0],[1,0,1,0,1],[0,1,1,1,1],[0,0,1,0,0],[1,0,0,1,1]]
//                   grid2 = [[0,1,1,0,1],[1,0,1,1,0],[0,1,1,1,1],[0,0,1,0,0],[0,0,0,1,1]]
//            Output: 2
            val grid1 = arrayOf(
                intArrayOf(0, 1, 1, 1, 0),
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(0, 1, 1, 1, 1),
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(1, 0, 0, 1, 1)
            )
            val grid2 = arrayOf(
                intArrayOf(0, 1, 1, 0, 1),
                intArrayOf(1, 0, 1, 1, 0),
                intArrayOf(0, 1, 1, 1, 1),
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(0, 0, 0, 1, 1)
            )
            val result = countSubIslands(grid1, grid2)
            println("Question 1905: $result")
        }

        fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
            var ans = 0
            for (i in 0..grid2.size - 1) {
                for (j in 0..grid2[0].size - 1) {
                    if (grid2[i][j] == 1) {
                        if (check(grid1, grid2, i, j)) {
                            ans++
                        }
                    }
                }
            }
            return ans
        }

        fun check(grid1: Array<IntArray>, grid2: Array<IntArray>, x: Int, y: Int): Boolean {
            if (x < 0 || x > grid2.size - 1 || y < 0 || y > grid2[0].size - 1 || grid2[x][y] == 0) {
                return true
            }
            if (grid2[x][y] == 1 && grid1[x][y] == 0) {
                return false
            }
            grid2[x][y] = 0
            val right = check(grid1, grid2, x, y + 1)
            val down = check(grid1, grid2, x + 1, y)
            val left = check(grid1, grid2, x, y - 1)
            val up = check(grid1, grid2, x - 1, y)
            return up && down && left && right
        }
    }
}