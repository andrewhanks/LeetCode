package questions

import java.util.*


class Question_3310_Remove_Methods_From_Project {

    companion object {

        fun runQuestion() {
//            Input: n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]
//            Output: [0,1,2,3]
            val n = 4
            val k = 1
            val invocations = arrayOf(intArrayOf(1, 2), intArrayOf(0, 1), intArrayOf(3, 2))
            val result = remainingMethods(n, k, invocations)
            println("Question 3310: $result")
        }

        fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): List<Int> {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            for (item in invocations) {
                map[item[0]] = map.getOrDefault(item[0], mutableListOf())
                map[item[0]]!!.add(item[1])
            }
            val remove: MutableSet<Int> = mutableSetOf()
            val queue: Queue<Int> = LinkedList()
            queue.add(k)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                remove.add(node)
                if (map[node] == null) {
                    continue
                }
                for (item in map[node]!!) {
                    if (!remove.contains(item)) {
                        queue.add(item)
                    }
                }
            }
            val ans: MutableList<Int> = mutableListOf()
            for (i in 0..n - 1) {
                ans.add(i)
            }
            for (i in 0..n - 1) {
                if (!remove.contains(i)) {
                    if (map[i] == null) {
                        continue
                    }
                    for (item in map[i]!!) {
                        if (remove.contains(item)) {
                            return ans.toList()
                        }
                    }
                }
            }
            ans.clear()
            for (i in 0..n - 1) {
                if (!remove.contains(i)) {
                    ans.add(i)
                }
            }
            return ans.toList()
        }
    }
}