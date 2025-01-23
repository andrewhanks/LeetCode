package questions

import java.util.*
import kotlin.Comparator


class Question_2406_Divide_Intervals_Into_Minimum_Number_of_Groups {

    companion object {

        fun runQuestion() {
//            Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
//            Output: 3
            val intervals =
                arrayOf(intArrayOf(5, 10), intArrayOf(6, 8), intArrayOf(1, 5), intArrayOf(2, 3), intArrayOf(1, 10))
            val result = minGroups(intervals)
            println("Question 2406: $result")
        }

        fun minGroups(intervals: Array<IntArray>): Int {
            intervals.sortWith(Comparator { a, b ->
                if (b[0] == a[0]) {
                    b[1] - a[1]
                } else {
                    a[0] - b[0]
                }
            })
            // println("intervals = ${intervals.contentDeepToString()}")
            val queue: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                a[1] - b[1]
            }
            for (item in intervals) {
                var overlap = true
                if (!queue.isEmpty()) {
                    val range = queue.peek()
                    // println("item = ${item.contentToString()}, range = ${range.contentToString()}")
                    if (item[0] > range[1]) {
                        overlap = false
                        range[1] = item[1]
                        queue.remove()
                        queue.add(intArrayOf(range[0], range[1]))
                        continue
                    }
                }
                if (overlap) {
                    queue.add(item)
                }
            }
            return queue.size
        }
    }
}