package questions

import java.util.*


class Question_1443_Minimum_Time_to_Collect_All_Apples_in_a_Tree {

    companion object {

        fun runQuestion() {
//            Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
//            Output: 8
            val n = 7
            val edges = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(1, 4),
                intArrayOf(1, 5),
                intArrayOf(2, 3),
                intArrayOf(2, 6)
            )
            val hasApple = listOf(false, false, true, false, true, true, false)
            val result = minTime(n, edges, hasApple)
            println("Question 1443: $result")
        }

        fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            for (count in 0..edges.size - 1) {
                val node1 = edges[count][0]
                val node2 = edges[count][1]
                val list1 = map.getOrDefault(node1, mutableListOf())
                list1.add(node2)
                map[node1] = list1
                val list2 = map.getOrDefault(node2, mutableListOf())
                list2.add(node1)
                map[node2] = list2
            }
            val queue: Queue<Int> = LinkedList()
            for ((key, value) in map) {
                if (value.size == 1 && !hasApple[key] && key != 0) {
                    queue.add(key)
                }
            }
            val set: MutableSet<Int> = mutableSetOf()
            while (!queue.isEmpty()) {
                val node = queue.remove()
                set.add(node)
                val nextNode = map[node]!![0]!!
                map[nextNode]!!.remove(node)
                if (map[nextNode]!!.size == 1 && !hasApple[nextNode] && nextNode != 0) {
                    queue.add(nextNode)
                }
            }
            val ans = 2 * edges.size - 2 * set.size
            return ans
        }

        fun minTimeWithRecursive(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            for (count in 0..edges.size - 1) {
                val node1 = edges[count][0]
                val node2 = edges[count][1]
                val list1 = map.getOrDefault(node1, mutableListOf())
                list1.add(node2)
                map[node1] = list1
                val list2 = map.getOrDefault(node2, mutableListOf())
                list2.add(node1)
                map[node2] = list2
            }
            val set: MutableSet<Int> = mutableSetOf()
            set.add(0)
            return dfs(0, map, hasApple, set)
        }

        fun dfs(
            current: Int,
            map: MutableMap<Int, MutableList<Int>>,
            hasApple: List<Boolean>,
            set: MutableSet<Int>
        ): Int {
            if (map[current] == null) {
                return 0
            }
            var totalTime = 0
            for (item in map[current]!!) {
                if (set.contains(item)) {
                    continue
                }
                set.add(item)
                val childTime = dfs(item, map, hasApple, set)
                if (hasApple[item] || childTime > 0) {
                    totalTime += childTime + 2
                }
            }
            return totalTime
        }
    }
}