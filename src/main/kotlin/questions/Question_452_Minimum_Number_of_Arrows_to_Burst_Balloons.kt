package questions

import kotlin.math.min


class Question_452_Minimum_Number_of_Arrows_to_Burst_Balloons {

    companion object {

        fun runQuestion() {
            // Input: [[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]
            // Output: 2
            val intArray = arrayOf(
                intArrayOf(9, 12),
                intArrayOf(1, 10),
                intArrayOf(4, 11),
                intArrayOf(8, 12),
                intArrayOf(3, 9),
                intArrayOf(6, 9),
                intArrayOf(6, 7)
            )
            val result = findMinArrowShots(intArray)
            println("Question 452: $result")
        }

        fun findMinArrowShots(points: Array<IntArray>): Int {
            points.sortWith(Comparator { a, b ->
                if (a[0] > b[0]) {
                    1
                } else if (b[0] > a[0]) {
                    -1
                } else {
                    0
                }
            })
            points.forEach {
                println("${it[0]}, ${it[1]}")
            }
            var count = 1
            var i = 0
            var start = 0
            var end = 0
            while (i <= points.size - 1) {
                var j = i + 1
                val item = points[i]
                start = item[0]
                end = item[1]
                while (j <= points.size - 1) {
                    val nextItem = points[j]
                    if (end >= nextItem[0]) {
                        end = min(end, nextItem[1])
                    } else {
                        count++
                        break
                    }
                    j++
                }
                i = j
            }
            return count
        }
    }
}