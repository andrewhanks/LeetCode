package questions

import java.util.*


class Question_1462_Course_Schedule_IV {

    companion object {

        fun runQuestion() {
//            Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
//            Output: [true,true]
            val numCourses = 3
            val prerequisites = arrayOf(intArrayOf(1, 2), intArrayOf(1, 0), intArrayOf(2, 0))
            val queries = arrayOf(intArrayOf(1, 0), intArrayOf(1, 2))
            val result = checkIfPrerequisite(numCourses, prerequisites, queries)
            println("Question 1462: $result")
        }

        fun checkIfPrerequisite(
            numCourses: Int,
            prerequisites: Array<IntArray>,
            queries: Array<IntArray>
        ): List<Boolean> {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            for (count in 0..prerequisites.size - 1) {
                val list = map.getOrDefault(prerequisites[count][0], mutableListOf())
                list.add(prerequisites[count][1])
                map[prerequisites[count][0]] = list
            }
            val result = MutableList(queries.size) { false }
            for (i in 0..queries.size - 1) {
                val queue: Queue<Int> = LinkedList()
                val visited = Array(numCourses) { false }
                queue.add(queries[i][0])
                visited[queries[i][0]] = true
                while (!queue.isEmpty()) {
                    val node = queue.remove()
                    if (node == queries[i][1]) {
                        result[i] = true
                        break
                    }
                    val next = map[node]
                    if (next == null) {
                        continue
                    }
                    for (j in 0..next.size - 1) {
                        if (visited[next[j]]) {
                            continue
                        }
                        queue.add(next[j])
                        visited[next[j]] = true
                    }
                }
            }
            return result.toList()
        }

        fun checkIfPrerequisiteWebSolution(
            numCourses: Int,
            prerequisites: Array<IntArray>,
            queries: Array<IntArray>
        ): List<Boolean> {
            val next = Array(numCourses) { mutableSetOf<Int>() }
            val degree = IntArray(numCourses) { 0 }
            for (count in 0..prerequisites.size - 1) {
                next[prerequisites[count][0]].add(prerequisites[count][1])
                degree[prerequisites[count][1]]++
            }
            val queue: Queue<Int> = LinkedList()
            val pre = Array(numCourses) { mutableSetOf<Int>() }
            for (count in 0..numCourses - 1) {
                pre[count].add(count)
                if (degree[count] == 0) {
                    queue.add(count)
                }
            }
            while (!queue.isEmpty()) {
                val cur = queue.remove()
                for (item in next[cur]) {
                    pre[item].addAll(pre[cur])
                    degree[item]--
                    if (degree[item] == 0) {
                        queue.add(item)
                    }
                }
            }
            val ans = MutableList(queries.size) { false }
            for (count in 0..queries.size - 1) {
                if (pre[queries[count][1]].contains(queries[count][0])) {
                    ans[count] = true
                }
            }
            return ans.toList()
        }
    }
}