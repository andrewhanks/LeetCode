package questions

import java.util.*


class Question_692_Top_K_Frequent_Words {

    companion object {

        fun runQuestion() {
//            Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
//            Output: ["the","is","sunny","day"]
            val words = arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is")
            val k = 4
            val result = topKFrequent(words, k)
            println("Question 692: $result")
        }

        fun topKFrequent(words: Array<String>, k: Int): List<String> {
            val map: TreeMap<String, Int> = TreeMap()
            for (count in 0..words.size - 1) {
                if (!map.contains(words[count])) {
                    map.put(words[count], 1)
                } else {
                    map[words[count]] = map[words[count]]!! + 1
                }
            }
            val temp = map.toList().sortedByDescending { (key, value) -> value }.toMap()
            val result: MutableList<String> = mutableListOf()
            var count = 0
            for ((key, value) in temp) {
                if (count >= k) {
                    break
                }
                result.add(key)
                count++
            }
            return result
        }
    }
}