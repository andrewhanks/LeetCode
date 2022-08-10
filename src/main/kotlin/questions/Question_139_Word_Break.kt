package questions

class Question_139_Word_Break {

    companion object {

        fun runQuestion() {
            val inputString = "leetcode"
            val inputWordList = mutableListOf<String>()
            inputWordList.add("leet")
            inputWordList.add("code")
            val result = wordBreak(inputString, inputWordList)
            println("Question 139: $result")
        }

        var map: MutableMap<String, Boolean> = HashMap()

        fun wordBreak(s: String, wordDict: List<String>): Boolean {
            if (wordDict.contains(s)) {
                return true
            }
            if (map.containsKey(s)) {
                return map[s] ?: false
            }
            for (i in 0 until s.length) {
                val left = s.substring(0, i)
                if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                    map[s] = true
                    return true
                }
            }
            map[s] = false
            return false
        }

        fun wordBreakDp(s: String, wordDict: List<String>): Boolean {
            val resultArray: MutableList<Boolean> = MutableList(s.length + 1) { false }
            resultArray[0] = true
            for (i in 0..s.length) {
                for (j in 0..i) {
                    if (!resultArray[j]) {
                        continue
                    }
                    val subStr = s.substring(j, i)
                    if (wordDict.contains(subStr)) {
                        resultArray[i] = true
                    }
                }
            }
            return resultArray[s.length]
        }
    }
}