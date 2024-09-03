package questions

import java.util.*


class Question_3015_Count_the_Number_of_Houses_at_a_Certain_Distance_I {

    companion object {

        fun runQuestion() {
//            Input: n = 5, x = 2, y = 4
//            Output: [10,8,2,0,0]
            val n = 5
            val x = 2
            val y = 4
            val result = countOfPairs(n, x, y)
            println("Question 3015: ${result.contentToString()}")
        }

        fun countOfPairs(n: Int, x: Int, y: Int): IntArray {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            for (count in 1..n - 1) {
                if (!map.contains(count)) {
                    map[count] = mutableListOf(count + 1)
                } else {
                    map[count]!!.add(count + 1)
                }
                if (!map.contains(count + 1)) {
                    map[count + 1] = mutableListOf(count)
                } else {
                    map[count + 1]!!.add(count)
                }
            }
            if (!map.contains(x)) {
                map[x] = mutableListOf(y)
            } else {
                map[x]!!.add(y)
            }
            if (!map.contains(y)) {
                map[y] = mutableListOf(x)
            } else {
                map[y]!!.add(x)
            }
            // println("map = $map")
            val result = IntArray(n) { 0 }
            for (number in 1..n) {
                val queue: Queue<Int> = LinkedList()
                val visited = Array(n + 1) { false }
                queue.add(number)
                visited[number] = true
                val size = queue.size
                var level = 0
                while (!queue.isEmpty()) {
                    val size = queue.size
                    for (i in 0..size - 1) {
                        val node = queue.remove()
                        val nextList = map[node] ?: mutableListOf()
                        for (j in 0..nextList.size - 1) {
                            val next = map[node]!![j]
                            if (visited[next]) {
                                continue
                            }
                            queue.add(next)
                            visited[next] = true
                        }
                    }
                    // println("number = $number, queue.size = ${queue.size}")
                    result[level] += queue.size
                    level++
                }
            }
            return result
        }
    }
}