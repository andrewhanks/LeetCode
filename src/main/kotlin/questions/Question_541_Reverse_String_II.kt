package questions

class Question_541_Reverse_String_II {

    companion object {

        fun runQuestion() {
//            Input: s = "abcdefg", k = 2
//            Output: "bacdfeg"
            val s = "abcdefg"
            val k = 2
            val result = reverseStr(s, k)
            println("Question 541: $result")
        }

        fun reverseStr(s: String, k: Int): String {
            val result: StringBuilder = StringBuilder("")
            val splitted = s.chunked(k)
            for (count in 0..splitted.size - 1) {
                if (count % 2 == 0) {
                    result.append(splitted[count].reversed())
                } else {
                    result.append(splitted[count])
                }
            }
            return result.toString()
        }

        fun reverseStrManually(s: String, k: Int): String {
            val str = s.toCharArray()
            val n = str.size
            var i = 0
            while (i <= n - 1) {
                if (i + k - 1 <= n - 1) {
                    reverseK(i, i + k - 1, str)
                } else {
                    //for fewer than k characters left (edge case)
                    reverseK(i, n - 1, str)
                }
                i += 2 * k
            }
            val ans = String(str)
            return ans
        }

        fun reverseK(i: Int, j: Int, str: CharArray) {
            var i = i
            var j = j
            while (i < j) {
                val temp = str[i]
                str[i] = str[j]
                str[j] = temp
                i++
                j--
            }
        }
    }
}