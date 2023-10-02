package questions

import kotlin.math.max


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