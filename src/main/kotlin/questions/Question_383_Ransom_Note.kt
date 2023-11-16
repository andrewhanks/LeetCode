package questions

class Question_383_Ransom_Note {

    companion object {

        fun runQuestion() {
//            Input: ransomNote = "aa", magazine = "ab"
//            Output: false
            val ransomNote = "aa"
            val magazine = "ab"
            val result = canConstruct(ransomNote, magazine)
            println("Question 383: $result")
        }

        fun canConstruct(ransomNote: String, magazine: String): Boolean {
            val result: MutableMap<Char, Int> = mutableMapOf()
            for (count in 0..ransomNote.length - 1) {
                if (result.contains(ransomNote[count])) {
                    result[ransomNote[count]] = result[ransomNote[count]]!! + 1
                } else {
                    result.put(ransomNote[count], 1)
                }
            }
            for ((key, value) in result) {
                if (magazine.contains(key) && magazine.filter { it == key }.count() >= value) {

                } else {
                    return false
                }
            }
            return true
        }
    }
}