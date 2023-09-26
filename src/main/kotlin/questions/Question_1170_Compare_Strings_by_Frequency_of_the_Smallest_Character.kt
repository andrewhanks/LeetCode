package questions

import models.TreeNode
import java.util.*


class Question_1170_Compare_Strings_by_Frequency_of_the_Smallest_Character {

    companion object {

        fun runQuestion() {
            // queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
            val queries: Array<String> = arrayOf("bbb", "cc")
            val words: Array<String> = arrayOf("a", "aa", "aaa", "aaaa")
            val resultList = numSmallerByFrequency(queries, words)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 1170: $result")
        }

        fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
            val queryAnsArray: IntArray = IntArray(queries.size) { 0 }
            val wordAnsArray: IntArray = IntArray(words.size) { 0 }
            queries.forEachIndexed { index, value ->
                val ans = value.toMutableList().sorted()
                println(ans)
                var count = 0
                var tempChar = ans[0]
                while (count <= ans.size - 1) {
                    if (tempChar == ans[count]) {
                        count++
                    } else {
                        break
                    }
                }
                queryAnsArray[index] = count
            }
            println(queryAnsArray.contentToString())
            words.forEachIndexed { index, value ->
                val ans = value.toMutableList().sorted()
                println(ans)
                var count = 0
                var tempChar = ans[0]
                while (count <= ans.size - 1) {
                    if (tempChar == ans[count]) {
                        count++
                    } else {
                        break
                    }
                }
                wordAnsArray[index] = count
            }
            println(wordAnsArray.contentToString())

            val resultArray: IntArray = IntArray(queries.size) { 0 }
            queryAnsArray.forEachIndexed { index1, value1 ->
                var count = 0
                wordAnsArray.forEach { value2 ->
                    if (value1 < value2) {
                        count++
                    }
                }
                resultArray[index1] = count
            }
            println(resultArray.contentToString())

            return resultArray
        }
    }
}