package questions

class Question_242_Valid_Anagram {

    companion object {

        fun runQuestion() {
//            Input: s = "anagram", t = "nagaram"
//            Output: true
            val s = "anagram"
            val t = "nagaram"
            val result = isAnagram(s, t)
            println("Question 242: $result")
        }

        fun isAnagram(s: String, t: String): Boolean {
            if (s.toMutableList().sorted() == t.toMutableList().sorted()) {
                return true
            } else {
                return false
            }
        }
    }
}