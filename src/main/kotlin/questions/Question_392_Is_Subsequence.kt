package questions

class Question_392_Is_Subsequence {

    companion object {

        fun runQuestion() {
//            Input: s = "abc", t = "ahbgdc"
//            Output: true
            val s = "abc"
            val t = "ahbgdc"
            val result = isSubsequence(s, t)
            println("Question 392: $result")
        }

        fun isSubsequence(s: String, t: String): Boolean {
            if (s.length == 0) {
                return true
            }
            var previous = t.indexOf(s[0])
            if (previous == -1) {
                return false
            }
            for (count in 1..s.length - 1) {
                val current = t.substring(previous + 1..t.length - 1).indexOf(s[count]) + previous + 1
                println("previous = $previous, current = $current")
                if (current <= previous) {
                    return false
                }
                previous = current
            }
            return true
        }
    }
}