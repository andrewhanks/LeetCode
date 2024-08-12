package questions

class Question_820_Short_Encoding_of_Words {

    companion object {

        fun runQuestion() {
//            Input: words = ["time", "me", "bell"]
//            Output: 10
            val words = arrayOf("time", "me", "bell")
            val result = minimumLengthEncoding(words)
            println("Question 820: $result")
        }

        fun minimumLengthEncoding(words: Array<String>): Int {
            val temp = words.sortedByDescending { it.length }.toMutableList()
            var i = 0
            while (i <= temp.size - 1) {
                var j = i + 1
                while (j <= temp.size - 1) {
                    if (temp[i].endsWith(temp[j])) {
                        temp.removeAt(j)
                    } else {
                        j++
                    }
                }
                i++
            }
            // println("temp = $temp")
            var total = 0
            for (count in 0..temp.size - 1) {
                total += temp[count].length
            }
            return total + temp.size
        }

        fun minimumLengthEncodingAnotherSolution(words: Array<String>): Int {
            words.sortByDescending { it.length }
            val stringBuilder = StringBuilder()
            for (count in 0..words.size - 1) {
                if (stringBuilder.indexOf(words[count] + "#") >= 0) {
                } else {
                    stringBuilder.append(words[count] + "#")
                }
            }
            return stringBuilder.length
        }
    }
}