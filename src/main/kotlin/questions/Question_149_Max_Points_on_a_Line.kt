package questions

import kotlin.math.max


class Question_149_Max_Points_on_a_Line {

    companion object {

        fun runQuestion() {
//            Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//            Output: 4
            val intArray = arrayOf(
                intArrayOf(1, 1),
                intArrayOf(3, 2),
                intArrayOf(5, 3),
                intArrayOf(4, 1),
                intArrayOf(2, 3),
                intArrayOf(1, 4)
            )
            val result = maxPoints(intArray)
            println("Question 149: $result")
        }

        fun maxPoints(points: Array<IntArray>): Int {
            var map: MutableMap<Double, Int> = mutableMapOf()
            var max = 0
            for (x in 0..points.size - 1) {
                map = mutableMapOf()
                println("====================================")
                for (y in 0..points.size - 1) {
                    if (x == y) {
                        continue
                    }
                    val key = if (points[x][1].toDouble() - points[y][1].toDouble() != 0.0) {
                        (points[x][0].toDouble() - points[y][0].toDouble()) / (points[x][1].toDouble() - points[y][1].toDouble())
                    } else {
                        Double.MAX_VALUE
                    }
                    println("key = $key")
                    if (map.contains(key)) {
                        map[key] = map[key]!! + 1
                    } else {
                        map.put(key, 1)
                    }
                }
                for ((key, value) in map) {
                    max = max(max, value)
                    println("max = $max")
                }
            }
            return max + 1
        }
    }
}