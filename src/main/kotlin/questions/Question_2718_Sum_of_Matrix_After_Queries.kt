package questions

class Question_2718_Sum_of_Matrix_After_Queries {

    companion object {

        fun runQuestion() {
//            Input: n = 3, queries = [[0,0,1],[1,2,2],[0,2,3],[1,0,4]]
//            Output: 23
            val n = 3
            val queries = arrayOf(intArrayOf(0, 0, 1), intArrayOf(1, 2, 2), intArrayOf(0, 2, 3), intArrayOf(1, 0, 4))
            val result = matrixSumQueries(n, queries)
            println("Question 2718: $result")
        }

        fun matrixSumQueries(n: Int, queries: Array<IntArray>): Long {
            val rowSet: MutableSet<Int> = mutableSetOf()
            val colSet: MutableSet<Int> = mutableSetOf()
            var ans = 0L
            for (i in queries.size - 1 downTo 0) {
                val query = queries[i]
                if (query[0] == 1) {
                    if (!colSet.contains(query[1])) {
                        ans += (n - rowSet.size) * query[2]
                    }
                    colSet.add(query[1])
                } else {
                    if (!rowSet.contains(query[1])) {
                        ans += (n - colSet.size) * query[2]
                    }
                    rowSet.add(query[1])
                }
                // println("query = ${query.contentToString()}, colSet = $colSet, rowSet = $rowSet, ans = $ans")
            }
            return ans
        }
    }
}