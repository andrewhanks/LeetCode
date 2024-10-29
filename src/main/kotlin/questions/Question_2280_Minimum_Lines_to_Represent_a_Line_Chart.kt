package questions

import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


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

        fun minimumLinesByMultiply(stockPrices: Array<IntArray>): Int {
            if (stockPrices.size == 1) {
                return 0
            }
            stockPrices.sortWith(Comparator { a, b ->
                a[0] - b[0]
            })
            var ans = 1
            for (count in 2..stockPrices.size - 1) {
                if (!isSameSlope(stockPrices, count)) {
                    ans++
                }
            }
            return ans
        }

        fun isSameSlope(stockPrices: Array<IntArray>, index: Int): Boolean {
            val x1 = stockPrices[index - 2][0]
            val y1 = stockPrices[index - 2][1]
            val x2 = stockPrices[index - 1][0]
            val y2 = stockPrices[index - 1][1]
            val x3 = stockPrices[index][0]
            val y3 = stockPrices[index][1]
            return (y3 - y2).toLong() * (x2 - x1) == (y2 - y1).toLong() * (x3 - x2)
        }

        fun minimumLinesByDiff(stockPrices: Array<IntArray>): Int {
            stockPrices.sortWith(Comparator { a, b ->
                a[0] - b[0]
            })
            var slope = intArrayOf(0, 0)
            var ans = 0
            var prevNode = stockPrices[0]
            for (count in 1..stockPrices.size - 1) {
                val currNode = stockPrices[count]
                val xDiff = currNode[0] - prevNode[0]
                val yDiff = currNode[1] - prevNode[1]
                var gcd = if (xDiff == 0 || yDiff == 0) {
                    1
                } else {
                    gcd(xDiff, yDiff)
                }
                val temp = intArrayOf(xDiff / gcd, yDiff / gcd)
                if (slope[0] != temp[0] || slope[1] != temp[1]) {
                    ans++
                    slope = temp
                }
                prevNode = currNode
            }
            return ans
        }

        fun gcd(x: Int, y: Int): Int {
            val max = max(abs(x), abs(y))
            val min = min(abs(x), abs(y))
            if (max % min == 0) {
                return min
            }
            // println("min = $min, max%min = ${max%min}")
            return gcd(min, max % min)
        }
    }
}