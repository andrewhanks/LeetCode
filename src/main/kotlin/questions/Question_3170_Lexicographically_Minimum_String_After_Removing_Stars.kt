package questions

class Question_3170_Lexicographically_Minimum_String_After_Removing_Stars {

    companion object {

        fun runQuestion() {
//            Input: s = "aaba*"
//            Output: "aab"
            val s = "aaba*"
            val result = clearStars(s)
            println("Question 3170: $result")
        }

        fun clearStars(s: String): String {
            val content: Array<MutableList<Int>> = Array(26) { mutableListOf() }
            val removed = Array(s.length) { false }
            val result = StringBuilder()
            var i = 0
            while (i <= s.length - 1) {
                if (s[i] == '*') {
                    var j = 0
                    while (j < content.size - 1) {
                        // println("content[$j] = ${content[j]}")
                        if (content[j].size > 0) {
                            break
                        }
                        j++
                    }
                    val pos = content[j].removeAt(content[j].size - 1)
                    removed[pos] = true
                    removed[i] = true
                } else {
                    content[s[i].toInt() - 'a'.toInt()].add(i)
                    // println("stringBuilder[$i].toInt() = ${stringBuilder[i].toInt()}, 'a'.toInt() = ${'a'.toInt()}")
                }
                i++
            }
            for (count in 0..removed.size - 1) {
                if (!removed[count]) {
                    result.append(s[count])
                }
            }
            return result.toString()
        }
    }
}