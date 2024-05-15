package questions

class Question_1221_Split_a_String_in_Balanced_Strings {

    companion object {

        fun runQuestion() {
//            Input: s = "RLRRLLRLRL"
//            Output: 4
            val s = "RLRRLLRLRL"
            val result = balancedStringSplit(s)
            println("Question 1221: $result")
        }

        fun balancedStringSplit(s: String): Int {
            var result = 0
            var diff = 0
            for (count in 0..s.length - 1) {
                if (s[count] == 'R') {
                    diff++
                } else if (s[count] == 'L') {
                    diff--
                }
                if (diff == 0) {
                    result++
                }
            }
            return result
        }
    }
}