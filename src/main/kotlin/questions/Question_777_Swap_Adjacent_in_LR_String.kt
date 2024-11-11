package questions

class Question_777_Swap_Adjacent_in_LR_String {

    companion object {

        fun runQuestion() {
//            Input: start = "RXXLRXRXL", result = "XRLXXRRLX"
//            Output: true
            val start = "RXXLRXRXL"
            val result = "XRLXXRRLX"
            val ans = canTransform(start, result)
            println("Question 777: $ans")
        }

        fun canTransform(start: String, result: String): Boolean {
            if (start.filter { it != 'X' } != result.filter { it != 'X' }) {
                return false
            }
            val startL: MutableList<Int> = mutableListOf()
            val startR: MutableList<Int> = mutableListOf()
            val resultL: MutableList<Int> = mutableListOf()
            val resultR: MutableList<Int> = mutableListOf()
            for (count in 0..start.length - 1) {
                if (start[count] == 'L') {
                    startL.add(count)
                } else if (start[count] == 'R') {
                    startR.add(count)
                }
            }
            for (count in 0..result.length - 1) {
                if (result[count] == 'L') {
                    resultL.add(count)
                } else if (result[count] == 'R') {
                    resultR.add(count)
                }
            }
            for (count in 0..startL.size - 1) {
                if (startL[count] < resultL[count]) {
                    return false
                }
            }
            for (count in 0..startR.size - 1) {
                if (startR[count] > resultR[count]) {
                    return false
                }
            }
            if (startL.size != resultL.size || startR.size != resultR.size) {
                return false
            }
            return true
        }
    }
}