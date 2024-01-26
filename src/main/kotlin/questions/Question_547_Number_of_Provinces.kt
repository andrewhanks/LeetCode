package questions

import java.util.*


class Question_547_Number_of_Provinces {

    companion object {

        fun runQuestion() {
//            Input: isConnected = [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
//            Output: 1
            val intArray =
                arrayOf(intArrayOf(1, 0, 0, 1), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 1), intArrayOf(1, 0, 1, 1))
            val result = findCircleNum(intArray)
            println("Question 547: $result")
        }

        fun findCircleNum(isConnected: Array<IntArray>): Int {
            val queue: Queue<Int> = LinkedList()
            val visited = BooleanArray(isConnected.size)
            var count = 0
            for (i in 0..isConnected.size - 1) {
                if (!visited[i]) {
                    queue.add(i)
                    while (!queue.isEmpty()) {
                        val target = queue.remove()
                        for (number in 0..isConnected.size - 1) {
                            if (isConnected[target][number] == 1 && !visited[number]) {
                                visited[number] = true
                                queue.add(number)
                            }
                        }
                    }
                    count++
                }
            }
            return count
        }
    }
}