package questions

import java.util.*
import kotlin.math.abs
import kotlin.math.min


class Question_939_Minimum_Area_Rectangle {

    companion object {

        fun runQuestion() {
//            Input: points = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
//            Output: 2
            val intArray = arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 3),
                intArrayOf(3, 1),
                intArrayOf(3, 3),
                intArrayOf(4, 1),
                intArrayOf(4, 3)
            )
            val result = minAreaRect(intArray)
            println("Question 939: $result")
        }

        fun minAreaRect(points: Array<IntArray>): Int {
            val map: TreeMap<Int, MutableList<Int>> = TreeMap()
            for (i in 0..points.size - 1) {
                val point = points[i]
                val list = map.getOrDefault(point[0], mutableListOf())
                list.add(point[1])
                map[point[0]] = list
            }
            val keys = map.keys.toList()
            var ans = Int.MAX_VALUE
            // println("map = $map")
            for (i in 0..keys.size - 1) {
                for (j in i + 1..keys.size - 1) {
                    val points = map[keys[i]]
                    if (points == null) {
                        continue
                    }
                    for (k in 0..points.size - 1) {
                        for (l in k + 1..points.size - 1) {
                            val yPoint = map[keys[j]]
                            if (yPoint == null) {
                                continue
                            }
                            if (yPoint.contains(points[k]) && yPoint.contains(points[l])) {
                                // println("keys[i] = ${keys[i]}, keys[j] = ${keys[j]}, points[l] = ${points[l]}, points[k] = ${points[k]}")
                                ans = min(ans, abs((keys[j] - keys[i]) * (points[l] - points[k])))
                            }
                        }
                    }
                }
            }
            if (ans == Int.MAX_VALUE) {
                return 0
            } else {
                return ans
            }
        }
    }
}