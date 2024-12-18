package questions


class Question_2100_Find_Good_Days_to_Rob_the_Bank {

    companion object {

        fun runQuestion() {
//            Input: security = [5,3,3,3,5,6,2], time = 2
//            Output: [2,3]
            val security = intArrayOf(5, 3, 3, 3, 5, 6, 2)
            val time = 2
            val result = goodDaysToRobBank(security, time)
            println("Question 2100: $result")
        }

        fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {
            if (time == 0) {
                val ans: MutableList<Int> = mutableListOf()
                for (i in 0..security.size - 1) {
                    ans.add(i)
                }
                return ans
            }
            val result = Array(security.size) { false }
            var high = 0
            for (i in 1..security.size - 1 - time) {
                if (security[i] > security[i - 1]) {
                    high = i
                }
                if (i >= time && i <= security.size - 1 - time) {
                    if (i - high >= time) {
                        result[i] = true
                    }
                }
            }
            // println("result 1 = ${result.contentToString()}")
            var low = security.size - 1
            for (i in security.size - 2 downTo time) {
                if (security[i + 1] < security[i]) {
                    low = i
                }
                if (i >= time && i <= security.size - 1 - time) {
                    if (low - i >= time) {
                        result[i] = result[i] && true
                    } else {
                        result[i] = result[i] && false
                    }
                }
            }
            // println("result 2 = ${result.contentToString()}")
            val ans: MutableList<Int> = mutableListOf()
            for (i in 0..result.size - 1) {
                if (result[i]) {
                    ans.add(i)
                }
            }
            return ans.toList()
        }

        fun goodDaysToRobBankByIncreasingNumber(security: IntArray, time: Int): List<Int> {
            val ltr = IntArray(security.size) { 0 }
            val rtl = IntArray(security.size) { 0 }
            for (i in 1..security.size - 1) {
                if (security[i] <= security[i - 1]) {
                    ltr[i] = ltr[i - 1] + 1
                }
            }
            // println("ltr = ${ltr.contentToString()}")
            for (i in security.size - 2 downTo 0) {
                if (security[i + 1] >= security[i]) {
                    rtl[i] = rtl[i + 1] + 1
                }
            }
            // println("rtl = ${rtl.contentToString()}")
            val ans: MutableList<Int> = mutableListOf()
            for (i in 0..security.size - 1) {
                if (ltr[i] >= time && rtl[i] >= time) {
                    ans.add(i)
                }
            }
            return ans.toList()
        }
    }
}