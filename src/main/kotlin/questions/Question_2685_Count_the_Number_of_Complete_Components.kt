package questions

class Question_2685_Count_the_Number_of_Complete_Components {

    companion object {

        fun runQuestion() {
//            Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
//            Output: 1
            val n = 6
            val edges =
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(3, 5))
            val result = countCompleteComponents(n, edges)
            println("Question 2685: $result")
        }

        fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
            val group = IntArray(n) { 0 }
            for (i in 0..n - 1) {
                group[i] = i
            }
            for (edge in edges) {
                union(edge[0], edge[1], group)
            }
            for (edge in edges) {
                union(edge[0], edge[1], group)
            }
            // println("group = ${group.contentToString()}")
            val groupNode = IntArray(n) { 0 }
            for (item in group) {
                groupNode[item]++
            }
            val groupEdge = IntArray(n) { 0 }
            for (edge in edges) {
                groupEdge[group[edge[0]]]++
                groupEdge[group[edge[1]]]++
            }
            var ans = 0
            // println("groupNode = ${groupNode.contentToString()}, groupEdge = ${groupEdge.contentToString()}")
            for (i in 0..groupEdge.size - 1) {
                if (groupNode[i] != 0 && groupNode[i] * (groupNode[i] - 1) == groupEdge[i]) {
                    ans++
                }
            }
            return ans
        }

        fun union(x: Int, y: Int, group: IntArray) {
            val groupx = find(x, group)
            val groupy = find(y, group)
            if (groupx != groupy) {
                group[groupy] = groupx
            }
        }

        fun find(x: Int, group: IntArray): Int {
            if (x == group[x]) {
                return x
            }
            group[x] = find(group[x], group)
            return group[x]
        }

        fun countCompleteComponentsSlowSolution(n: Int, edges: Array<IntArray>): Int {
            val groups: MutableList<MutableSet<Int>> = mutableListOf()
            for (count in 0..n - 1) {
                groups.add(mutableSetOf())
                groups[count].add(count)
                for (edge in edges) {
                    if (edge.contains(count)) {
                        groups[count].addAll(edge.toSet())
                    }
                }
            }
            // println("==================")
            // for (group in groups) {
            //     println(group)
            // }
            // println("------------------")
            val results: MutableList<MutableSet<Int>> = mutableListOf()
            for (countx in 0..groups.size - 1) {
                var tempMatch = 0
                var tempGroup = groups[countx].sorted()
                // println(tempGroup)
                for (county in countx + 1..groups.size - 1) {
                    if (tempGroup == groups[county].sorted()) {
                        tempMatch++
                    }
                }
                var isTheSame = false
                for (result in results) {
                    if (result == groups[countx]) {
                        isTheSame = true
                    }
                }
                if (tempMatch + 1 == groups[countx].size && !isTheSame) {
                    results.add(groups[countx])
                }
            }
            // println("==================")
            // for (result in results) {
            //     println(result)
            // }
            // println("------------------")
            return results.size
        }
    }
}