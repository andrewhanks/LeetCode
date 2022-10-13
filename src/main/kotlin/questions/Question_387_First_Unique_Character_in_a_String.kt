package questions

class Question_387_First_Unique_Character_in_a_String {

    companion object {

        fun runQuestion() {
            val input = "aabb"
            val result = firstUniqChar(input)
            println("Question 387: $result")
        }

        fun firstUniqChar(s: String): Int {
            var isRepeatWord: Boolean
            val repeatWordArray = BooleanArray(s.length) { false }
            for (i in 0..s.length - 1) {
                if (repeatWordArray[i]) {
                    continue
                }
                isRepeatWord = false
                for (j in i + 1..s.length - 1) {
                    if (s[i] == s[j]) {
                        repeatWordArray[i] = true
                        repeatWordArray[j] = true
                        isRepeatWord = true
                    }
                }
                if (!isRepeatWord) {
                    return i
                }
            }
            return -1
        }
    }
}