package questions

class Question_1358_Number_of_Substrings_Containing_All_Three_Characters {

    companion object {

        fun runQuestion() {
//            Input: s = "abcabc"
//            Output: 10
            val inputString = "abcabc"
            val result = numberOfSubstrings(inputString)
            println("Question 1358: $result")
        }

        fun numberOfSubstrings(s: String): Int {
            var countA = 0
            var countB = 0
            var countC = 0
            var right = 0
            var ans = 0
            for (left in 0..s.length - 1) {
                while (right <= s.length - 1 && (countA < 1 || countB < 1 || countC < 1)) {
                    if (s[right] == 'a') {
                        countA++
                    } else if (s[right] == 'b') {
                        countB++
                    } else {
                        countC++
                    }
                    right++
                }
                if (countA < 1 || countB < 1 || countC < 1) {
                    break
                }
                ans += (s.length - right + 1)
                if (s[left] == 'a') {
                    countA--
                } else if (s[left] == 'b') {
                    countB--
                } else {
                    countC--
                }
            }
            return ans
        }
    }
}