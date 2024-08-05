package questions

import java.util.*

class Question_3243_Shortest_Distance_After_Road_Addition_Queries_I {

    companion object {

        fun runQuestion() {
//            Input: n = 5, queries = [[2,4],[0,2],[0,4]]
//            Output: [3,2,1]
            val queries = arrayOf(intArrayOf(2, 4), intArrayOf(0, 2), intArrayOf(0, 4))
            val n = 5
            val result = shortestDistanceAfterQueries(n, queries)
            println("Question 3243: ${result.contentToString()}")
        }

        fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
            val paths: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            for (count in 0..n - 2) {
                val target = mutableListOf(count + 1)
                paths[count] = target
            }
            val result: MutableList<Int> = mutableListOf()
            for (i in 0..queries.size - 1) {
                paths[queries[i][0]]!!.add(queries[i][1])
                result.add(shortestPath(paths, n))
            }
            return result.toIntArray()
        }

        fun shortestPath(paths: MutableMap<Int, MutableList<Int>>, n: Int): Int {
            val visited: MutableList<Int> = mutableListOf()
            val queue: Queue<Int> = LinkedList()
            queue.add(0)
            visited.add(0)
            var ret = 0
            while (!queue.isEmpty()) {
                val size = queue.size
                for (count in 0..size - 1) {
                    val node = queue.remove()
                    if (node == n - 1) {
                        return ret
                    }
                    for (j in 0..paths[node]!!.size - 1) {
                        if (visited.contains(paths[node]!![j])) {
                            continue
                        }
                        queue.add(paths[node]!![j])
                        visited.add(paths[node]!![j])
                    }
                }
                ret++
            }
            return n
        }
    }
}