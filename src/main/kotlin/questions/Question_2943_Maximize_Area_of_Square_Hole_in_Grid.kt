package questions

import kotlin.math.max
import kotlin.math.min

class Question_2943_Maximize_Area_of_Square_Hole_in_Grid {

    companion object {

        fun runQuestion() {
//            Input: n = 2, m = 3, hBars = [2,3], vBars = [2,4]
//            Output: 4
            val n = 2
            val m = 3
            val hBars = intArrayOf(2, 3)
            val vBars = intArrayOf(2, 4)
            val result = maximizeSquareHoleArea(n, m, hBars, vBars)
            println("Question 2943: $result")
        }

        fun maximizeSquareHoleArea(n: Int, m: Int, hBars: IntArray, vBars: IntArray): Int {
            var vMax = 2
            var vCurrent = 2
            vBars.sort()
            for (i in 1..vBars.size - 1) {
                if (vBars[i] - vBars[i - 1] == 1) {
                    vCurrent++
                } else {
                    vMax = max(vMax, vCurrent)
                    vCurrent = 2
                }
            }
            vMax = max(vMax, vCurrent)
            var hMax = 2
            var hCurrent = 2
            hBars.sort()
            for (i in 1..hBars.size - 1) {
                if (hBars[i] - hBars[i - 1] == 1) {
                    hCurrent++
                } else {
                    hMax = max(hMax, hCurrent)
                    hCurrent = 2
                }
            }
            hMax = max(hMax, hCurrent)
            val ret = min(vMax, hMax)
            return ret * ret
        }
    }
}