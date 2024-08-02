package questions

import kotlin.math.max


class Question_2365_Task_Scheduler_II {

    companion object {

        fun runQuestion() {
//            Input: tasks = [1,2,1,2,3,1], space = 3
//            Output: 9
            val tasks = intArrayOf(1, 2, 1, 2, 3, 1)
            val space = 3
            val result = taskSchedulerII(tasks, space)
            println("Question 2365: $result")
        }

        fun taskSchedulerII(tasks: IntArray, space: Int): Long {
            val map: MutableMap<Int, Long> = mutableMapOf()
            var ans = 0L
            for (count in 0..tasks.size - 1) {
                ans++
                ans = max(ans, map.getOrDefault(tasks[count], 0))
                map[tasks[count]] = ans + space + 1
            }
            return ans
        }
    }
}