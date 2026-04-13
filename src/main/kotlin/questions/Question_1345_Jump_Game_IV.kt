package questions

import java.util.*


class Question_1345_Jump_Game_IV {

    companion object {

        fun runQuestion() {
//            Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
//            Output: 3
            val arr = intArrayOf(100, -23, -23, 404, 100, 23, 23, 23, 3, 404)
            val result = minJumps(arr)
            println("Question 1345: $result")
        }

        fun minJumps(arr: IntArray): Int {
            var times = 0
            val visited = MutableList(arr.size) { false }
            visited[0] = true
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            for (i in 0..arr.size - 1) {
                if (!map.contains(arr[i])) {
                    map[arr[i]] = mutableListOf(i)
                } else {
                    map[arr[i]]?.add(i)
                }
            }
            val queue: Queue<Int> = LinkedList()
            queue.add(0)
            while (queue.isNotEmpty()) {
                val size = queue.size
                var reachLastItem = false
                for (i in 0..size - 1) {
                    val item = queue.remove()
                    if (item == arr.size - 1) {
                        reachLastItem = true
                        break
                    }
                    if (item - 1 >= 0 && !visited[item - 1]) {
                        queue.add(item - 1)
                        visited[item - 1] = true
                    }
                    if (item + 1 <= arr.size - 1 && !visited[item + 1]) {
                        queue.add(item + 1)
                        visited[item + 1] = true
                    }
                    for (j in map[arr[item]] ?: listOf()) {
                        if (visited[j]) {
                            continue
                        }
                        queue.add(j)
                        visited[j] = true
                    }
                    map.remove(arr[item])
                }
                if (reachLastItem) {
                    break
                }
                times++
            }
            return times
        }
    }
}