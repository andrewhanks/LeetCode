package questions

import kotlin.math.abs


class Question_1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {

    companion object {

        fun runQuestion() {
//            Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
//            Output: 3
            val n = 6
            val connections =
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(4, 0), intArrayOf(4, 5))
            val result = minReorder(n, connections)
            println("Question 1466: $result")
        }

        fun minReorder(n: Int, connections: Array<IntArray>): Int {
            val path: MutableList<MutableList<Int>> = MutableList(n) { mutableListOf() }
            for (count in 0..connections.size - 1) {
                path[connections[count][0]].add(connections[count][1])
                path[connections[count][1]].add(-connections[count][0])
            }
            val visited = Array(n) { false }
            return dfs(path, 0, visited)
        }

        fun dfs(path: MutableList<MutableList<Int>>, index: Int, visited: Array<Boolean>): Int {
            var ans = 0
            visited[index] = true
            for (count in 0..path[index].size - 1) {
                val target = path[index][count]
                if (visited[abs(target)]) {
                    continue
                }
                ans += if (target < 0) {
                    dfs(path, -target, visited)
                } else {
                    dfs(path, target, visited) + 1
                }
            }
            return ans
        }
    }
}