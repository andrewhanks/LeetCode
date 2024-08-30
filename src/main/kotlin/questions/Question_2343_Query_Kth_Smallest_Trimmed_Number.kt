package questions

import java.util.*


class Question_2343_Query_Kth_Smallest_Trimmed_Number {

    companion object {

        fun runQuestion() {
//            Input: nums = ["102","473","251","814"], queries = [[1,1],[2,3],[4,2],[1,2]]
//            Output: [2,2,1,0]
            val nums = arrayOf("102", "473", "251", "814")
            val queries = arrayOf(intArrayOf(1, 1), intArrayOf(2, 3), intArrayOf(4, 2), intArrayOf(1, 2))
            val result = smallestTrimmedNumbers(nums, queries)
            println("Question 2343: ${result.contentToString()}")
        }

        fun smallestTrimmedNumbers(nums: Array<String>, queries: Array<IntArray>): IntArray {
            val result = IntArray(queries.size) { 0 }
            for (i in 0..queries.size - 1) {
                val order = queries[i][0]
                val digits = queries[i][1]
                val priorityQueue: PriorityQueue<Pair<Int, String>> = PriorityQueue { a, b ->
                    val ret = a.second.compareTo(b.second)
                    if (ret != 0) {
                        ret
                    } else {
                        a.first - b.first
                    }
                }
                for (j in 0..nums.size - 1) {
                    val number = StringBuilder()
                    if (digits < nums[j].length) {
                        for (k in nums[j].length - digits..nums[j].length - 1) {
                            number.append(nums[j][k])
                        }
                    } else {
                        number.append(nums[j])
                    }
                    priorityQueue.add(Pair(j, number.toString()))
                }
                for (count in 0..order - 1) {
                    result[i] = priorityQueue.remove().first
                }
            }
            return result
        }

        fun smallestTrimmedNumbersWithArray(nums: Array<String>, queries: Array<IntArray>): IntArray {
            val result = IntArray(queries.size) { 0 }
            for (i in 0..queries.size - 1) {
                val order = queries[i][0]
                val digits = queries[i][1]
                val priorityQueue: PriorityQueue<Array<String>> = PriorityQueue { a, b ->
                    var ret = 0
                    for (count in 0..a[1].length - 1) {
                        ret = a[1][count] - b[1][count]
                        if (ret != 0) {
                            break
                        }
                    }
                    if (ret != 0) {
                        ret
                    } else {
                        a[0].toInt() - b[0].toInt()
                    }
                }
                for (j in 0..nums.size - 1) {
                    val number = StringBuilder()
                    if (digits < nums[j].length) {
                        for (k in nums[j].length - digits..nums[j].length - 1) {
                            number.append(nums[j][k])
                        }
                    } else {
                        number.append(nums[j])
                    }
                    priorityQueue.add(arrayOf(j.toString(), number.toString()))
                }
                for (count in 0..order - 1) {
                    result[i] = priorityQueue.remove()[0].toInt()
                }
            }
            return result
        }
    }
}