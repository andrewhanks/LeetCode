package questions

class Question_28_Find_the_Index_of_the_First_Occurrence_in_a_String {

    companion object {

        fun runQuestion() {
//            Input: haystack = "sadbutsad", needle = "sad"
//            Output: 0
            val haystack = "sadbutsad"
            val needle = "sad"
            val result = strStr(haystack, needle)
            println("Question 28: $result")
        }

        fun strStr(haystack: String, needle: String): Int {
            if (haystack.contains(needle)) {
                return haystack.indexOf(needle)
            }
            return -1
        }
    }
}