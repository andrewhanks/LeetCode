package questions

import kotlin.math.min

class Question_1824_Minimum_Sideway_Jumps {

    companion object {

        fun runQuestion() {
//            Input: obstacles = [0,1,2,3,0]
//            Output: 2
            val obstacles = intArrayOf(0, 1, 2, 3, 0)
            val result = minSideJumps(obstacles)
            println("Question 1824: $result")
        }

        fun minSideJumps(obstacles: IntArray): Int {
            val dp = Array(3) { IntArray(obstacles.size) { 0 } }
            for (i in 0..obstacles.size - 1) {
                if (obstacles[i] == 0) {
                    continue
                }
                dp[obstacles[i] - 1][i] = -1
            }
            if (dp[0][0] != -1) {
                dp[0][0] = 1
            }
            if (dp[2][0] != -1) {
                dp[2][0] = 1
            }
            // println("dp = ${dp.contentDeepToString()}")
            val size = dp[0].size
            for (i in 1..size - 1) {
                var notHandled = -1
                for (j in 0..2) {
                    if (dp[j][i] == -1) {
                        continue
                    }
                    if (dp[j][i - 1] != -1) {
                        var min = Int.MAX_VALUE
                        for (k in 0..2) {
                            if (j == k) {
                                min = min(min, dp[j][i - 1])
                            } else {
                                min = min(min, dp[j][i - 1] + 1)
                            }
                        }
                        dp[j][i] = min
                    } else {
                        notHandled = j
                    }
                }
                // println("notHandled = $notHandled")
                if (notHandled != -1) {
                    var notHandledMin = Int.MAX_VALUE
                    for (j in 0..2) {
                        if (dp[j][i] == -1) {
                            continue
                        }
                        if (j != notHandled) {
                            notHandledMin = min(notHandledMin, dp[j][i])
                        }
                    }
                    dp[notHandled][i] = notHandledMin + 1
                }
                // println("after $i dp = ${dp.contentDeepToString()}")
            }
            return min(dp[0][size - 1], min(dp[1][size - 1], dp[2][size - 1]))
        }
    }
}