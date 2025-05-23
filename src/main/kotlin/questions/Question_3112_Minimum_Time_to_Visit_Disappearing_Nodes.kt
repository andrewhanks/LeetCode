package questions

import java.util.*


class Question_3112_Minimum_Time_to_Visit_Disappearing_Nodes {

    companion object {

        fun runQuestion() {
//            Input: n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]
//            Output: [0,-1,4]
            val n = 3
            val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 1), intArrayOf(0, 2, 4))
            val disappear = intArrayOf(1, 1, 5)
            val result = minimumTime(n, edges, disappear)
            println("Question 3112: ${result.contentToString()}")
        }

        fun minimumTime(n: Int, edges: Array<IntArray>, disappear: IntArray): IntArray {
            val map: MutableMap<Int, MutableList<MutableList<Int>>> = mutableMapOf()
            for (i in 0..edges.size - 1) {
                var list = map.getOrDefault(edges[i][0], mutableListOf())
                list.add(mutableListOf(edges[i][1], edges[i][2]))
                map[edges[i][0]] = list
                list = map.getOrDefault(edges[i][1], mutableListOf())
                list.add(mutableListOf(edges[i][0], edges[i][2]))
                map[edges[i][1]] = list
            }
            // println("map = $map")
            var ans = MutableList<Int>(n) { Int.MAX_VALUE }
            val queue = PriorityQueue<MutableList<Int>> { a, b ->
                a[1] - b[1]
            }
            queue.add(mutableListOf(0, 0))
            ans[0] = 0
            while (!queue.isEmpty()) {
                val node = queue.remove()
                val currentNode = node[0]
                val currDis = node[1]
                if (currDis > ans[currentNode]) {
                    continue
                }
                if (map[currentNode] != null) {
                    val paths = map[currentNode]!!
                    for (i in 0..paths.size - 1) {
                        val nextNode = paths[i][0]
                        val nextDis = paths[i][1]
                        if (disappear[nextNode] > ans[currentNode] + nextDis && ans[nextNode] > ans[currentNode] + nextDis) {
                            ans[nextNode] = ans[currentNode] + nextDis
                            queue.add(mutableListOf(nextNode, ans[currentNode] + nextDis))
                        }
                    }
                }
                // println("ans = $ans, queue.peek() = ${queue.peek()}")
            }
            for (i in 0..ans.size - 1) {
                if (ans[i] >= disappear[i]) {
                    ans[i] = -1
                }
            }
            return ans.toIntArray()
        }
    }
}