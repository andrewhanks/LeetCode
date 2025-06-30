package questions

import kotlin.math.max
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
            val dayType = intArrayOf(1, 7, 30)
            val dp = IntArray(days[days.size - 1] + 1) { 0 }
            for (i in 1..dp.size - 1) {
                if (!days.contains(i)) {
                    dp[i] = dp[i - 1]
                    continue
                }
                var min = Int.MAX_VALUE
                for (j in 0..costs.size - 1) {
                    if (dayType[j] >= i) {
                        min = min(min, costs[j])
                    } else {
                        min = min(min, dp[i - dayType[j]] + costs[j])
                    }
                }
                dp[i] = min
            }
            return dp[dp.size - 1]
        }

        fun mincostTicketsOldSolution(days: IntArray, costs: IntArray): Int {
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

        fun mincostTicketsAnotherSolution(days: IntArray, costs: IntArray): Int {
            val result = IntArray(days[days.size - 1] + 1) { 0 }
            val set: MutableSet<Int> = mutableSetOf()
            val periods = intArrayOf(1, 7, 30)
            for (count in 0..days.size - 1) {
                set.add(days[count])
            }
            for (count in 1..result.size - 1) {
                if (!set.contains(count)) {
                    result[count] = result[count - 1]
                    continue
                }
                var min = Int.MAX_VALUE
                for (kind in 0..costs.size - 1) {
                    val day = max(0, count - periods[kind])
                    min = min(min, result[day] + costs[kind])
                }
                result[count] = min
            }
            return result[result.size - 1]
        }
    }
}