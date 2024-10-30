package questions

import kotlin.math.max
import kotlin.math.min


class Question_2497_Maximum_Star_Sum_of_a_Graph {

    companion object {

        fun runQuestion() {
//            Input: vals = [1,2,3,4,10,-10,-20], edges = [[0,1],[1,2],[1,3],[3,4],[3,5],[3,6]], k = 2
//            Output: 16
            val vals = intArrayOf(1, 2, 3, 4, 10, -10, -20)
            val edges = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(3, 4),
                intArrayOf(3, 5),
                intArrayOf(3, 6)
            )
            val k = 2
            val result = maxStarSum(vals, edges, k)
            println("Question 2497: $result")
        }

        fun maxStarSum(vals: IntArray, edges: Array<IntArray>, k: Int): Int {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            for (count in 0..vals.size - 1) {
                map[count] = mutableListOf()
            }
            for (count in 0..edges.size - 1) {
                val node1 = edges[count][0]
                val node2 = edges[count][1]
                map[node1]!!.add(node2)
                map[node2]!!.add(node1)
            }
            var ans = Int.MIN_VALUE
            for ((key, value) in map) {
                val sortedList = value.sortedWith(Comparator { a, b ->
                    vals[b] - vals[a]
                })
                var sum = vals[key]
                val until = min(k - 1, sortedList.size - 1)
                for (count in 0..until) {
                    if (vals[sortedList[count]] > 0) {
                        sum += vals[sortedList[count]]
                    }
                }
                ans = max(ans, sum)
            }
            return ans
        }
    }
}