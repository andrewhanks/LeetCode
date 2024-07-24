package questions

import kotlin.math.pow


class Question_2438_Range_Product_Queries_of_Powers {

    companion object {

        fun runQuestion() {
//            Input: n = 15, queries = [[0,1],[2,2],[0,3]]
//            Output: [2,4,64]
            val n = 15
            val queries = arrayOf(intArrayOf(0, 1), intArrayOf(2, 2), intArrayOf(0, 3))
            val result = productQueries(n, queries)
            println("Question 2438: ${result.contentToString()}")
        }

        fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
            val mod = 1000000007
            var number = 1L
            while (number <= n.toLong()) {
                number *= 2
            }
            number /= 2
            var stored: MutableList<Long> = mutableListOf()
            var rest = n.toLong()
            var count = 0
            while (number > 0) {
                if (rest - number >= 0) {
                    stored.add(0, number)
                    rest -= number
                }
                number /= 2
            }
            // println("stored = $stored")
            var multiple = Array(stored.size) { Array<Long>(stored.size) { 0L } }
            for (i in 0..stored.size - 1) {
                var tempMultiple = 1L
                for (j in i..stored.size - 1) {
                    tempMultiple = tempMultiple * (stored[j] % mod)
                    tempMultiple = tempMultiple % mod
                    multiple[i][j] = tempMultiple
                }
            }
            // println("multiple = ${multiple.contentDeepToString()}")
            var ans = IntArray(queries.size) { 0 }
            for (count in 0..queries.size - 1) {
                ans[count] = multiple[queries[count][0]][queries[count][1]].toInt()
            }
            return ans
        }

        fun productQueriesWebSolution(n: Int, queries: Array<IntArray>): IntArray {
            var n = n
            val powers: MutableList<Long> = ArrayList()
            for (i in 0..31) {
                if ((n and 1) == 1) {
                    powers.add(2.toDouble().pow(i).toLong())
                }
                n = n shr 1
            }
            val mod = 1000000007
            val res = IntArray(queries.size)
            for (i in res.indices) {
                val q = queries[i]
                var ans: Long = 1
                for (j in q[0]..q[1]) {
                    ans = (ans * powers[j]) % mod
                }
                res[i] = ans.toInt()
            }
            return res
        }
    }
}