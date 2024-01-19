package questions

import kotlin.math.max


class Question_621_Task_Scheduler {

    companion object {

        fun runQuestion() {
//            Input: tasks = ["A","A","A","B","B","B"], n = 2
//            Output: 8
            val tasks = charArrayOf('A', 'A', 'A', 'B', 'B', 'B')
            val n = 2
            val result = leastInterval(tasks, n)
            println("Question 621: $result")
        }

        fun leastInterval(tasks: CharArray, n: Int): Int {
            val result: MutableMap<Char, Int> = mutableMapOf()
            for (count in 0..tasks.size - 1) {
                if (result.contains(tasks[count])) {
                    result[tasks[count]] = result[tasks[count]]!! + 1
                } else {
                    result.put(tasks[count], 1)
                }
            }
            val max = result.values.maxOrNull() ?: 0

            var ct = 0
            for ((key, value) in result) {
                if (max == value) {
                    ct++
                }
            }
            return max((1 + n) * (max - 1) + ct, tasks.size)
        }
    }
}