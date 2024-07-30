package questions

import kotlin.math.max


class Question_1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank {

    companion object {

        fun runQuestion() {
//            Input: n = 42, left = [18,4,30,36,42,0,5,23,2,9], right = [22,40,1,28]
//            Output: 42
            val n = 42
            val left = intArrayOf(18, 4, 30, 36, 42, 0, 5, 23, 2, 9)
            val right = intArrayOf(22, 40, 1, 28)
            val result = getLastMoment(n, left, right)
            println("Question 1503: $result")
        }

        fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
            if (left.isEmpty()) {
                return n - right.min()
            } else if (right.isEmpty()) {
                return left.max()
            } else {
                val leftBiggestPos = left.max()
                val rightSmallestPos = right.min()
                if (leftBiggestPos < rightSmallestPos) {
                    return max(leftBiggestPos - 0, n - rightSmallestPos)
                } else {
                    val meetTime = (leftBiggestPos - rightSmallestPos) / 2
                    val meetPos = (leftBiggestPos + rightSmallestPos) / 2
                    val longestTimeAfterMeet = if ((leftBiggestPos + rightSmallestPos) % 2 == 1) {
                        max(meetPos - 0, n - (meetPos + 1)) + 1
                    } else {
                        max(meetPos - 0, n - meetPos)
                    }
                    // println("leftBiggestPos = $leftBiggestPos, rightSmallestPos = $rightSmallestPos, meetTime = $meetTime, meetPos = $meetPos, longestTimeAfterMeet = $longestTimeAfterMeet")
                    return longestTimeAfterMeet + meetTime
                }
            }
        }
    }
}