package questions

import java.util.*


class Question_127_Word_Ladder {

    companion object {

        fun runQuestion() {
//            Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//            Output: 5
            val beginWord = "hit"
            val endWord = "cog"
            val wordList = listOf("hot", "dot", "dog", "lot", "log", "cog")
            val result = ladderLength(beginWord, endWord, wordList)
            println("Question 127: $result")
        }

        fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
            if (!wordList.contains(endWord)) {
                return 0
            }
            val temp: MutableList<Int> = mutableListOf()
            val list: MutableList<String> = mutableListOf()
            list.add(beginWord)
            list.addAll(wordList)
            val result = Array(list.size) { Array(list.size) { false } }
            for (i in 0..list.size - 1) {
                for (j in 0..list.size - 1) {
                    if (i == j) {
                        continue
                    }
                    result[i][j] = isDiffOne(list[i], list[j])
                }
            }
            val queue: Queue<Int> = LinkedList()
            var trans = 0
            queue.add(0)
            temp.add(0)
            while (!queue.isEmpty()) {
                for (count in 0..queue.size - 1) {
                    val index = queue.remove()
                    if (list[index] == endWord) {
                        trans++
                        return trans
                    }
                    for (oneDiffCount in 0..result[index].size - 1) {
                        if (result[index][oneDiffCount] && !temp.contains(oneDiffCount)) {
                            queue.add(oneDiffCount)
                            temp.add(oneDiffCount)
                        }
                    }
                }
                trans++
            }
            return 0
        }

        fun isDiffOne(s1: String, s2: String): Boolean {
            var diff = 0
            for (count in 0..s1.length - 1) {
                if (s1[count] != s2[count]) {
                    diff++
                }
                if (diff >= 2) {
                    return false
                }
            }
            return true
        }
    }
}