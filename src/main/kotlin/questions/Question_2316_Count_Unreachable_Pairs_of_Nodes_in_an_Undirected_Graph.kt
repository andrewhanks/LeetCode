package questions

class Question_2316_Count_Unreachable_Pairs_of_Nodes_in_an_Undirected_Graph {

    companion object {

        fun runQuestion() {
//            Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
//            Output: 14
            val n = 7
            val edges = arrayOf(
                intArrayOf(0, 2), intArrayOf(0, 5), intArrayOf(2, 4), intArrayOf(1, 6), intArrayOf(5, 4)
            )
            val result = countPairs(n, edges)
            println("Question 2316: $result")
        }

        fun countPairs(n: Int, edges: Array<IntArray>): Long {
            val result = IntArray(n) { 0 }
            for (count in 0..result.size - 1) {
                result[count] = count
            }
            for (count in 0..edges.size - 1) {
                union(result, edges[count][0], edges[count][1])
                // println(result.contentToString())
            }
            // println("============================")
            for (count in 0..edges.size - 1) {
                union(result, edges[count][0], edges[count][1])
                // println(result.contentToString())
            }
            val group = IntArray(n) { 0 }
            for (count in 0..result.size - 1) {
                group[result[count]]++
            }
            var ans = 0L
            for (count in 0..group.size - 1) {
                if (group[count] != 0) {
                    ans += group[count].toLong() * (n.toLong() - group[count].toLong())
                }
            }
            return ans / 2
        }

        fun union(result: IntArray, x: Int, y: Int) {
            val node1 = find(result, x)
            val node2 = find(result, y)
            if (node1 == node2) {
                return
            }
            result[node2] = node1
        }

        fun find(result: IntArray, x: Int): Int {
            if (result[x] == x) {
                return x
            }
            result[x] = find(result, result[x])
            return result[x]
        }
    }
}