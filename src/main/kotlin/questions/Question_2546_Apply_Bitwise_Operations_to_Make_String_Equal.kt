package questions

class Question_2546_Apply_Bitwise_Operations_to_Make_String_Equal {

    companion object {

        fun runQuestion() {
//            Input: s = "1010", target = "0110"
//            Output: true
            val s = "1010"
            val target = "0110"
            val result = makeStringsEqual(s, target)
            println("Question 2546: $result")
        }

        fun makeStringsEqual(s: String, target: String): Boolean {
            val sZeroNumber = s.filter { it == '0' }.count()
            val sOneNumber = s.filter { it == '1' }.count()
            val targetZeroNumber = target.filter { it == '0' }.count()
            val targetOneNumber = target.filter { it == '1' }.count()
            if (targetZeroNumber == target.length && sOneNumber >= 1) {
                return false
            } else if (sZeroNumber == s.length && targetOneNumber >= 1) {
                return false
            } else {
                return true
            }
        }

        fun makeStringsEqualAnotherSolution(s: String, target: String): Boolean {
            return s.contains('1') == target.contains('1')
        }
    }
}