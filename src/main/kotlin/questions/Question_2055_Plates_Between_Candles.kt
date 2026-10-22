package questions

class Question_2055_Plates_Between_Candles {

    companion object {

        fun runQuestion() {
//            Input: s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
//            Output: [9,0,0,0,0]
            val s = "***|**|*****|**||**|*"
            val queries =
                arrayOf(intArrayOf(1, 17), intArrayOf(4, 5), intArrayOf(14, 17), intArrayOf(5, 11), intArrayOf(15, 16))
            val result = platesBetweenCandles(s, queries)
            println("Question 2055: ${result.contentToString()}")
        }

        fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
            val candlePos = mutableListOf<Int>()
            for (i in 0..s.length - 1) {
                if (s[i] == '|') {
                    candlePos.add(i)
                }
            }
            val ret = mutableListOf<Int>()
            for (i in 0..queries.size - 1) {
                val query = queries[i]
                ret.add(getPlateNumber(candlePos, query))
            }
            return ret.toIntArray()
        }

        fun getPlateNumber(candlePos: MutableList<Int>, query: IntArray): Int {
            var start = 0
            var end = candlePos.size - 1
            for (i in 0..candlePos.size - 1) {
                if (candlePos[i] >= query[0]) {
                    start = i
                    break
                }
                start = i
            }
            for (i in candlePos.size - 1 downTo 0) {
                if (candlePos[i] <= query[1]) {
                    end = i
                    break
                }
                end = i
            }
            // println("candlePos[$start] = ${candlePos[start]}, candlePos[$end] = ${candlePos[end]}")
            if (start >= end) {
                return 0
            }
            return candlePos[end] - candlePos[start] - end + start
        }

        fun platesBetweenCandlesAnotherSolution(s: String, queries: Array<IntArray>): IntArray {
            val n = s.length
            val presum = IntArray(n) { 0 }
            var sum = 0
            for (i in 0..s.length - 1) {
                if (s[i] == '*') {
                    sum += 1
                    presum[i] = sum
                } else {
                    presum[i] = sum
                }
            }
            val left = IntArray(n) { 0 }
            var pos = -1
            for (i in 0..s.length - 1) {
                if (s[i] == '|') {
                    pos = i
                }
                left[i] = pos
            }
            pos = n
            val right = IntArray(n) { 0 }
            for (i in s.length - 1 downTo 0) {
                if (s[i] == '|') {
                    pos = i
                }
                right[i] = pos
            }
            val ret = IntArray(queries.size) { 0 }
            for (i in 0..queries.size - 1) {
                val a = queries[i][0]
                val b = queries[i][1]
                val start = right[a]
                val end = left[b]
                // println("a = $a, b = $b, start = $start, end = $end")
                if (start < end) {
                    ret[i] = presum[end] - presum[start]
                } else {
                    ret[i] = 0
                }
            }
            return ret
        }
    }
}