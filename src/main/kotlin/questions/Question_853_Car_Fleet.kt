package questions

import java.util.*

class Question_853_Car_Fleet {

    companion object {

        fun runQuestion() {
//            Input: target = 31, position = [5,26,18,25,29,21,22,12,19,6], speed = [7,6,6,4,3,4,9,7,6,4]
//            Output: 6
            val target = 31
            val position = intArrayOf(5, 26, 18, 25, 29, 21, 22, 12, 19, 6)
            val speed = intArrayOf(7, 6, 6, 4, 3, 4, 9, 7, 6, 4)
            val result = carFleet(target, position, speed)
            println("Question 853: $result")
        }

        fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
            val queue: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                b[0] - a[0]
            }
            for (i in 0..position.size - 1) {
                queue.add(intArrayOf(position[i], speed[i]))
            }
            var ans = 0
            var prevTime = -1.0
            while (!queue.isEmpty()) {
                val node = queue.remove()
                val currentTime = (target.toDouble() - node[0]) / node[1]
                // println("node = ${node.contentToString()}, currentTime = $currentTime, prevTime = $prevTime")
                if (currentTime > prevTime) {
                    ans++
                    prevTime = currentTime
                }
            }
            return ans
        }
    }
}