package questions

import kotlin.math.sqrt


class Question_2249_Count_Lattice_Points_Inside_a_Circle {

    companion object {

        fun runQuestion() {
//            Input: circles = [[2,2,2],[3,4,1]]
//            Output: 16
            val grid = arrayOf(intArrayOf(2, 2, 2), intArrayOf(3, 4, 1))
            val result = countLatticePoints(grid)
            println("Question 2249: $result")
        }

        fun countLatticePoints(circles: Array<IntArray>): Int {
            val result: MutableSet<MutableList<Int>> = mutableSetOf()
            for (count in 0..circles.size - 1) {
                for (x in -circles[count][2]..circles[count][2]) {
                    for (y in -circles[count][2]..circles[count][2]) {
                        if (sqrt(x.toDouble() * x.toDouble() + y.toDouble() * y.toDouble()) <= circles[count][2]) {
                            val temp = mutableListOf(circles[count][0] + x, circles[count][1] + y)
                            result.add(temp)
                        }
                    }
                }
            }
            return result.size
        }
    }
}