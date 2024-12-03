package questions

class Question_792_Number_of_Matching_Subsequences {

    companion object {

        fun runQuestion() {
//            Input: s = "abcde", words = ["a","bb","acd","ace"]
//            Output: 3
            val s = "abcde"
            val words = arrayOf("a", "bb", "acd", "ace")
            val result = numMatchingSubseq(s, words)
            println("Question 792: $result")
        }

        fun numMatchingSubseq(s: String, words: Array<String>): Int {
            var ans = 0
            for (item in words) {
                if (checkSequentially(s, item)) {
                    ans++
                }
            }
            return ans
        }

        fun checkSequentially(s: String, word: String): Boolean {
            var i = 0
            var j = 0
            while (i <= s.length - 1 && j <= word.length - 1) {
                if (s[i] != word[j]) {
                    i++
                } else {
                    i++
                    j++
                    if (j > word.length - 1) {
                        return true
                    }
                }
            }
            return false
        }

        fun numMatchingSubseqBinarySearch(s: String, words: Array<String>): Int {
            val pos: MutableList<MutableList<Int>> = MutableList(26) { mutableListOf() }
            for (count in 0..s.length - 1) {
                pos[s[count] - 'a'].add(count)
            }
            var ans = 0
            for (item in words) {
                if (checkBinarySearch(pos, item)) {
                    ans++
                }
            }
            return ans
        }

        fun checkBinarySearch(pos: MutableList<MutableList<Int>>, word: String): Boolean {
            var count = 0
            for (i in 0..word.length - 1) {
                val target = pos[word[i] - 'a']
                val insertPoint = target.binarySearch(count)
                var j = if (insertPoint >= 0) {
                    insertPoint
                } else {
                    -(insertPoint + 1)
                }
                // println("word[$i] = ${word[i]}, insertPoint = $insertPoint, j = $j")
                if (j >= target.size) {
                    return false
                }
                count = target[j] + 1
            }
            return true
        }

        fun numMatchingSubseqByMemorizeNextPosition(s: String, words: Array<String>): Int {
            val next = Array(s.length + 1) { IntArray(26) { -1 } }
            val tempS = "#" + s
            for (i in tempS.length - 1 downTo 1) {
                for (j in 0..25) {
                    next[i - 1][j] = next[i][j]
                }
                next[i - 1][tempS[i] - 'a'] = i
            }
            var ans = 0
            for (item in words) {
                if (checkByMemorizeNextPosition(next, item) != -1) {
                    ans++
                }
            }
            return ans
        }

        fun checkByMemorizeNextPosition(next: Array<IntArray>, word: String): Int {
            var ret = 0
            for (i in 0..word.length - 1) {
                ret = next[ret][word[i] - 'a']
                if (ret == -1) {
                    break
                }
            }
            return ret
        }
    }
}