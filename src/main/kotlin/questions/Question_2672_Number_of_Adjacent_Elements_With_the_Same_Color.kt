package questions


class Question_2672_Number_of_Adjacent_Elements_With_the_Same_Color {

    companion object {

        fun runQuestion() {
//            Input: n = 6, queries = [[0,2],[1,2],[2,2],[3,3],[4,3],[5,3],[2,1]]
//            Output: [0,1,1,0,2]
            val n = 6
            val queries = arrayOf(
                intArrayOf(0, 2),
                intArrayOf(1, 2),
                intArrayOf(2, 2),
                intArrayOf(3, 3),
                intArrayOf(4, 3),
                intArrayOf(5, 3),
                intArrayOf(2, 1)
            )
            val result = colorTheArray(n, queries)
            println("Question 2672: ${result.contentToString()}")
        }

        fun colorTheArray(n: Int, queries: Array<IntArray>): IntArray {
            val result = IntArray(n) { 0 }
            val ans = IntArray(queries.size) { 0 }
            var count = 0
            for (i in 0..queries.size - 1) {
                val pos = queries[i][0]
                val color = queries[i][1]
                if (pos - 1 >= 0 && result[pos] != 0 && result[pos] == result[pos - 1]) {
                    count--
                }
                if (pos + 1 <= result.size - 1 && result[pos] != 0 && result[pos] == result[pos + 1]) {
                    count--
                }
                result[pos] = color
                if (pos - 1 >= 0 && result[pos] == result[pos - 1]) {
                    count++
                }
                if (pos + 1 <= result.size - 1 && result[pos] == result[pos + 1]) {
                    count++
                }
                ans[i] = count
            }
            return ans
        }
    }
}