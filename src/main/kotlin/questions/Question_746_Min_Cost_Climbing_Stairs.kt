package questions

import kotlin.math.min

class Question_746_Min_Cost_Climbing_Stairs {

    companion object {

        fun runQuestion() {
//            Input: cost = [1,100,1,1,1,100,1,1,100,1]
//            Output: 6
            val cost = intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)
            val result = minCostClimbingStairs(cost)
            println("Question 746: $result")
        }

        fun minCostClimbingStairs(cost: IntArray): Int {
            val result = IntArray(cost.size + 1) { -1 }
            return recursive(cost, cost.size, result)
        }

        fun recursive(cost: IntArray, n: Int, result: IntArray): Int {
            if (result[n] != -1) {
                return result[n]
            }
            if (n <= 1) {
                result[n] = 0
                return result[n]
            }
            result[n] = min(
                recursive(cost, n - 2, result) + cost[n - 2],
                recursive(cost, n - 1, result) + cost[n - 1]
            )
            return result[n]
        }
    }
}