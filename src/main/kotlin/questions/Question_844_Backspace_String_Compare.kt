package questions

class Question_844_Backspace_String_Compare {

    companion object {

        fun runQuestion() {
//            Input: s = "ab#c", t = "ad#c"
//            Output: true
            val s = "ab#c"
            val t = "ad#c"
            val result = backspaceCompare(s, t)
            println("Question 844: $result")
        }

        fun backspaceCompare(s: String, t: String): Boolean {
            var tempS: StringBuilder = StringBuilder("")
            var tempT: StringBuilder = StringBuilder("")
            for (count in 0..s.length - 1) {
                if (s[count] != '#') {
                    tempS.append(s[count])
                } else if (s[count] == '#' && tempS.length >= 1) {
                    tempS.deleteAt(tempS.length - 1)
                }
            }
            for (count in 0..t.length - 1) {
                if (t[count] != '#') {
                    tempT.append(t[count])
                } else if (t[count] == '#' && tempS.length >= 1) {
                    tempT.deleteAt(tempT.length - 1)
                }
            }

            return tempS.toString() == tempT.toString()
        }
    }
}