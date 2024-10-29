package questions

import java.util.*

class Question_767_Reorganize_String {

    companion object {

        fun runQuestion() {
//            Input: s = "aab"
//            Output: "aba"
            val s = "aab"
            val result = reorganizeString(s)
            println("Question 767: $result")
        }

        fun reorganizeString(s: String): String {
            // println("s.length = ${s.length}")
            val result = Array(26) { IntArray(2) { 0 } }
            for (count in 0..s.length - 1) {
                result[s[count] - 'a'][0] = s[count].toInt()
                result[s[count] - 'a'][1]++
            }
            val queue: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                b[1] - a[1]
            }
            for (count in 0..result.size - 1) {
                if (result[count][1] == 0) {
                    continue
                }
                queue.add(intArrayOf(result[count][0], result[count][1]))
            }
            val currentCount = queue.peek()[1]
            val otherCount = s.length - currentCount
            if (currentCount - otherCount > 1) {
                return ""
            }
            // println("result = ${result.contentDeepToString()}")
            val ans = StringBuilder("")
            val temp: Queue<IntArray> = LinkedList()
            while (!queue.isEmpty()) {
                val node = queue.remove()
                ans.append(node[0].toChar())
                if (node[1] - 1 > 0) {
                    if (!queue.isEmpty() && node[1] - 1 < queue.peek()[1]) {
                        queue.add(intArrayOf(node[0], node[1] - 1))
                    } else {
                        temp.add(intArrayOf(node[0], node[1] - 1))
                    }
                }
                while (!temp.isEmpty() && ans[ans.length - 1].toInt() != temp.peek()[0]) {
                    queue.add(temp.remove())
                }
            }
            return ans.toString()
        }
    }
}