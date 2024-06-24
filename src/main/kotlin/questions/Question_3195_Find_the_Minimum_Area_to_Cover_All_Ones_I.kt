package questions

import kotlin.math.max
import kotlin.math.min


class Question_3195_Find_the_Minimum_Area_to_Cover_All_Ones_I {

    companion object {

        fun runQuestion() {
//            Input: grid = [[0,1,0],[1,0,1]]
//            Output: 6
            val grid = arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 0, 1))
            val result = minimumArea(grid)
            println("Question 3195: $result")
        }

        fun minimumArea(grid: Array<IntArray>): Int {
            var left = grid[0].size - 1
            var up = grid.size - 1
            var right = 0
            var down = 0
            for (i in 0..grid.size - 1) {
                for (j in 0..grid[i].size - 1) {
                    if (grid[i][j] == 1) {
                        // println("left = $left, up = $up, right = $right, down = $down, i = $i, j = $j")
                        left = min(left, j)
                        up = min(up, i)
                        right = max(right, j)
                        down = max(down, i)
                    }
                }
            }
            // println("left = $left, up = $up, right = $right, down = $down")
            return (right - left + 1) * (down - up + 1)
        }
    }
}