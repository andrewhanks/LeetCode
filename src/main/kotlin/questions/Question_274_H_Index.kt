package questions

class Question_274_H_Index {

    companion object {

        fun runQuestion() {
            // [3,0,6,1,5]
            val array = intArrayOf(3, 0, 6, 1, 5)
            val result = hIndex(array)
            println("Question 274: $result")
        }

        fun hIndex(citations: IntArray): Int {
            for (count in citations.size downTo 1) {
                if (citations.filter { it >= count }.count() >= count) {
                    return count
                }
            }
            return 0
        }
    }
}