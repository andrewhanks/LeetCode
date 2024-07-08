package questions

class Question_3210_Find_the_Encrypted_String {

    companion object {

        fun runQuestion() {
//            Input: s = "dart", k = 3
//            Output: "tdar"
            val s = "dart"
            val k = 3
            val result = getEncryptedString(s, k)
            println("Question 3210: $result")
        }

        fun getEncryptedString(s: String, k: Int): String {
            val result = StringBuilder()
            for (count in k..k + s.length - 1) {
                result.append(s[count % s.length])
            }
            return result.toString()
        }
    }
}