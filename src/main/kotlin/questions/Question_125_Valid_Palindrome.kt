package questions

class Question_125_Valid_Palindrome {

    companion object {

        fun runQuestion() {
//            Input: s = "A man, a plan, a canal: Panama"
//            Output: true
            val s = "A man, a plan, a canal: Panama"
            val result = isPalindrome(s)
            println("Question 125: $result")
        }

        fun isPalindromeReplaceCharacter(s: String): Boolean {
            if (s.trim().isEmpty()) {
                return true
            }
            val re = Regex("[^A-Za-z0-9]")
            val trimmedS = re.replace(s, "").toLowerCase()
            var start = 0
            var end = trimmedS.length - 1
            while (start < end) {
                if (trimmedS[start] != trimmedS[end]) {
                    return false
                }
                start += 1
                end -= 1
            }
            return true
        }

        fun isPalindrome(s: String): Boolean {
            if (s.trim().isEmpty()) {
                return true
            }
            var start = 0
            var last = s.length - 1
            while (start <= last) {
                val currFirst = s[start]
                val currLast = s[last]
                if (!Character.isLetterOrDigit(currFirst)) {
                    start++
                } else if (!Character.isLetterOrDigit(currLast)) {
                    last--
                } else {
                    if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                        return false
                    }
                    start++
                    last--
                }
            }
            return true
        }
    }
}