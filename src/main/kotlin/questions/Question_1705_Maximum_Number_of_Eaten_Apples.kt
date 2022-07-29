package questions

import java.util.*

class Question_1705_Maximum_Number_of_Eaten_Apples {

    companion object {

        fun runQuestion1705() {
            val numberArray1 = intArrayOf(1, 2, 3, 5, 2)
            val numberArray2 = intArrayOf(3, 2, 1, 4, 2)
            val result = eatenApples(numberArray1, numberArray2)
            println("Question 1705: $result")
        }

        fun eatenApples(apples: IntArray, days: IntArray): Int {
            var mostApples = 0
            // 0: days, 1: max stored days, 2: apple numbers
            val growApples: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                if (a[1] == b[1]) {
                    b[0] - a[0]
                } else {
                    b[1] - a[1]
                }
            }
            days.forEachIndexed { index, value ->
                if (value != 0) {
                    growApples.offer(intArrayOf(index + 1, index + value, apples[index]))
                }
            }
            var day = growApples.peek()[1]
            while (day >= 1) {
                val temp = growApples.peek() ?: break
                println("day = $day, mostApples = $mostApples" + ", temp[0] = ${temp[0]}, temp[1] = ${temp[1]}, temp[2] = ${temp[2]}")
                if (day >= temp[0] && day <= temp[1] && temp[2] > 0) {
                    temp[2] = temp[2] - 1
                    mostApples++
                    day--
                } else if (day < temp[0] || temp[2] <= 0) {
                    growApples.poll()
                } else if (temp[1] < day) {
                    day--
                }
            }
            return mostApples
        }

        fun eatenApplesWebSolution(apples: IntArray, days: IntArray): Int {
            val q: PriorityQueue<IntArray> = PriorityQueue { a, b -> a[1] - b[1] }

            var count = 0

            var i = 0
            while (i < apples.size || !q.isEmpty()) {
                if (i < apples.size && apples[i] != 0) {
                    q.add(intArrayOf(apples[i], i + days[i] - 1))
                }
                while (!q.isEmpty() && (q.peek()[0] == 0 || q.peek()[1] < i)) {
                    q.remove()
                }
                if (q.isEmpty()) {
                    i++
                    continue
                }
                val arr = q.poll()
                arr[0]--
                if (arr[0] > 0) {
                    q.add(arr)
                }
                count++
                i++
            }

            return count
        }
    }
}