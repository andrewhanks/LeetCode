package questions

import kotlin.math.pow


class Question_2217_Find_Palindrome_With_Fixed_Length {

    companion object {

        fun runQuestion() {
//            Input: queries = [1,2,3,4,5,90], intLength = 3
//            Output: [101,111,121,131,141,999]
            val queries = intArrayOf(1, 2, 3, 4, 5, 90)
            val intLength = 3
            val result = kthPalindrome(queries, intLength)
            println("Question 2217: ${result.contentToString()}")
        }

        fun kthPalindrome(queries: IntArray, intLength: Int): LongArray {
            val answers = LongArray(queries.size) { 0L }
            for (i in 0..queries.size - 1) {
                var firstHalf = if (intLength % 2 == 0) {
                    intLength / 2
                } else {
                    intLength / 2 + 1
                }
                val query = queries[i]
                val maxHalf = StringBuilder()
                for (i in 0..firstHalf - 1) {
                    maxHalf.append("9")
                }
                val minHalf = StringBuilder()
                for (i in 0..firstHalf - 1) {
                    minHalf.append("0")
                }
                minHalf[0] = '1'
                if (query > maxHalf.toString().toInt() - minHalf.toString().toInt() + 1) {
                    answers[i] = -1
                } else {
                    if (intLength % 2 == 0) {
                        val left = (minHalf.toString().toInt() + query - 1).toString()
                        val right = left.reversed()
                        answers[i] = (left + right).toLong()
                    } else {
                        val left = (minHalf.toString().toInt() + query - 1).toString()
                        val right = left.reversed()
                        answers[i] = (left.substring(0..left.length - 2) + right).toLong()
                    }
                }
            }
            return answers
        }

        fun kthPalindromeUsingNumberDirectly(queries: IntArray, intLength: Int): LongArray {
            val answers = LongArray(queries.size) { 0L }
            for (i in 0..queries.size - 1) {
                val firstHalf = if (intLength % 2 == 0) {
                    intLength / 2
                } else {
                    intLength / 2 + 1
                }
                val query = queries[i]
                var maxHalf = 9L
                for (j in 0..firstHalf - 2) {
                    maxHalf = maxHalf * 10 + 9
                }
                var minHalf = 1L
                for (j in 0..firstHalf - 2) {
                    minHalf = minHalf * 10
                }
                // println("maxHalf = $maxHalf, minHalf = $minHalf")
                if (query > maxHalf - minHalf + 1) {
                    answers[i] = -1
                } else {
                    if (intLength % 2 == 0) {
                        val left = minHalf + query - 1
                        var right = 0L
                        var temp = left
                        var pow = 0
                        while (temp > 0) {
                            right = right * 10 + temp % 10
                            temp = temp / 10
                            pow++
                        }
                        // println("intLength%2==0, left = $left, right = $right, pow = $pow")
                        answers[i] = (left * (10.0).pow(pow) + right).toLong()
                    } else {
                        val left = minHalf + query - 1
                        var right = 0L
                        var temp = left / 10
                        var pow = 0
                        while (temp > 0) {
                            right = right * 10 + temp % 10
                            temp = temp / 10
                            pow++
                        }
                        // println("intLength%2==1, left = $left, right = $right, pow = $pow")
                        answers[i] = (left * (10.0).pow(pow) + right).toLong()
                    }
                }
            }
            return answers
        }
    }
}