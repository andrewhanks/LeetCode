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

        fun isAnagramSort(s: String, t: String): Boolean {
            if (s.toMutableList().sorted() == t.toMutableList().sorted()) {
                return true
            } else {
                return false
            }
        }

        fun isAnagram(s: String, t: String): Boolean {
            if (s.length != t.length) {
                return false
            }
            val result: MutableList<Int> = MutableList(26) { 0 }
            for (count in 0..s.length - 1) {
                result[s[count] - 'a']++
                result[t[count] - 'a']--
            }
            for (count in 0..result.size - 1) {
                if (result[count] != 0) {
                    return false
                }
            }
            return true
        }
    }
}