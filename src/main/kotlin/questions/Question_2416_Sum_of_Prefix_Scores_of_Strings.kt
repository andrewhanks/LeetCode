package questions


class Question_2416_Sum_of_Prefix_Scores_of_Strings {

    companion object {

        fun runQuestion() {
//            Input: words = ["abc","ab","bc","b"]
//            Output: [5,4,3,2]
            val words = arrayOf("abc", "ab", "bc", "b")
            val result = sumPrefixScores(words)
            println("Question 1170: ${result.contentToString()}")
        }

        class TrieNode {
            val next = Array<TrieNode?>(26) { null }
            var count = 0
        }

        fun sumPrefixScores(words: Array<String>): IntArray {
            val root = TrieNode()
            for (i in 0..words.size - 1) {
                var node: TrieNode = root
                for (j in 0..words[i].length - 1) {
                    if (node.next[words[i][j] - 'a'] == null) {
                        node.next[words[i][j] - 'a'] = TrieNode()
                    }
                    node = node.next[words[i][j] - 'a']!!
                    node.count += 1
                    // println("words[$i][$j] = ${words[i][j]}, node!!.count = ${node!!.count}")
                }
            }
            val ans = IntArray(words.size) { 0 }
            for (i in 0..words.size - 1) {
                var total = 0
                var node: TrieNode = root
                for (j in 0..words[i].length - 1) {
                    if (node.next[words[i][j] - 'a'] != null) {
                        node = node.next[words[i][j] - 'a']!!
                        total += node.count
                        // println("words[$i][$j] = ${words[i][j]}, total = $total")
                    } else {
                        break
                    }
                }
                ans[i] = total
            }
            return ans
        }
    }
}