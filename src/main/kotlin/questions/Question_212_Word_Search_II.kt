package questions


class Question_212_Word_Search_II {

    class TrieNode {
        var word: String? = null
        var children = arrayOfNulls<TrieNode>(26)
        operator fun get(c: Char): TrieNode? {
            val index = c.toInt() - 'a'.toInt()
            return if (index < 0 || index == 26) null else children[index]
        }
    }

    class Trie(words: Array<String>) {
        var root: TrieNode

        init {
            root = TrieNode()
            for (w in words) {
                var cur: TrieNode? = root // re-start from root
                for (c in w.toCharArray()) {
                    val index = c.toInt() - 'a'.toInt()
                    if (cur!!.children[index] == null) {
                        cur.children[index] = TrieNode()
                    }
                    cur = cur.children[index]
                }
                cur!!.word = w // mark as word
            }
        }
    }

    companion object {

        fun runQuestion() {
//            Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
//            Output: ["eat","oath"]
            val board = arrayOf(
                charArrayOf('o', 'a', 'a', 'n'),
                charArrayOf('e', 't', 'a', 'e'),
                charArrayOf('i', 'h', 'k', 'r'),
                charArrayOf('i', 'f', 'l', 'v')
            )
            val words = arrayOf("oath", "pea", "eat", "rain")
            val result = findWords(board, words)
            println("Question 212: $result")
        }

        fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
            if (board.size < 1) {
                return listOf<String>()
            }
            val result: MutableList<String> = mutableListOf()
            var used: Array<IntArray> = Array(board.size) { IntArray(board[0].size) { 0 } }
            words.forEach { word ->
                used = Array(board.size) { IntArray(board[0].size) { 0 } }
                var searched = false
                for (x in 0..board.size - 1) {
                    for (y in 0..board[0].size - 1) {
                        if (board[x][y] == word[0]) {
                            searched = searchWord(word, board, 0, x, y, used)
                            if (searched) {
                                result.add(word)
                                break
                            }
                        }
                    }
                    if (searched) {
                        break
                    }
                }
            }
            return result
        }

        fun searchWord(
            word: String,
            board: Array<CharArray>,
            count: Int,
            x: Int,
            y: Int,
            used: Array<IntArray>
        ): Boolean {
            if (word.length > board.size * board[0].size) {
                return false
            }
            if (x < 0 || x > board.size - 1 || y < 0 || y > board[0].size - 1 || used[x][y] == 1) {
                return false
            }
            if (word.length - 1 == count && board[x][y] == word[count]) {
                return true
            }
            if (board[x][y] == word[count] && used[x][y] != 1) {
                used[x][y] = 1
                val result = searchWord(word, board, count + 1, x + 1, y, used) ||
                        searchWord(word, board, count + 1, x - 1, y, used) ||
                        searchWord(word, board, count + 1, x, y + 1, used) ||
                        searchWord(word, board, count + 1, x, y - 1, used)
                used[x][y] = 0
                return result
            }
            return false
        }

        val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1))

        fun findWordsWebSolution(board: Array<CharArray>?, words: Array<String>): List<String?> {
            val ans: MutableList<String?> = ArrayList()
            if (board == null) return ans
            val trie = Trie(words)
            val m = board.size
            val n = board[0].size
            val temp: MutableSet<String?> = HashSet()
            for (i in 0 until m) {
                for (j in 0 until n) {
                    val next = trie.root[board[i][j]]
                    next?.let { helper(board, i, j, it, temp, m, n) }
                }
            }
            for (s in temp) ans.add(s)
            return ans
        }

        fun helper(board: Array<CharArray>, i: Int, j: Int, next: TrieNode?, ans: MutableSet<String?>, m: Int, n: Int) {
            if (next!!.word != null) {
                ans.add(next.word) // don't return, we still have to search forward, for example, oat -> oath
            }
            val old = board[i][j]
            board[i][j] = '*'
            for (dir in dirs) {
                val ii = dir[0] + i
                val jj = dir[1] + j
                if (ii >= 0 && jj >= 0 && ii < m && jj < n && next[board[ii][jj]] != null) {
                    helper(board, ii, jj, next[board[ii][jj]], ans, m, n)
                }
            }
            board[i][j] = old
        }
    }
}