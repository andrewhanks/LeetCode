package questions

class Question_438_Find_All_Anagrams_in_a_String {

    companion object {

        fun runQuestion() {
//            Input: s = "cbaebabacd", p = "abc"
//            Output: [0,6]
            val s = "cbaebabacd"
            val p = "abc"
            val result = findAnagrams(s, p)
            println("Question 438: $result")
        }

        fun findAnagrams(s: String, p: String): List<Int> {
            if (s.length < p.length) {
                return listOf()
            }
            val result: MutableList<Int> = mutableListOf()
            val pCount = IntArray(26) { 0 }
            val sCount = IntArray(26) { 0 }
            for (count in 0..p.length - 1) {
                pCount[p[count] - 'a']++
            }
            for (count in 0..p.length - 1) {
                sCount[s[count] - 'a']++
            }
            if (pCount.contentEquals(sCount)) {
                result.add(0)
            }
            for (count in 1..s.length - p.length) {
                sCount[s[count - 1] - 'a']--
                sCount[s[count + p.length - 1] - 'a']++
                if (pCount.contentEquals(sCount)) {
                    result.add(count)
                }
            }
            return result
        }
    }
}