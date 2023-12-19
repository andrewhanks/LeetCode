package questions


class Question_1351_Count_Negative_Numbers_in_a_Sorted_Matrix {

    companion object {

        fun runQuestion() {
//            Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//            Output: 8
            val grid = arrayOf(
                intArrayOf(4, 3, 2, -1),
                intArrayOf(3, 2, 1, -1),
                intArrayOf(1, 1, -1, -2),
                intArrayOf(-1, -1, -2, -3)
            )
            val result = countNegatives(grid)
            println("Question 1351: $result")
        }

        fun countNegatives(grid: Array<IntArray>): Int {
            var number = 0
            for (x in 0..grid.size - 1) {
                for (y in 0..grid[x].size - 1) {
                    if (grid[x][y] < 0) {
                        number += grid[x].size - 1 - y + 1
                        break
                    }
                }
            }
            return number
        }
    }
}