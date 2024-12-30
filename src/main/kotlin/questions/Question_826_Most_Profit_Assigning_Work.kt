package questions

import java.util.*
import kotlin.math.max


class Question_826_Most_Profit_Assigning_Work {

    companion object {

        fun runQuestion() {
//            Input: difficulty = [68,35,52,47,86], profit = [67,17,1,81,3], worker = [92,10,85,84,82]
//            Output: 324
            val difficulty = intArrayOf(68, 35, 52, 47, 86)
            val profit = intArrayOf(67, 17, 1, 81, 3)
            val worker = intArrayOf(92, 10, 85, 84, 82)
            val result = maxProfitAssignment(difficulty, profit, worker)
            println("Question 826: $result")
        }

        fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
            val queue = PriorityQueue<IntArray> { a, b ->
                b[1] - a[1]
            }
            for (i in 0..difficulty.size - 1) {
                queue.add(intArrayOf(difficulty[i], profit[i]))
            }
            worker.sort()
            var ans = 0
            val worked = Array(worker.size) { false }
            while (!queue.isEmpty()) {
                val currentWork = queue.remove()
                for (i in 0..worker.size - 1) {
                    if (worked[i]) {
                        continue
                    }
                    if (worker[i] >= currentWork[0]) {
                        ans += currentWork[1]
                        worked[i] = true
                    }
                }
            }
            return ans
        }

        fun maxProfitAssignment2(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
            val works = Array(difficulty.size) { IntArray(2) { 0 } }
            for (i in 0..difficulty.size - 1) {
                works[i][0] = difficulty[i]
                works[i][1] = profit[i]
            }
            works.sortBy { it[0] }
            worker.sort()
            var ans = 0
            for (i in 0..worker.size - 1) {
                var best = 0
                var j = 0
                while (j <= works.size - 1 && worker[i] >= works[j][0]) {
                    best = max(best, works[j][1])
                    j++
                }
                ans += best
            }
            return ans
        }

        fun maxProfitAssignmentWithDp(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
            val result = IntArray(100001) { 0 }
            for (i in 0..difficulty.size - 1) {
                result[difficulty[i]] = max(result[difficulty[i]], profit[i])
            }
            for (i in 1..100000) {
                result[i] = max(result[i], result[i - 1])
            }
            var ans = 0
            for (i in 0..worker.size - 1) {
                ans += result[worker[i]]
            }
            return ans
        }
    }
}