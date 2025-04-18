package questions

import kotlin.math.abs
import kotlin.math.max


class Question_3380_Maximum_Area_Rectangle_With_Point_Constraints_I {

    companion object {

        fun runQuestion() {
//            Input: points = [[1,1],[1,3],[3,1],[3,3],[1,2],[3,2]]
//            Output: 2
            val grid = arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 3),
                intArrayOf(3, 1),
                intArrayOf(3, 3),
                intArrayOf(1, 2),
                intArrayOf(3, 2)
            )
            val result = maxRectangleArea(grid)
            println("Question 3380: $result")
        }

        fun maxRectangleArea(points: Array<IntArray>): Int {
            val pointList: MutableList<MutableList<Int>> = mutableListOf()
            for (point in points) {
                pointList.add(point.toMutableList())
            }
            val xlist: MutableList<Int> = mutableListOf()
            val ylist: MutableList<Int> = mutableListOf()
            var ans = -1
            for (i in 0..pointList.size - 2) {
                for (j in i + 1..pointList.size - 1) {
                    // println("pointList[i] = ${pointList[i]}, pointList[j] = ${pointList[j]}")
                    if (pointList[i][0] != pointList[j][0] && pointList[i][1] != pointList[j][1]) {
                        val other1 = mutableListOf(pointList[i][0], pointList[j][1])
                        val other2 = mutableListOf(pointList[j][0], pointList[i][1])
                        // println("other1 = $other1, other2 = $other2")
                        if (pointList.contains(other1) && pointList.contains(other2)) {
                            // println("contains both")
                            xlist.clear()
                            ylist.clear()
                            xlist.add(pointList[i][0])
                            xlist.add(pointList[j][0])
                            ylist.add(pointList[i][1])
                            ylist.add(pointList[j][1])
                            if (check(pointList, xlist, ylist)) {
                                val xDiff = abs(pointList[j][0] - pointList[i][0])
                                val yDiff = abs(pointList[j][1] - pointList[i][1])
                                ans = max(ans, xDiff * yDiff)
                                // println("check is true, ans = $ans")
                            }
                        }
                    }
                }
            }
            return ans
        }

        fun check(pointList: MutableList<MutableList<Int>>, xlist: MutableList<Int>, ylist: MutableList<Int>): Boolean {
            xlist.sort()
            ylist.sort()
            for (point in pointList) {
                if (point[0] >= xlist[0] && point[0] <= xlist[1] && point[1] >= ylist[0] && point[1] <= ylist[1]) {
                    if ((point[0] != xlist[0] && point[0] != xlist[1]) || (point[1] != ylist[0] && point[1] != ylist[1])) {
                        return false
                    }
                }
            }
            return true
        }
    }
}