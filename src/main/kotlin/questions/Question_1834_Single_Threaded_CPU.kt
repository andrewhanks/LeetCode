package questions

import java.util.*


class Question_1834_Single_Threaded_CPU {

    companion object {

        fun runQuestion() {
//            Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
//            Output: [0,2,3,1]
            val tasks = arrayOf(intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(3, 2), intArrayOf(4, 1))
            val result = getOrder(tasks)
            println("Question 1834: ${result.contentToString()}")
        }

        fun getOrder(tasks: Array<IntArray>): IntArray {
            val queue = PriorityQueue<IntArray> { a, b ->
                if (a[1] != b[1]) {
                    a[1] - b[1]
                } else {
                    a[2] - b[2]
                }
            }
            for (i in 0..tasks.size - 1) {
                queue.add(intArrayOf(i, tasks[i][0], tasks[i][1]))
            }
            var ans: MutableList<Int> = mutableListOf()
            var time = 1
            val availableQueue = PriorityQueue<IntArray> { a, b ->
                if (a[2] != b[2]) {
                    a[2] - b[2]
                } else {
                    a[0] - b[0]
                }
            }
            while (!queue.isEmpty()) {
                while (!queue.isEmpty() && queue.peek()[1] <= time) {
                    availableQueue.add(queue.remove())
                }
                if (!availableQueue.isEmpty()) {
                    val task = availableQueue.remove()
                    // println("queue task = ${task.contentToString()}, time = $time")
                    ans.add(task[0])
                    time += task[2]
                } else {
                    time = queue.peek()[1]
                }
            }
            while (!availableQueue.isEmpty()) {
                val task = availableQueue.remove()
                // println("task = ${task.contentToString()}, time = $time")
                ans.add(task[0])
            }
            return ans.toIntArray()
        }
    }
}