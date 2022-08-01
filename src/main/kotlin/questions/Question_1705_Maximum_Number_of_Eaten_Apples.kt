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
            // 0: max stored days, 1: apple numbers
            val growApples: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                a[0] - b[0]
            }
            if (days.isEmpty()) {
                return 0
            }
            var day = 0
            var mostApples = 0
            var maxStoreDay = days[0]
            while (day <= apples.size - 1 || day <= maxStoreDay) {
                if (day <= apples.size - 1 && apples[day] != 0) {
                    growApples.add(intArrayOf(days[day] + day, apples[day]))
                }
                while (growApples.peek() != null && (growApples.peek()[1] <= 0 || growApples.peek()[0] <= day)) {
                    growApples.remove()
                }
                if (growApples.peek() == null) {
                    day++
                } else {
                    val temp = growApples.peek()
                    if (day < temp[0]) {
                        temp[1] = temp[1] - 1
                        mostApples++
                        day++
                    }
                    if (maxStoreDay < temp[0]) {
                        maxStoreDay = temp[0]
                    }
                }
            }
            return mostApples
        }

        fun eatenApplesWebSolution(apples: IntArray, days: IntArray): Int {
            // 0: number of apples, 1: max stored day
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