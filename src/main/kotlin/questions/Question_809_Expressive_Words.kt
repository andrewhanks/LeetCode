package questions

class Question_809_Expressive_Words {

    companion object {

        fun runQuestion() {
//            Input: s = "heeellooo", words = ["hello", "hi", "helo"]
//            Output: 1
            val words = arrayOf("hello", "hi", "helo")
            val s = "heeellooo"
            val result = expressiveWords(s, words)
            println("Question 809: $result")
        }

        fun expressiveWords(s: String, words: Array<String>): Int {
            val resultKeyList: MutableList<Char> = mutableListOf()
            val resultValueList: MutableList<Int> = mutableListOf()
            var ans = 0
            for (count in 0..s.length - 1) {
                val char = s[count]
                if (resultKeyList.size == 0 || resultKeyList[resultKeyList.size - 1] != char) {
                    resultKeyList.add(char)
                    resultValueList.add(1)
                } else {
                    resultValueList[resultValueList.size - 1] = resultValueList[resultValueList.size - 1]!! + 1
                }
            }
            // println("resultKeyList = $resultKeyList, resultValueList = $resultValueList")
            for (i in 0..words.size - 1) {
                val tempKeyList: MutableList<Char> = mutableListOf()
                val tempValueList: MutableList<Int> = mutableListOf()
                for (count in 0..words[i].length - 1) {
                    val char = words[i][count]
                    if (tempKeyList.size == 0 || tempKeyList[tempKeyList.size - 1] != char) {
                        tempKeyList.add(char)
                        tempValueList.add(1)
                    } else {
                        tempValueList[tempValueList.size - 1] = tempValueList[tempValueList.size - 1]!! + 1
                    }
                }
                // println("tempKeyList = $tempKeyList, tempValueList = $tempValueList")
                var keyMatch = true
                for (count in 0..resultKeyList.size - 1) {
                    if (resultKeyList.size != tempKeyList.size) {
                        keyMatch = false
                        break
                    }
                    if (resultKeyList[count] != tempKeyList[count]) {
                        keyMatch = false
                        break
                    }
                }
                if (keyMatch) {
                    var valueMatch = true
                    for (count in 0..resultValueList.size - 1) {
                        if (resultValueList[count] >= 3) {
                            if (tempValueList[count] > resultValueList[count]) {
                                valueMatch = false
                                break
                            }
                        } else {
                            if (tempValueList[count] != resultValueList[count]) {
                                valueMatch = false
                                break
                            }
                        }
                    }
                    if (valueMatch) {
                        ans++
                    }
                }
            }
            return ans
        }
    }
}