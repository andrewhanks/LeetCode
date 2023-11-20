package questions

class Question_290_Word_Pattern {

    companion object {

        fun runQuestion() {
//            Input: pattern = "abba", s = "dog cat cat dog"
//            Output: true
            val pattern = "abba"
            val s = "dog cat cat dog"
            val result = wordPattern(pattern, s)
            println("Question 290: $result")
        }

        fun wordPattern(pattern: String, s: String): Boolean {
            val result: MutableMap<Char, String> = mutableMapOf()
            val stringList = s.split(" ")
            if (stringList.size != pattern.length) {
                return false
            }
            for (count in 0..pattern.length - 1) {
                if (result.contains(pattern[count])) {
                    if (result[pattern[count]] != stringList[count]) {
                        return false
                    }
                } else {
                    for ((key, value) in result) {
                        if (value == stringList[count]) {
                            return false
                        }
                    }
                    result.put(pattern[count], stringList[count])
                }
            }
            return true
        }
    }
}