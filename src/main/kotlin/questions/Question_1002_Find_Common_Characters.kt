package questions

import kotlin.math.min


class Question_1002_Find_Common_Characters {

    companion object {

        fun runQuestion() {
//            Input: words = ["bella","label","roller"]
//            Output: ["e","l","l"]
            val words = arrayOf("bella", "label", "roller")
            val result = commonChars(words)
            println("Question 1002: $result")
        }

        fun commonChars(words: Array<String>): List<String> {
            val result: MutableMap<String, Int> = mutableMapOf()
            for (count in 0..words[0].length - 1) {
                val resultString = words[0][count].toString()
                if (!result.contains(resultString)) {
                    result.put(resultString, 1)
                } else {
                    result[resultString] = result[resultString]!! + 1
                }
            }
            for (count in 1..words.size - 1) {
                for ((key, value) in result) {
                    if (!words[count].contains(key)) {
                        result[key] = 0
                    } else {
                        val wordsContain = words[count].filter { it.toString() == key }.count()
                        val resultContain = value
                        if (wordsContain < resultContain) {
                            result[key] = wordsContain
                        }
                    }
                }
            }
            val finalList: MutableList<String> = mutableListOf()
            for ((key, value) in result) {
                if (value != 0) {
                    for (count in 0..value - 1) {
                        finalList.add(key)
                    }
                }
            }
            return finalList
        }

        fun commonCharsWithAlphabetArray(words: Array<String>): List<String> {
            val last = count(words[0])
            for (wordCount in 1..words.size - 1) {
                val temp = count(words[wordCount])
                for (count in 0..25) {
                    last[count] = min(last[count], temp[count])
                }
            }
            val result: MutableList<String> = mutableListOf()
            for (count in 0..25) {
                for (times in 0..last[count] - 1) {
                    var tempWord = 'a'
                    tempWord += count
                    result.add(tempWord.toString())
                }
            }
            return result
        }

        fun count(input: String): IntArray {
            val savedWords = IntArray(26)
            for (count in 0..input.length - 1) {
                savedWords[input[count] - 'a']++
            }
            return savedWords
        }
    }
}