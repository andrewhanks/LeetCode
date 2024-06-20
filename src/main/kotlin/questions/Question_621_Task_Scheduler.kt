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
            val map: MutableMap<Char, Int> = mutableMapOf()
            var max = 0
            for (count in 0..tasks.size - 1) {
                if (!map.contains(tasks[count])) {
                    map.put(tasks[count], 1)
                } else {
                    map[tasks[count]] = map[tasks[count]]!! + 1
                }
                max = max(max, map[tasks[count]]!!)
            }
            val times = map.toList().filter { (key, value) -> value == max }.count()
            var ans = 0
            if ((tasks.size / max) < n + 1) {
                ans = (max - 1) * (n + 1)
                ans = ans + times
            }
            if (ans < tasks.size) {
                ans = tasks.size
            }
            return ans
        }

        fun leastIntervalOldSolution(tasks: CharArray, n: Int): Int {
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