package questions

import kotlin.math.max


class Question_2555_Maximize_Win_From_Two_Segments {

    companion object {

        fun runQuestion() {
//            Input: prizePositions = [1,1,2,2,3,3,5], k = 2
//            Output: 7
            val prizePositions = intArrayOf(1, 1, 2, 2, 3, 3, 5)
            val k = 2
            val result = maximizeWin(prizePositions, k)
            println("Question 2555: $result")
        }

        fun maximizeWin(prizePositions: IntArray, k: Int): Int {
            // result to store the maximum number of prizes that can be won at each position
            val result: Array<IntArray> = Array(3) { IntArray(prizePositions.size + 1) { 0 } }
            for (x in 1..2) {
                var start = 1
                for (y in 1..prizePositions.size) {
                    // if segment becomes greater than k, increase start to make it valid again.
                    while (prizePositions[y - 1] - prizePositions[start - 1] > k) {
                        start++
                    }
                    // update the result by taking the maximum between the maximum number of prizes at the previous position
                    // and the maximum number of prizes in the current valid segment plus the length of the valid segment.
                    result[x][y] = max(result[x][y - 1], result[x - 1][start - 1] + y - start + 1)
                }
            }
            return result[2][prizePositions.size]
        }
    }
}