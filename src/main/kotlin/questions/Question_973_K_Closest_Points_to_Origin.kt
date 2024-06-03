package questions

import java.util.*


class Question_973_K_Closest_Points_to_Origin {

    companion object {

        fun runQuestion() {
//            Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//            Output: [[3,3],[-2,4]]
            val points = arrayOf(
                intArrayOf(3, 3),
                intArrayOf(5, -1),
                intArrayOf(-2, 4),
            )
            val k = 2
            val result = kClosest(points, k)
            println("Question 973: ${result.contentDeepToString()}")
        }

        fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
            val priorityQueue: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])
            }
            for (count in 0..points.size - 1) {
                priorityQueue.add(points[count])
            }
            val result: MutableList<IntArray> = mutableListOf()
            for (count in 0..k - 1) {
                result.add(priorityQueue.remove())
            }
            return result.toTypedArray()
        }
    }
}