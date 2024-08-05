package questions

import kotlin.math.max


class Question_916_Word_Subsets {

    companion object {

        fun runQuestion() {
//            Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
//            Output: ["facebook","google","leetcode"]
            val words1: Array<String> = arrayOf("amazon", "apple", "facebook", "google", "leetcode")
            val words2: Array<String> = arrayOf("e", "o")
            val result = wordSubsets(words1, words2)
            println("Question 916: $result")
        }

        fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
            val result: MutableList<String> = mutableListOf()
            val char = IntArray(26) { 0 }
            for (i in 0..words2.size - 1) {
                val temp = IntArray(26) { 0 }
                for (c in words2[i]) {
                    temp[c - 'a']++
                }
                for (j in 0..25) {
                    char[j] = max(char[j], temp[j])
                }
            }
            for (i in 0..words1.size - 1) {
                val temp = IntArray(26) { 0 }
                for (c in words1[i]) {
                    temp[c - 'a']++
                }
                var fit = true
                for (j in 0..25) {
                    if (temp[j] < char[j]) {
                        fit = false
                        break
                    }
                }
                if (fit) {
                    result.add(words1[i])
                }
            }
            return result
        }
    }
}