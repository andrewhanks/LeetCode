package questions

class Question_14_Longest_Common_Prefix {

    companion object {

        fun runQuestion14() {
            val stringArray = arrayOf("flower", "flow", "flight")
            val result = longestCommonPrefix(stringArray)
            println("Question 14: $result")
        }

        fun longestCommonPrefix(strs: Array<String>): String {
            if (strs.isEmpty()) {
                return ""
            }
            var longestCommonPrefix = ""
            var stringLengthMin = Int.MAX_VALUE
            strs.forEach {
                if (it.length < stringLengthMin) {
                    stringLengthMin = it.length
                }
            }
            if (0 == stringLengthMin) {
                return ""
            }
            for (count in 0..stringLengthMin - 1) {
                var isThisCharTheSame = true
                val thisRoundChar = strs[0][count]
                strs.forEach {
                    if (thisRoundChar != it[count]) {
                        isThisCharTheSame = false
                    }
                }
                if (isThisCharTheSame) {
                    longestCommonPrefix += thisRoundChar
                } else {
                    break
                }
            }
            return longestCommonPrefix
        }
    }
}