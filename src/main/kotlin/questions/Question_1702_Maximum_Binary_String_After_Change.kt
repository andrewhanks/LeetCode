package questions

class Question_1702_Maximum_Binary_String_After_Change {

    companion object {

        fun runQuestion() {
//            Input: binary = "000110"
//            Output: "111011"
            val binary = "000110"
            val result = maximumBinaryString(binary)
            println("Question 1702: $result")
        }

        fun maximumBinaryString(binary: String): String {
            var firstZeroPos = 0
            for (i in 0..binary.length - 1) {
                if (binary[i] == '0') {
                    firstZeroPos = i
                    break
                }
            }
            var oneNumber = 0
            for (i in firstZeroPos + 1..binary.length - 1) {
                val ch = binary[i]
                if (ch == '1') {
                    oneNumber++
                }
            }
            if (binary.length - (oneNumber + firstZeroPos) >= 2) {
                var ans = StringBuilder()
                for (i in 0..oneNumber - 1) {
                    ans.append("1")
                }
                ans.append("0")
                for (i in 0..binary.length - 1 - oneNumber - 1) {
                    ans.append("1")
                }
                return ans.reverse().toString()
            } else {
                return binary
            }
        }
    }
}