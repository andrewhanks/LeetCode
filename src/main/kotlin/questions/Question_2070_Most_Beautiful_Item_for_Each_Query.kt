package questions

import java.util.*
import kotlin.math.max


class Question_2070_Most_Beautiful_Item_for_Each_Query {

    companion object {

        fun runQuestion() {
//            Input: items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
//            Output: [2,4,5,5,6,6]
            val items =
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 2), intArrayOf(2, 4), intArrayOf(5, 6), intArrayOf(3, 5))
            val queries = intArrayOf(1, 2, 3, 4, 5, 6)
            val result = maximumBeauty(items, queries)
            println("Question 2070: ${result.contentToString()}")
        }

        fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
            val itemQueue = PriorityQueue<IntArray> { a, b ->
                if (a[0] == b[0]) {
                    a[1] - b[1]
                } else {
                    a[0] - b[0]
                }
            }
            val queryQueue = PriorityQueue<IntArray> { a, b ->
                a[0] - b[0]
            }
            for (item in items) {
                itemQueue.add(item)
            }
            for (i in 0..queries.size - 1) {
                queryQueue.add(intArrayOf(queries[i], i))
            }
            val ans = IntArray(queries.size) { 0 }
            var item = intArrayOf(0, 0)
            var max = 0
            while (!queryQueue.isEmpty()) {
                val query = queryQueue.remove()
                // println("query = ${query.contentToString()}")
                while (!itemQueue.isEmpty() && query[0] >= itemQueue.peek()[0]) {
                    item = itemQueue.remove()
                    max = max(max, item[1])
                }
                // println("item = ${item.contentToString()}")
                ans[query[1]] = max
            }
            return ans
        }
    }
}