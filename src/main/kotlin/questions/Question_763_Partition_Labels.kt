package questions


class Question_763_Partition_Labels {

    companion object {

        fun runQuestion() {
//            Input: s = "ababcbacadefegdehijhklij"
//            Output: [9,7,8]
            val s = "ababcbacadefegdehijhklij"
            val result = partitionLabels(s)
            println("Question 763: $result")
        }

        fun partitionLabels(s: String): List<Int> {
            var start: MutableList<Int> = mutableListOf()
            var end: MutableList<Int> = mutableListOf()
            var count = 0
            while (count < s.length) {
                val char = s[count]
                if (start.size > 0) {
                    println("start = $start, end = $end")
                }
                if (start.size > 0 && count <= end[end.size - 1]) {
                    val pos = s.lastIndexOf(char)
                    if (pos > end[end.size - 1]) {
                        end[end.size - 1] = pos
                    }
                } else {
                    start.add(count)
                    end.add(s.lastIndexOf(char))
                }
                count++
            }
            val result: MutableList<Int> = mutableListOf()
            for (i in 0..start.size - 1) {
                result.add(end[i] - start[i] + 1)
            }
            return result
        }
    }
}