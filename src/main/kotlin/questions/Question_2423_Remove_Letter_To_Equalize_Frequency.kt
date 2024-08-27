package questions

import kotlin.math.max
import kotlin.math.min

class Question_2423_Remove_Letter_To_Equalize_Frequency {

    companion object {

        fun runQuestion() {
//            Input: word = "abcc"
//            Output: true
            val word = "abcc"
            val result = equalFrequency(word)
            println("Question 2423: $result")
        }

        fun equalFrequency(word: String): Boolean {
            var finalAns = false
            for (i in 0..word.length - 1) {
                val result = IntArray(26) { 0 }
                for (j in 0..word.length - 1) {
                    if (i == j) {
                        continue
                    }
                    result[word[j] - 'a']++
                }
                var hasFreq = -1
                var ans = true
                for (j in 0..result.size - 1) {
                    if (result[j] == 0) {
                        continue
                    }
                    if (hasFreq == -1) {
                        hasFreq = result[j]
                    } else {
                        if (hasFreq != result[j]) {
                            ans = false
                        }
                    }
                }
                finalAns = finalAns || ans
            }
            return finalAns
        }

        fun equalFrequencyWithCheckingByMinAndMax(word: String): Boolean {
            val result = IntArray(26) { 0 }
            for (count in 0..word.length - 1) {
                result[word[count] - 'a']++
            }
            for (i in 0..result.size - 1) {
                if (result[i] <= 0) {
                    continue
                }
                result[i]--
                if (areAllFreqTheSame(result)) {
                    return true
                }
                result[i]++
            }
            return false
        }

        fun areAllFreqTheSame(result: IntArray): Boolean {
            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE
            for (count in 0..result.size - 1) {
                if (result[count] <= 0) {
                    continue
                }
                min = min(min, result[count])
                max = max(max, result[count])
            }
            // println("min = $min, max = $max")
            return min == max
        }
    }
}