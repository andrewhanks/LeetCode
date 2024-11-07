package questions

import kotlin.math.max


class Question_3071_Minimum_Operations_to_Write_the_Letter_Y_on_a_Grid {

    companion object {

        fun runQuestion() {
//            Input: grid = [[0,1,0,1,0],[2,1,0,1,2],[2,2,2,0,1],[2,2,2,2,2],[2,1,2,2,2]]
//            Output: 12
            val grid =
                arrayOf(
                    intArrayOf(0, 1, 0, 1, 0),
                    intArrayOf(2, 1, 0, 1, 2),
                    intArrayOf(2, 2, 2, 0, 1),
                    intArrayOf(2, 2, 2, 2, 2),
                    intArrayOf(2, 1, 2, 2, 2)
                )
            val result = minimumOperationsToWriteY(grid)
            println("Question 3071: $result")
        }

        fun minimumOperationsToWriteY(grid: Array<IntArray>): Int {
            val size = grid.size
            val numberOfY = IntArray(3) { 0 }
            val numberOfNotY = IntArray(3) { 0 }
            for (i in 0..size - 1) {
                for (j in 0..size - 1) {
                    if (i <= size / 2) {
                        if (i == j || i + j == size - 1) {
                            numberOfY[grid[i][j]]++
                        } else {
                            numberOfNotY[grid[i][j]]++
                        }
                    } else {
                        if (j == size / 2) {
                            numberOfY[grid[i][j]]++
                        } else {
                            numberOfNotY[grid[i][j]]++
                        }
                    }
                }
            }
            // println("numberOfY = ${numberOfY.contentToString()}, numberOfNotY = ${numberOfNotY.contentToString()}")
            var max = 0
            for (i in 0..numberOfY.size - 1) {
                for (j in 0..numberOfNotY.size - 1) {
                    if (i == j) {
                        continue
                    }
                    max = max(max, numberOfY[i] + numberOfNotY[j])
                }
            }
            return size * size - max
        }
    }
}