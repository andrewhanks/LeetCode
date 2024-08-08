package questions

class Question_1332_Remove_Palindromic_Subsequences {

    companion object {

        fun runQuestion() {
//            Input: s = "ababa"
//            Output: 1
            val inputString = "ababa"
            val result = removePalindromeSub(inputString)
            println("Question 1332: $result")
        }

        fun removePalindromeSub(s: String): Int {
            if (isPalidrome(s)) {
                return 1
            }
            return 2
        }

        fun removePalindromeSubWithNotNecessaryCheck(s: String): Int {
            if (isPalidrome(s)) {
                return 1
            }
            var numA = 0
            var numB = 0
            for (count in 0..s.length - 1) {
                if (s[count] == 'a') {
                    numA++
                } else {
                    numB++
                }
            }
            if (numA != 0 && numB != 0) {
                return 2
            } else {
                return 1
            }
        }

        fun isPalidrome(s: String): Boolean {
            var i = 0
            var j = s.length - 1
            while (i < j) {
                if (s[i] != s[j]) {
                    return false
                }
                i++
                j--
            }
            return true
        }
    }
}