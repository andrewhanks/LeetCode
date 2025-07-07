package questions

import java.util.*
import kotlin.math.min


class Question_787_Cheapest_Flights_Within_K_Stops {

    companion object {

        fun runQuestion() {
//            Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
//            Output: 700
            val n = 4
            val flights = arrayOf(
                intArrayOf(0, 1, 100),
                intArrayOf(1, 2, 100),
                intArrayOf(2, 0, 100),
                intArrayOf(1, 3, 600),
                intArrayOf(2, 3, 200)
            )
            val src = 0
            val dst = 3
            val k = 1
            val result = findCheapestPrice(n, flights, src, dst, k)
            println("Question 787: $result")
        }

        fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
            var result = IntArray(n) { Int.MAX_VALUE }
            result[src] = 0
            for (count in 0..k) {
                val temp = result.toMutableList()
                for (flight in flights) {
                    if (result[flight[0]] != Int.MAX_VALUE) {
                        temp[flight[1]] = min(temp[flight[1]], result[flight[0]] + flight[2])
                    }
                }
                // println(result.contentToString())
                result = temp.toIntArray()
            }
            if (result[dst] == Int.MAX_VALUE) {
                return -1
            } else {
                return result[dst]
            }
        }

        fun findCheapestPriceByDijkstraAlgorithm(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
            val map: MutableMap<Int, MutableList<IntArray>> = mutableMapOf()
            for (flight in flights) {
                map.putIfAbsent(flight[0], mutableListOf())
                map[flight[0]]!!.add(intArrayOf(flight[1], flight[2]))
            }
            val price = Array(n) { IntArray(k + 2) { Int.MAX_VALUE / 2 } }
            val queue = PriorityQueue<IntArray> { a, b ->
                a[1] - b[1]
            }
            queue.add(intArrayOf(src, 0, 0)) // current, price, times
            while (!queue.isEmpty()) {
                val node = queue.remove()
                if (node[0] == dst) {
                    return node[1]
                }
                if (node[2] > k) {
                    continue
                }
                if (price[node[0]][node[2] + 1] < Int.MAX_VALUE / 2) {
                    continue
                }
                price[node[0]][node[2] + 1] = node[1]
                if (map[node[0]] != null) {
                    for (item in map[node[0]]!!) {
                        queue.add(intArrayOf(item[0], node[1] + item[1], node[2] + 1))
                    }
                }
            }
            return -1
        }
    }
}