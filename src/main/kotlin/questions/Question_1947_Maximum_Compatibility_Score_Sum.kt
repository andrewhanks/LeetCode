package questions

import kotlin.math.max
import kotlin.math.pow


class Question_1947_Maximum_Compatibility_Score_Sum {

    companion object {

        fun runQuestion() {
//            Input: students = [[0,1,0,1,1,1],[1,0,0,1,0,1],[1,0,1,1,0,0]],
//                   mentors = [[1,0,0,0,0,1],[0,1,0,0,1,1],[0,1,0,0,1,1]]
//            Output: 10
            val students = arrayOf(
                intArrayOf(0, 1, 0, 1, 1, 1),
                intArrayOf(1, 0, 0, 1, 0, 1),
                intArrayOf(1, 0, 1, 1, 0, 0)
            )
            val mentors = arrayOf(
                intArrayOf(1, 0, 0, 0, 0, 1),
                intArrayOf(0, 1, 0, 0, 1, 1),
                intArrayOf(0, 1, 0, 0, 1, 1)
            )
            val result = maxCompatibilitySum(students, mentors)
            println("Question 1947: $result")
        }

        fun maxCompatibilitySum(students: Array<IntArray>, mentors: Array<IntArray>): Int {
            val size = students.size
            val number = students[0].size
            val result = Array(size) { IntArray(size) { 0 } }
            for (i in 0..size - 1) {
                for (j in 0..size - 1) {
                    var count = 0
                    for (k in 0..number - 1) {
                        if (students[i][k] == mentors[j][k]) {
                            count++
                        }
                    }
                    result[i][j] = count
                }
            }

            val occupied = Array(size) { false }
            var ans = 0
            for (i in 0..size.toFloat().pow(size).toInt() - 1) {
                var temp = i
                var score = 0
                for (count in 0..occupied.size - 1) {
                    occupied[count] = false
                }
                for (j in 0..size - 1) {
                    val rest = temp % size
                    temp = temp / size
                    if (occupied[rest]) {
                        break
                    }
                    score += result[j][rest]
                    occupied[rest] = true
                }
                ans = max(ans, score)
            }
            return ans
        }

        fun maxCompatibilitySumByDFS(students: Array<IntArray>, mentors: Array<IntArray>): Int {
            val size = students.size
            val number = students[0].size
            val match = Array(size) { IntArray(size) { 0 } }
            for (i in 0..size - 1) {
                for (j in 0..size - 1) {
                    var count = 0
                    for (k in 0..number - 1) {
                        if (students[i][k] == mentors[j][k]) {
                            count++
                        }
                    }
                    match[i][j] = count
                }
            }

            val occupied = Array(size) { false }
            val result = IntArray(1) { 0 }
            val temp: MutableList<Int> = mutableListOf()
            compute(match, result, temp, occupied, 0)
            return result[0]
        }

        fun compute(
            match: Array<IntArray>,
            result: IntArray,
            temp: MutableList<Int>,
            occupied: Array<Boolean>,
            index: Int
        ) {
            if (index >= match.size) {
                val sum = temp.sum()
                if (sum > result[0]) {
                    result[0] = sum
                }
                return
            }
            for (i in 0..match[index].size - 1) {
                if (occupied[i]) {
                    continue
                }
                temp.add(match[index][i])
                occupied[i] = true
                compute(match, result, temp, occupied, index + 1)
                temp.removeAt(temp.size - 1)
                occupied[i] = false
            }
        }
    }
}