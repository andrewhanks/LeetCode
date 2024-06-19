package questions

import java.util.*


class Question_310_Minimum_Height_Trees {

    companion object {

        fun runQuestion() {
//            Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//            Output: [3,4]
            val edges =
                arrayOf(intArrayOf(3, 0), intArrayOf(3, 1), intArrayOf(3, 2), intArrayOf(3, 4), intArrayOf(5, 4))
            val n = 6
            val result = findMinHeightTrees(n, edges)
            println("Question 54: $result")
        }

        fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
            if (n == 1) {
                return listOf(0)
            }
            if (n == 2) {
                return listOf(0, 1)
            }
            val connection: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            val degree = IntArray(n) { 0 }
            for (item in edges) {
                if (!connection.contains(item[0])) {
                    connection.put(item[0], mutableListOf(item[1]))
                } else {
                    connection[item[0]]!!.add(item[1])
                }
                if (!connection.contains(item[1])) {
                    connection.put(item[1], mutableListOf(item[0]))
                } else {
                    connection[item[1]]!!.add(item[0])
                }
                degree[item[0]]++
                degree[item[1]]++
            }
//            println("degree = ${degree.contentToString()}")
            val queue: Queue<Int> = LinkedList()
            for (count in 0..degree.size - 1) {
                if (degree[count] == 1) {
                    queue.add(count)
                }
            }
            var number = n
            while (number > 2) {
                val size = queue.size
                number -= size
//                println("queue = $queue")
                for (count in 0..size - 1) {
                    val node = queue.remove()
                    for (item in connection[node]!!) {
//                        println("node = $node, degree[$count] = ${degree[count]}")
                        degree[item]--
                        if (degree[item] == 1) {
                            queue.add(item)
                        }
                    }
                }
            }
//            println("queue = $queue")
            val result: MutableList<Int> = mutableListOf()
            result.addAll(queue)
            return result
        }
    }
}