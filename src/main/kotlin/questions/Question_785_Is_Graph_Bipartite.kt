package questions


class Question_785_Is_Graph_Bipartite {

    companion object {

        fun runQuestion() {
//            Input: graph = [[1,3],[0,2],[1,3],[0,2]]
//            Output: true
            val graph = arrayOf(intArrayOf(1, 3), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(0, 2))
            val result = isBipartite(graph)
            println("Question 785: $result")
        }

        fun isBipartite(graph: Array<IntArray>): Boolean {
            val group1: MutableSet<Int> = mutableSetOf()
            val group2: MutableSet<Int> = mutableSetOf()
            val visited: MutableSet<Int> = mutableSetOf()
            while (visited.size < graph.size) {
                var node = 0
                var putInFirstGroup = true
                for (count in 0..graph.size - 1) {
                    if (!visited.contains(count)) {
                        node = count
                        if (group1.contains(count)) {
                            putInFirstGroup = true
                            break
                        } else if (group2.contains(count)) {
                            putInFirstGroup = false
                            break
                        }
                    }
                }
                // println("node = $node, putInFirstGroup = $putInFirstGroup")
                if (!addNodeToGroup(node, putInFirstGroup, graph, group1, group2, visited)) {
                    return false
                }
            }
            return true
        }

        fun addNodeToGroup(
            node: Int,
            insertInFirstGroup: Boolean,
            graph: Array<IntArray>,
            group1: MutableSet<Int>,
            group2: MutableSet<Int>,
            visited: MutableSet<Int>
        ): Boolean {
            visited.add(node)
            var bipartite = true
            if (insertInFirstGroup) {
                group1.add(node)
                for (j in 0..graph[node].size - 1) {
                    val target = graph[node][j]
                    group2.add(target)
                    if (group1.contains(target)) {
                        return false
                    } else if (!visited.contains(target)) {
                        bipartite = addNodeToGroup(target, false, graph, group1, group2, visited)
                    }
                }
            } else {
                group2.add(node)
                for (j in 0..graph[node].size - 1) {
                    val target = graph[node][j]
                    group1.add(target)
                    if (group2.contains(target)) {
                        return false
                    } else if (!visited.contains(target)) {
                        bipartite = addNodeToGroup(target, true, graph, group1, group2, visited)
                    }
                }
            }
            // println("group1 = $group1, group2 = $group2, visited = $visited")
            return bipartite
        }

        fun isBipartiteWithSaveGroupInVisitedArray(graph: Array<IntArray>): Boolean {
            val visited = IntArray(graph.size) { -1 }
            for (count in 0..visited.size - 1) {
                if (visited[count] != -1) {
                    continue
                }
                if (!addNodeToGroup(count, 0, graph, visited)) {
                    return false
                }
            }
            return true
        }

        fun addNodeToGroup(node: Int, group: Int, graph: Array<IntArray>, visited: IntArray): Boolean {
            visited[node] = group
            for (j in 0..graph[node].size - 1) {
                val target = graph[node][j]
                if (visited[target] == group) {
                    return false
                } else if (visited[target] == -1) {
                    if (!addNodeToGroup(target, 1 - group, graph, visited)) {
                        return false
                    }
                }
            }
            return true
        }
    }
}