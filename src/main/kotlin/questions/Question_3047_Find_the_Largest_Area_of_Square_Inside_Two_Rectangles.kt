package questions

import kotlin.math.max
import kotlin.math.min


class Question_3047_Find_the_Largest_Area_of_Square_Inside_Two_Rectangles {

    companion object {

        fun runQuestion() {
//            Input: bottomLeft = [[1,1],[2,2],[3,1]], topRight = [[3,3],[4,4],[6,6]]
//            Output: 1
            val bottomLeft = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 1))
            val topRight = arrayOf(intArrayOf(3, 3), intArrayOf(4, 4), intArrayOf(6, 6))
            val result = largestSquareArea(bottomLeft, topRight)
            println("Question 3047: $result")
        }

        fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
            var min = Long.MAX_VALUE
            var ans = 0L
            for (i in 0..bottomLeft.size - 1) {
                for (j in i + 1..topRight.size - 1) {
                    var xRange = intArrayOf(0, 0)
                    var yRange = intArrayOf(0, 0)
                    xRange[0] = max(bottomLeft[i][0], bottomLeft[j][0])
                    xRange[1] = min(topRight[i][0], topRight[j][0])
                    yRange[0] = max(bottomLeft[i][1], bottomLeft[j][1])
                    yRange[1] = min(topRight[i][1], topRight[j][1])

                    min = min(xRange[1] - xRange[0], yRange[1] - yRange[0]).toLong()
                    if (min > 0) {
                        ans = max(ans, min * min)
                    }
                }
            }
            return ans
        }
    }
}