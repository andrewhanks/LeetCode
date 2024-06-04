package questions

import java.util.*

class Question_207_Course_Schedule {

    companion object {

        fun runQuestion() {
//            Input: numCourses = 2, prerequisites = [[1,0]]
//            Output: true
            val prerequisites = arrayOf(intArrayOf(1, 0))
            val numCourses = 2
            val result = canFinish(numCourses, prerequisites)
            println("Question 207: $result")
        }

        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val map: Array<Array<Boolean>> = Array(numCourses) { Array(numCourses) { false } }
            val indegree = IntArray(numCourses) { 0 }
            var result = 0
            for (count in 0..prerequisites.size - 1) {
                val course = prerequisites[count]
                // set the map of available course after prerequisites course finished
                map[course[1]][course[0]] = true
                indegree[course[0]]++
            }
            // println("graph = ${graph.contentDeepToString()}")
            // println("indegree = ${indegree.contentToString()}")
            val queue: Queue<Int> = LinkedList()
            for (count in 0..indegree.size - 1) {
                if (indegree[count] == 0) {
                    queue.add(count)
                    result++
                }
            }
            // println("result 1 = $result")
            while (!queue.isEmpty()) {
                val course = queue.remove()
                for (count in 0..map[course].size - 1) {
                    if (map[course][count]) {
                        indegree[count]--
                        // println("indegree[$course] = ${indegree[course]}")
                        if (indegree[count] == 0) {
                            queue.add(count)
                            result++
                        }
                    }
                }
            }
            // println("result = $result")
            return result == numCourses
        }

        fun canFinishCheckCircle(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            // 为了将prerequisites转化为图结构，定义一个graph数组。
            // graph下标代表课程编号，值代表该课程所有先修课列表。
            // 初始化graph
            val graph: MutableList<MutableList<Int>> = MutableList(numCourses) { mutableListOf() }
            // 将prerequisites转化为图结构。
            for (count in 0..prerequisites.size - 1) {
                graph[prerequisites[count][0]].add(prerequisites[count][1])
            }
            // 创建一个visited 数组
            // 0: unvisited; 1: visiting 2: visited
            // ・ 0 代表还未访问的状态
            // ・ 1 代表正在访问的状态
            // ・ 2 代表已经访问完成
            val visited = IntArray(numCourses) { 0 }
            for (count in 0..numCourses - 1) {
                // dfs递归该课的先修课路径上是否存在回路。
                if (dfs(count, graph, visited)) {
                    // 如果存在回路可直接返回false。
                    return false
                }
            }
            return true
        }

        // 返回false代表没有回路，true代表发现回路
        fun dfs(currCourse: Int, graph: MutableList<MutableList<Int>>, visited: IntArray): Boolean {
            // visited状态为1表示发现回路，返回true
            if (visited[currCourse] == 1) {
                return true
            }
            // visited状态为2表示当前节点之后不存在回路，可直接返回false
            if (visited[currCourse] == 2) {
                return false
            }
            // 开始递归当前节点的先修课
            // 将状态更新为1
            visited[currCourse] = 1
            // 循环当前课的所有先修课
            for (count in 0..graph[currCourse].size - 1) {
                // 递归查看先修课之后的路径是否有回路
                if (dfs(graph[currCourse][count], graph, visited)) {
                    // 如果有回路直接返回true。
                    return true
                }
            }
            // 当前节点的所有先修课路径循环结束后，将visited更新为2。
            visited[currCourse] = 2
            return false
        }
    }
}