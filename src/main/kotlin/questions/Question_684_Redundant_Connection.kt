package questions

class Question_684_Redundant_Connection {

    companion object {

        fun runQuestion() {
//            Input: edges = [[3,4],[1,2],[2,4],[3,5],[2,5]]
//            Output: [2,5]
            val edges =
                arrayOf(intArrayOf(3, 4), intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(3, 5), intArrayOf(2, 5))
            val result = findRedundantConnection(edges)
            println("Question 684: ${result.contentToString()}")
        }

        fun findRedundantConnection(edges: Array<IntArray>): IntArray {
            val result: MutableList<MutableSet<Int>> = mutableListOf()
            for (i in 0..edges.size - 1) {
                var isContained = -1
                var isCombined = false
                for (j in 0..result.size - 1) {
                    if (result[j].contains(edges[i][0]) || result[j].contains(edges[i][1])) {
                        if (isContained == -1) {
                            isContained = j
                        } else {
                            for (k in 0..result[j].size - 1) {
                                result[isContained].add(result[j].elementAt(k))
                            }
                            result.remove(result[j])
                            isCombined = true
                            break
                        }
                    }
                }
                if (isCombined) {
                    continue
                }
                // println("isContained = $isContained")
                if (isContained == -1) {
                    val newSet: MutableSet<Int> = mutableSetOf()
                    newSet.add(edges[i][0])
                    newSet.add(edges[i][1])
                    result.add(newSet)
                } else {
                    if (result[isContained].contains(edges[i][0]) && result[isContained].contains(edges[i][1])) {
                        return edges[i]
                    } else {
                        result[isContained].add(edges[i][0])
                        result[isContained].add(edges[i][1])
                    }
                }
                // println("result.size = ${result.size}")
                // for(count in 0..result.size-1) {
                //     println("result[$count] = ${result[count]}")
                // }
            }
            return intArrayOf()
        }

        fun findRedundantConnectionWithUnion(edges: Array<IntArray>): IntArray {
            val result = IntArray(edges.size + 1) { 0 }
            for (count in 0..result.size - 1) {
                result[count] = count
            }
            for (edge in edges) {
                val x = edge[0]
                val y = edge[1]
                if (isInUnion(x, y, result)) {
                    return edge
                }
            }
            return intArrayOf()
        }

        fun isInUnion(x: Int, y: Int, result: IntArray): Boolean {
            val node1 = find(x, result)
            val node2 = find(y, result)
            // println("node1 = ${node1}, node2 = ${node2}")
            if (node1 == node2) {
                return true
            }
            result[node2] = node1
            return false
        }

        fun find(x: Int, result: IntArray): Int {
            if (result[x] == x) {
                return x
            } else {
                result[x] = find(result[x], result)
                return result[x]
            }
        }
    }
}