package questions

import kotlin.math.min


class Question_983_Minimum_Cost_For_Tickets {

    companion object {

        fun runQuestion() {
//            Input: days = [1,4,6,7,8,20], costs = [2,7,15]
//            Output: 11
            val days = intArrayOf(1, 4, 6, 7, 8, 20)
            val costs = intArrayOf(2, 7, 15)
            val result = mincostTickets(days, costs)
            println("Question 983: $result")
        }

        fun mincostTickets(days: IntArray, costs: IntArray): Int {
            val dayList = days.toMutableList()
            dayList.add(0, 0)
            val result = IntArray(dayList.size) { 0 }
            val periods = intArrayOf(1, 7, 30)
            for (i in 1..result.size - 1) {
                var min = 1000000
                for (j in 0..periods.size - 1) {
                    var prevDay = i - 1
                    for (k in i - 1 downTo 0) {
                        if (dayList[i] - dayList[k] < periods[j]) {
                            prevDay = k - 1
                            if (prevDay == -1) {
                                prevDay = 0
                            }
                        } else {
                            break
                        }
                    }
                    // println("i = $i, periods[$j] = ${periods[j]}, prevDay = $prevDay")
                    min = min(min, result[prevDay] + costs[j])
                }
                result[i] = min
            }
            // println("result = ${result.contentToString()}")
            return result[result.size - 1]
        }
    }
}