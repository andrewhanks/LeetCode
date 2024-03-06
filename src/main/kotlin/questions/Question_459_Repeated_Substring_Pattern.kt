package questions

class Question_459_Repeated_Substring_Pattern {

    companion object {

        fun runQuestion() {
//            Input: s = "abcabcabcabc"
//            Output: true
            val s = "abcabcabcabc"
            val result = repeatedSubstringPattern(s)
            println("Question 459: $result")
        }

        fun repeatedSubstringPattern(s: String): Boolean {
            for (count in 0..s.length - 2) {
                val filterString = s.substring(0..count)
                val splitted = s.split(filterString)
                if (splitted.size == splitted.filter { it.isEmpty() }.count()) {
                    return true
                }
            }
            return false
        }

        fun repeatedSubstringPatternSpecialWay(s: String): Boolean {
            val combined = s + s
            if (combined.substring(1..combined.length - 2).contains(s)) {
                return true
            } else {
                return false
            }
        }
    }
}