package questions

import java.util.*


class Question_2280_Minimum_Lines_to_Represent_a_Line_Chart {

    companion object {

        fun runQuestion() {
//            Input: stockPrices = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]
//            Output: 3
            val stockPrices = arrayOf(
                intArrayOf(1, 7),
                intArrayOf(2, 6),
                intArrayOf(3, 5),
                intArrayOf(4, 4),
                intArrayOf(5, 4),
                intArrayOf(6, 3),
                intArrayOf(7, 2),
                intArrayOf(8, 1)
            )
            val result = minimumLines(stockPrices)
            println("Question 2280: $result")
        }

        fun minimumLines(stockPrices: Array<IntArray>): Int {
            val queue: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                a[0] - b[0]
            }
            for (count in 0..stockPrices.size - 1) {
                queue.add(stockPrices[count])
            }
            var slope = Double.MIN_VALUE
            var ans = 0
            var prevNode = queue.remove()
            while (!queue.isEmpty()) {
                val currNode = queue.remove()
                val temp = (currNode[1] - prevNode[1]) * 10 / (currNode[0] - prevNode[0]).toDouble()
                // println("temp = $temp")
                if (slope != temp) {
                    ans++
                    slope = temp
                }
                prevNode = currNode
            }
            return ans
        }
    }
}