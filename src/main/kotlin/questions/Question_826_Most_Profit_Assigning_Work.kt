package questions

import java.util.*


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
    }
}