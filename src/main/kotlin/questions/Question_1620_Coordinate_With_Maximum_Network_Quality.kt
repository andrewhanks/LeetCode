package questions

import java.util.*
import kotlin.math.*

class Question_1620_Coordinate_With_Maximum_Network_Quality {

    companion object {

        fun runQuestion() {
//            Input: towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
//            Output: [2,1]
            val towers = arrayOf(intArrayOf(1, 2, 5), intArrayOf(2, 1, 7), intArrayOf(3, 1, 9))
            val radius = 2
            val result = bestCoordinate(towers, radius)
            println("Question 1620: ${result.contentToString()}")
        }

        fun bestCoordinate(towers: Array<IntArray>, radius: Int): IntArray {
            var minX = Int.MAX_VALUE
            var maxX = Int.MIN_VALUE
            var minY = Int.MAX_VALUE
            var maxY = Int.MIN_VALUE
            for (count in 0..towers.size - 1) {
                minX = min(minX, towers[count][0] - radius)
                maxX = max(maxX, towers[count][0] + radius)
                minY = min(minY, towers[count][1] - radius)
                maxY = max(maxY, towers[count][1] + radius)
            }
            minX = max(minX, 0)
            minY = max(minY, 0)
            val queue: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                if (a[2] != b[2]) {
                    b[2] - a[2]
                } else {
                    if (a[0] != b[0]) {
                        a[0] - b[0]
                    } else {
                        a[1] - b[1]
                    }
                }
            }
            for (i in minX..maxX) {
                for (j in minY..maxY) {
                    var total = 0
                    for (k in 0..towers.size - 1) {
                        val distance = sqrt(
                            abs(towers[k][0] - i) * abs(towers[k][0] - i).toDouble() +
                                    abs(towers[k][1] - j) * abs(towers[k][1] - j)
                        )
                        if (distance > radius) {
                            continue
                        }
                        val quality = floor(towers[k][2] / (1 + distance)).toInt()
                        total += quality
                    }
                    // println("i = $i, j = $j, total = $total")
                    queue.add(intArrayOf(i, j, total))
                }
            }
            val node = queue.remove()
            if (node[2] == 0) {
                return intArrayOf(0, 0)
            }
            return intArrayOf(node[0], node[1])
        }
    }
}