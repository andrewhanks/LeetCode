package questions

import kotlin.math.max
import kotlin.math.min

class Question_2024_Maximize_the_Confusion_of_an_Exam {

    companion object {

        fun runQuestion() {
//            Input: answerKey = "TTFTTFTT", k = 1
//            Output: 5
            val answerKey = "TTFTTFTT"
            val k = 1
            val result = maxConsecutiveAnswers(answerKey, k)
            println("Question 2024: $result")
        }

        fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
            var left = 0
            var max = 0
            var countT = 0
            var countF = 0
            for (right in 0..answerKey.length - 1) {
                if (answerKey[right] == 'T') {
                    countT++
                } else {
                    countF++
                }
                if (min(countT, countF) > k) {
                    if (answerKey[left] == 'T') {
                        countT--
                    } else {
                        countF--
                    }
                    left++
                } else {
                    max = max(max, right - left + 1)
                }
            }
            return max
        }

        fun maxConsecutiveAnswersWithTAndFSeparately(answerKey: String, k: Int): Int {
            var max = 0
            var right = 0
            var count = 0
            for (left in 0..answerKey.length - 1) {
                while (right <= answerKey.length - 1 && (answerKey[right] == 'T' || count < k)) {
                    if (answerKey[right] == 'F') {
                        count++
                    }
                    right++
                }
                max = max(max, right - left)
                if (answerKey[left] == 'F') {
                    count--
                }
            }
            right = 0
            count = 0
            for (left in 0..answerKey.length - 1) {
                while (right <= answerKey.length - 1 && (answerKey[right] == 'F' || count < k)) {
                    if (answerKey[right] == 'T') {
                        count++
                    }
                    right++
                }
                max = max(max, right - left)
                if (answerKey[left] == 'T') {
                    count--
                }
            }
            return max
        }
    }
}