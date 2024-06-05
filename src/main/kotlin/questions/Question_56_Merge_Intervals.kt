package questions

import kotlin.math.max
import kotlin.math.min


class Question_56_Merge_Intervals {

    companion object {

        fun runQuestion() {
            val intArray = arrayOf(intArrayOf(2, 3), intArrayOf(1, 4))
            val resultList = merge(intArray)
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
            println("Question 56: $result")
        }

        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            intervals.sortBy { it[0] }
            val result: MutableList<IntArray> = mutableListOf()
            for (count in 0..intervals.size - 1) {
                if (count == 0) {
                    result.add(intervals[count])
                } else {
                    val lastIndex = result.size - 1
                    if (intervals[count][0] >= result[lastIndex][0] && intervals[count][0] <= result[lastIndex][1]) {
                        result[lastIndex][0] = min(result[lastIndex][0], intervals[count][0])
                        result[lastIndex][1] = max(result[lastIndex][1], intervals[count][1])
                    } else {
                        result.add(intervals[count])
                    }
                }
            }
            return result.toTypedArray()
        }

        fun mergeOldSolution(intervals: Array<IntArray>): Array<IntArray> {
            intervals.sortBy { it[0] }
            val result: MutableList<IntArray> = mutableListOf()
            result.add(intervals[0])
            for (count in 1..intervals.size - 1) {
                val current = intervals[count]
                var combined = false
                val compared = result[result.size - 1]
                if ((current[0] >= compared[0] && current[0] <= compared[1]) || (current[1] >= compared[0] && current[1] <= compared[1])) {
                    compared[0] = min(current[0], compared[0])
                    compared[1] = max(current[1], compared[1])
                    combined = true
                }
                if (!combined) {
                    result.add(intervals[count])
                }
            }
            return result.toTypedArray()
        }

        fun mergeSlow(intervals: Array<IntArray>): Array<IntArray> {
            intervals.sortWith(Comparator { a, b ->
                if (a[0] == b[0]) {
                    a[1] - b[1]
                } else {
                    a[0] - b[0]
                }
            })
            val result: MutableList<IntArray> = mutableListOf()
            for (count in 0..intervals.size - 1) {
                val current = intervals[count]
                var combined = false
                for (i in 0..result.size - 1) {
                    val compared = result[i]
                    if ((current[0] >= compared[0] && current[0] <= compared[1]) || (current[1] >= compared[0] && current[1] <= compared[1])) {
                        compared[0] = min(current[0], compared[0])
                        compared[1] = max(current[1], compared[1])
                        combined = true
                        break
                    }
                }
                if (!combined) {
                    result.add(intervals[count])
                }
            }
            return result.toTypedArray()
        }

        fun mergeOld(intervals: Array<IntArray>): Array<IntArray> {
            val result: MutableList<IntArray> = mutableListOf()
            intervals.sortBy { it[0] }
            result.add(intArrayOf(intervals[0][0], intervals[0][1]))
            for (count in 1..intervals.size - 1) {
                if (result[result.size - 1][1] >= intervals[count][0]) {
                    result[result.size - 1][1] = max(result[result.size - 1][1], intervals[count][1])
                } else {
                    result.add(intArrayOf(intervals[count][0], intervals[count][1]))
                }
            }
            return result.toTypedArray()
        }
    }
}