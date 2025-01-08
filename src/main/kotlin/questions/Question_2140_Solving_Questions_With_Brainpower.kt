package questions

import kotlin.math.max


class Question_2140_Solving_Questions_With_Brainpower {

    companion object {

        fun runQuestion() {
//            Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
//            Output: 7
            val questions =
                arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3), intArrayOf(4, 4), intArrayOf(5, 5))
            val result = mostPoints(questions)
            println("Question 2140: $result")
        }

        fun mostPoints(questions: Array<IntArray>): Long {
            val result = LongArray(questions.size) { -1L }
            return dp(questions, 0, result)
        }

        fun dp(questions: Array<IntArray>, index: Int, result: LongArray): Long {
            if (index >= questions.size) {
                return 0
            }
            if (result[index] != -1L) {
                return result[index]
            }
            val pick = questions[index][0].toLong() + dp(questions, index + questions[index][1] + 1, result)
            val notPick = dp(questions, index + 1, result)
            result[index] = max(pick, notPick)
            return result[index]
        }
    }
}