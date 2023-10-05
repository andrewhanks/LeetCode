package questions


class Question_49_Group_Anagrams {

    companion object {

        fun runQuestion() {
//            Input: strs = ["eat","tea","tan","ate","nat","bat"]
//            Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
            val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
            val resultList = groupAnagrams(strs)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 49: $result")
        }

        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val result: MutableMap<String, MutableList<Int>> = mutableMapOf()
            strs.forEachIndexed { index, value ->
                val tempStr = value.toCharArray().sorted().toString()
                if (!result.contains(tempStr)) {
                    result.put(tempStr, mutableListOf(index))
                } else {
                    result[tempStr]?.add(index)
                }
            }
            val returnedResult: MutableList<List<String>> = mutableListOf()
            result.forEach { key, value ->
                val group: MutableList<String> = mutableListOf()
                for (count in 0..value.size - 1) {
                    group.add(strs[value[count]])
                }
                returnedResult.add(group)
            }
            return returnedResult
        }
    }
}