package questions

class Question_3029_Minimum_Time_to_Revert_Word_to_Initial_State_I {

    companion object {

        fun runQuestion() {
//            Input: word = "abacaba", k = 3
//            Output: 2
            val word = "abacaba"
            val k = 3
            val result = minimumTimeToInitialState(word, k)
            println("Question 3029: $result")
        }

        fun minimumTimeToInitialState(word: String, k: Int): Int {
            var temp = word
            var ans = 0
            while (temp.length > 0) {
                if (temp.length < k) {
                    ans++
                    break
                }
                temp = temp.substring(k..temp.length - 1)
                ans++
                if (word.startsWith(temp)) {
                    break
                }
            }
            return ans
        }
    }
}