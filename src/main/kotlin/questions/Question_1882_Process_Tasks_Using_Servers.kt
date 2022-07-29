package questions

import java.util.*

class Question_1882_Process_Tasks_Using_Servers {

    companion object {

        fun runQuestion1882() {
            val numberArray1 = intArrayOf(3, 3, 2)
            val numberArray2 = intArrayOf(1, 2, 3, 2, 1, 2)
            val result = assignTasksWithPriorityQueuesWebSolution(numberArray1, numberArray2)
            println("Question 1882: $result")
        }

        fun assignTasksWithPriorityQueuesWebSolution(servers: IntArray, tasks: IntArray): IntArray {
            val n: Int = servers.size
            val m: Int = tasks.size

            //index 0:server ID, index 1:server weight
            val idle: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                if (a[1] == b[1]) {
                    a[0] - b[0]
                } else {
                    a[1] - b[1]
                }
            }
            for (i in 0 until n) {
                idle.offer(intArrayOf(i, servers[i]))
            }

            //index 0:server ID, index 1:server weight, index 2:free time
            val using: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                if (a[2] == b[2]) {
                    if (a[1] == b[1]) {
                        a[0] - b[0]
                    } else {
                        a[1] - b[1]
                    }
                } else {
                    a[2] - b[2]
                }
            }

            val answer = IntArray(m)

            //int t = 0;
            for (i in 0 until m) {
                val task: Int = tasks[i]
                while (!using.isEmpty() && using.peek()[2] <= i) {
                    val tmp: IntArray = using.poll()
                    idle.offer(intArrayOf(tmp[0], tmp[1]))
                }
                if (!idle.isEmpty()) {
                    val tmp: IntArray = idle.poll()
                    answer[i] = tmp[0]
                    using.offer(intArrayOf(tmp[0], tmp[1], i + task))
                } else {
                    val tmp: IntArray = using.poll()
                    tmp[2] += task
                    answer[i] = tmp[0]
                    using.offer(intArrayOf(tmp[0], tmp[1], tmp[2]))
                }
            }
            return answer
        }

        fun assignTasks(servers: IntArray, tasks: IntArray): IntArray {
            val serverIsFreeUntil = IntArray(servers.size) { -1 }
            var currentTime = 0
            var tempServerIndex: Int = -1
            val ans = IntArray(tasks.size)
            var taskIndex = 0
            while (taskIndex <= tasks.size - 1) {
                while (tempServerIndex == -1 && taskIndex <= tasks.size - 1) {
                    servers.forEachIndexed { serverIndex, serverValue ->
                        if (serverIsFreeUntil[serverIndex] <= currentTime) {
                            if (tempServerIndex == -1 || serverValue < servers[tempServerIndex]) {
                                tempServerIndex = serverIndex
                            }
                        }
                    }
                    if (tempServerIndex == -1) {
                        currentTime++
                    } else {
                        println(
                            "currentTime = " + currentTime +
                                    ", tasks[$taskIndex] = " + tasks[taskIndex] +
                                    ", servers[$tempServerIndex] = " + servers[tempServerIndex] +
                                    ", serverIsFreeUntil[$tempServerIndex] = " + serverIsFreeUntil[tempServerIndex]
                        )
                        if (tempServerIndex != -1 && taskIndex + 1 <= currentTime) {
                            serverIsFreeUntil[tempServerIndex] = currentTime + tasks[taskIndex]
                            ans[taskIndex] = tempServerIndex
                            taskIndex++
                            tempServerIndex = -1
                        } else {
                            serverIsFreeUntil[tempServerIndex] = currentTime + tasks[taskIndex]
                            ans[taskIndex] = tempServerIndex
                            taskIndex++
                            currentTime++
                            tempServerIndex = -1
                        }
                    }
                }
            }
            return ans
        }
    }
}