package questions


class Question_3249_Count_the_Number_of_Good_Nodes {

    companion object {

        fun runQuestion() {
//            Input: edges = [[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]]
//            Output: 12
            val grid = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(1, 4),
                intArrayOf(0, 5),
                intArrayOf(5, 6),
                intArrayOf(6, 7),
                intArrayOf(7, 8),
                intArrayOf(0, 9),
                intArrayOf(9, 10),
                intArrayOf(9, 12),
                intArrayOf(10, 11)
            )
            val result = countGoodNodes(grid)
            println("Question 3249: $result")
        }

        var ans = 0
        fun countGoodNodes(edges: Array<IntArray>): Int {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            for (count in 0..edges.size - 1) {
                if (!map.contains(edges[count][0])) {
                    val temp = mutableListOf(edges[count][1])
                    map[edges[count][0]] = temp
                } else {
                    map[edges[count][0]]!!.add(edges[count][1])
                }
                if (!map.contains(edges[count][1])) {
                    val temp = mutableListOf(edges[count][0])
                    map[edges[count][1]] = temp
                } else {
                    map[edges[count][1]]!!.add(edges[count][0])
                }
            }
            val visited: MutableList<Boolean> = MutableList(edges.size + 1) { false }
            countNodeNumber(map, 0, visited)
            return ans
        }

        fun countNodeNumber(map: MutableMap<Int, MutableList<Int>>, target: Int, visited: MutableList<Boolean>): Int {
            visited[target] = true
            var childNumber = map[target]!!.size
            var isTheSame = true
            var tempNumber = -1
            for (item in map[target]!!) {
                if (visited[item]) {
                    continue
                }
                val rest = countNodeNumber(map, item, visited)
                childNumber += rest
                if (tempNumber == -1) {
                    tempNumber = rest
                } else if (tempNumber != rest) {
                    isTheSame = false
                }
            }
            if (isTheSame) {
                ans++
            }
            return childNumber
        }
    }
}