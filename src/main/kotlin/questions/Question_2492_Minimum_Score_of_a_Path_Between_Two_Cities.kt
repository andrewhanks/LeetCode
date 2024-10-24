package questions

import kotlin.math.max
import kotlin.math.min


class Question_2492_Minimum_Score_of_a_Path_Between_Two_Cities {

    companion object {

        fun runQuestion() {
//            Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
//            Output: 5
            val n = 4
            val roads = arrayOf(intArrayOf(1, 2, 9), intArrayOf(2, 3, 6), intArrayOf(2, 4, 5), intArrayOf(1, 4, 7))
            val result = minScore(n, roads)
            println("Question 2492: $result")
        }

        fun minScore(n: Int, roads: Array<IntArray>): Int {
            val result = IntArray(n + 1) { 0 }
            for (count in 0..result.size - 1) {
                result[count] = count
            }
            for (count in 0..roads.size - 1) {
                union(result, roads[count][0], roads[count][1])
            }
            var ans = Int.MAX_VALUE
            for (count in 0..roads.size - 1) {
                if (find(result, roads[count][0]) == result[1]) {
                    ans = min(ans, roads[count][2])
                }
            }
            // println("result = ${result.contentToString()}")
            return ans
        }

        fun union(result: IntArray, x: Int, y: Int) {
            val groupX = find(result, x)
            val groupY = find(result, y)
            if (groupX == groupY) {
                return
            }
            val min = min(groupX, groupY)
            val max = max(groupX, groupY)
            result[max] = min
        }

        fun find(result: IntArray, x: Int): Int {
            if (x == result[x]) {
                return x
            }
            result[x] = find(result, result[x])
            return result[x]
        }
    }
}