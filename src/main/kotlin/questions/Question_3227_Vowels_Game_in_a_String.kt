package questions

class Question_3227_Vowels_Game_in_a_String {

    companion object {

        fun runQuestion() {
//            Input: s = "leetcoder"
//            Output: true
            val s = "leetcoder"
            val result = doesAliceWin(s)
            println("Question 3227: $result")
        }

        fun doesAliceWin(s: String): Boolean {
            if (vowelsNumber(s) == 0) {
                return false
            } else {
                return true
            }
        }

        fun vowelsNumber(str: String): Int {
            var ans = 0
            for (count in 0..str.length - 1) {
                if (str[count] == 'a' || str[count] == 'e' || str[count] == 'i' || str[count] == 'o' || str[count] == 'u') {
                    ans++
                }
            }
            return ans
        }
    }
}