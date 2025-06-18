package questions

import java.util.*


class Question_851_Loud_and_Rich {

    companion object {

        fun runQuestion() {
//            Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
//            Output: [5,5,2,5,4,5,6,7]
            val richer = arrayOf(
                intArrayOf(1, 0),
                intArrayOf(2, 1),
                intArrayOf(3, 1),
                intArrayOf(3, 7),
                intArrayOf(4, 3),
                intArrayOf(5, 3),
                intArrayOf(6, 3)
            )
            val quiet = intArrayOf(3, 2, 5, 4, 6, 1, 7, 0)
            val result = loudAndRich(richer, quiet)
            println("Question 851: ${result.contentToString()}")
        }

        fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            val indegree: MutableList<Int> = MutableList(quiet.size) { 0 }
            for (rich in richer) {
                map.putIfAbsent(rich[0], mutableListOf())
                map[rich[0]]!!.add(rich[1])
                indegree[rich[1]]++
            }
            val ans = IntArray(quiet.size) { 0 }
            for (i in 0..ans.size - 1) {
                ans[i] = i
            }
            val queue: Queue<Int> = LinkedList()
            for (i in 0..indegree.size - 1) {
                val degree = indegree[i]
                if (degree == 0) {
                    queue.add(i)
                }
            }
            while (!queue.isEmpty()) {
                val node = queue.remove()
                if (map[node] != null) {
                    for (item in map[node]!!) {
                        if (quiet[ans[item]] > quiet[ans[node]]) {
                            ans[item] = ans[node]
                        }
                        indegree[item]--
                        if (indegree[item] == 0) {
                            queue.add(item)
                        }
                    }
                }
            }
            return ans
        }
    }
}