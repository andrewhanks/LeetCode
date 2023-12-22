package questions

import kotlin.math.max


class Question_2500_Delete_Greatest_Value_in_Each_Row {

    companion object {

        fun runQuestion() {
//            Input: grid = [[1,2,4],[3,3,1]]
//            Output: 8
            val grid = arrayOf(intArrayOf(1, 2, 4), intArrayOf(3, 3, 1))
            val result = deleteGreatestValue(grid)
            println("Question 2500: $result")
        }

        fun deleteGreatestValue(grid: Array<IntArray>): Int {
            var value = 0
            for (count in 0..grid.size - 1) {
                grid[count].sortDescending()
            }
            for (y in 0..grid[0].size - 1) {
                var max = 0
                for (x in 0..grid.size - 1) {
                    max = max(max, grid[x][y])
                }
                value += max
            }
            return value
        }
    }
}