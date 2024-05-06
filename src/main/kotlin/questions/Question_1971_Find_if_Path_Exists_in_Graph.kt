package questions

import java.util.*


class Question_1971_Find_if_Path_Exists_in_Graph {

    companion object {

        fun runQuestion() {
//            Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
//            Output: false
            val n = 6
            val edges =
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(3, 5), intArrayOf(5, 4), intArrayOf(4, 3))
            val source = 0
            val destination = 5
            val result = validPath(n, edges, source, destination)
            println("Question 1971: $result")
        }

        fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
            val temp: MutableSet<Int> = mutableSetOf()
            val graph: List<MutableList<Int>> = List(n) { mutableListOf() }
            for (count in 0..edges.size - 1) {
                val first = edges[count][0]
                val second = edges[count][1]
                graph[first].add(second)
                graph[second].add(first)
            }
            // for(count in 0..graph.size-1) {
            //     println(graph[count])
            // }
            return dfs(graph, source, destination, temp)
        }

        fun dfs(graph: List<MutableList<Int>>, index: Int, destination: Int, temp: MutableSet<Int>): Boolean {
            if (destination == index) {
                return true
            }
            for (count in 0..graph[index].size - 1) {
                val tempDest = graph[index][count]
                if (temp.contains(tempDest)) {
                    continue
                }
                temp.add(tempDest)
                // println("temp = $temp")
                val result = dfs(graph, tempDest, destination, temp)
                if (result) {
                    return true
                }
            }
            return false
        }

        fun validPathBfs(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
            val temp: MutableSet<Int> = mutableSetOf()
            val graph: List<MutableList<Int>> = List(n) { mutableListOf() }
            for (count in 0..edges.size - 1) {
                val first = edges[count][0]
                val second = edges[count][1]
                graph[first].add(second)
                graph[second].add(first)
            }
            val queue: Queue<Int> = LinkedList()
            queue.add(source)
            temp.add(source)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                if (destination == node) {
                    return true
                }
                for (count in 0..graph[node].size - 1) {
                    val tempDest = graph[node][count]
                    if (temp.contains(tempDest)) {
                        continue
                    }
                    queue.add(tempDest)
                    temp.add(tempDest)
                }
            }
            return false
        }
    }
}