package questions

import kotlin.math.max
import kotlin.math.min


class Question_57_Insert_Interval {

    companion object {

        fun runQuestion() {
//            Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//            Output: [[1,5],[6,9]]
            val intArray = arrayOf(intArrayOf(1, 3), intArrayOf(6, 9))
            val insertInterval = intArrayOf(2, 5)
            val resultList = insert(intArray, insertInterval)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            if (']' != result.last()) {
                result += "]"
            }
            println("Question 57: $result")
        }

        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            val result: MutableList<IntArray> = mutableListOf()
            var added = false
            for (count in 0..intervals.size - 1) {
                if (intervals[count][1] < newInterval[0]) {
                    result.add(intervals[count])
                } else if (intervals[count][0] > newInterval[1]) {
                    if (!added) {
                        added = true
                        result.add(newInterval)
                    }
                    result.add(intervals[count])
                } else {
                    newInterval[0] = min(newInterval[0], intervals[count][0])
                    newInterval[1] = max(newInterval[1], intervals[count][1])
                }
            }
            if (!added) {
                result.add(newInterval)
            }
            return result.toTypedArray()
        }

        fun insertInsertToOriginalArray(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            val newIntervals = intervals.toMutableList()
            val result: MutableList<IntArray> = mutableListOf()
            newIntervals.add(newInterval)
            newIntervals.sortBy { it[0] }
            result.add(intArrayOf(newIntervals[0][0], newIntervals[0][1]))
            for (count in 1..newIntervals.size - 1) {
                if (result[result.size - 1][1] >= newIntervals[count][0]) {
                    result[result.size - 1][1] = max(result[result.size - 1][1], newIntervals[count][1])
                } else {
                    result.add(intArrayOf(newIntervals[count][0], newIntervals[count][1]))
                }
            }
            return result.toTypedArray()
        }

        fun insertStupid(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            val result: MutableList<IntArray> = mutableListOf()
            if (intervals.size == 0) {
                return Array(1) { newInterval }
            }
            var inserted = false
            intervals.forEachIndexed { index, value ->
                if ((newInterval[0] >= value[0] && newInterval[0] <= value[1]) || (newInterval[1] >= value[0] && newInterval[1] <= value[1]) ||
                    (newInterval[0] <= value[0] && newInterval[1] >= value[1])
                ) {
                    val tempArray = intArrayOf(value[0], value[1])
                    tempArray[0] = min(newInterval[0], value[0])
                    tempArray[1] = max(newInterval[1], value[1])
                    println(tempArray[0].toString() + " " + tempArray[1].toString())
                    if (result.size > 0 && ((tempArray[0] >= result[result.size - 1][0] && tempArray[0] <= result[result.size - 1][1]) ||
                                (tempArray[1] >= result[result.size - 1][0] && tempArray[1] <= result[result.size - 1][1]) ||
                                (tempArray[0] <= result[result.size - 1][0] && tempArray[1] >= result[result.size - 1][1]))
                    ) {
                        if (result[result.size - 1][0] > tempArray[0]) {
                            result[result.size - 1][0] = tempArray[0]
                        }
                        if (result[result.size - 1][1] < tempArray[1]) {
                            result[result.size - 1][1] = tempArray[1]
                        }
                    } else {
                        result.add(tempArray)
                    }
                    inserted = true
                } else {
                    result.add(value)
                }
            }
            if (!inserted) {
                result.add(newInterval)
                result.sortBy { it[0] }
            }
            return result.toTypedArray()
        }
    }
}