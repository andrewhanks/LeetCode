package questions

import java.util.*


class Question_1942_The_Number_of_the_Smallest_Unoccupied_Chair {

    companion object {

        fun runQuestion() {
//            Input: times = [[3,10],[1,5],[2,6]], targetFriend = 0
//            Output: 2
            val matrix = arrayOf(intArrayOf(3, 10), intArrayOf(1, 5), intArrayOf(2, 6))
            val targetFriend = 0
            val result = smallestChair(matrix, targetFriend)
            println("Question 1942: $result")
        }

        fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
            val result: MutableList<IntArray> = mutableListOf()
            val queue = PriorityQueue<IntArray> { a, b ->
                a[3] - b[3]
            }
            for (i in 0..times.size - 1) {
                val temp = intArrayOf(i, times[i][0], times[i][1])
                result.add(temp)
            }
            result.sortBy { it[1] }
            // for(item in result) {
            //     println("item = ${item.contentToString()}")
            // }
            // println("=================================")
            val occupied = Array(times.size) { false }
            for (i in 0..result.size - 1) {
                val time = result[i]
                while (!queue.isEmpty() && queue.peek()[3] <= time[1]) {
                    val item = queue.remove()
                    occupied[item[1]] = false
                }
                // println("occupied = ${occupied.contentToString()}")
                var number = 0
                while (occupied[number]) {
                    number++
                }
                if (targetFriend == time[0]) {
                    return number
                }
                occupied[number] = true
                queue.add(intArrayOf(i, number, time[1], time[2]))
                // println("i = $i, number = $number, time[0] = ${time[0]}, time[1] = ${time[1]}, time[2] = ${time[2]}")
            }
            return -1
        }

        fun smallestChairQuicker(times: Array<IntArray>, targetFriend: Int): Int {
            val result: MutableList<IntArray> = mutableListOf()
            val used = PriorityQueue<IntArray> { a, b ->
                a[0] - b[0]
            }
            for (i in 0..times.size - 1) {
                val temp = intArrayOf(i, times[i][0], times[i][1])
                result.add(temp)
            }
            result.sortBy { it[1] }
            val empty = PriorityQueue<Int> { a, b ->
                a - b
            }
            for (i in 0..times.size - 1) {
                empty.add(i)
            }
            for (i in 0..result.size - 1) {
                val time = result[i]
                while (!used.isEmpty() && used.peek()[0] <= time[1]) {
                    val item = used.remove()
                    empty.add(item[1])
                }
                val number = empty.remove()
                if (targetFriend == time[0]) {
                    return number
                }
                used.add(intArrayOf(time[2], number))
            }
            return -1
        }
    }
}