package questions

class Question_2087_Minimum_Cost_Homecoming_of_a_Robot_in_a_Grid {

    companion object {

        fun runQuestion() {
//            Input: startPos = [1, 0], homePos = [2, 3], rowCosts = [5, 4, 3], colCosts = [8, 2, 6, 7]
//            Output: 18
            val startPos = intArrayOf(1, 0)
            val homePos = intArrayOf(2, 3)
            val rowCosts = intArrayOf(5, 4, 3)
            val colCosts = intArrayOf(8, 2, 6, 7)
            val result = minCost(startPos, homePos, rowCosts, colCosts)
            println("Question 2087: $result")
        }

        fun minCost(startPos: IntArray, homePos: IntArray, rowCosts: IntArray, colCosts: IntArray): Int {
            var ans = 0
            if (startPos[0] <= homePos[0]) {
                for (i in startPos[0] + 1..homePos[0]) {
                    ans += rowCosts[i]
                }
            } else {
                for (i in startPos[0] - 1 downTo homePos[0]) {
                    ans += rowCosts[i]
                }
            }
            if (startPos[1] <= homePos[1]) {
                for (j in startPos[1] + 1..homePos[1]) {
                    ans += colCosts[j]
                }
            } else {
                for (j in startPos[1] - 1 downTo homePos[1]) {
                    ans += colCosts[j]
                }
            }
            return ans
        }
    }
}