package questions

class Question_6_Zig_Zag_Conversion {

    companion object {

        fun runQuestion6() {
            val inputString = "PAYPALISHIRING"
            val inputRows = 3
            val result = convert(inputString, inputRows)
            println("Question 6: $result")
        }

        fun convert(s: String, numRows: Int): String {
            var resultString = ""
            val modNum = numRows * 2 - 2
            var count = 0

            if (1 == numRows) {
                return s
            }

            count = 0
            while (count < s.length) {
                resultString += s[count]
                count += modNum
            }

            for (position in 1..numRows - 2) {
                count = 0
                while (count + position < s.length) {
                    resultString += s[count + position]
                    if (count + modNum - position < s.length) {
                        resultString += s[count + modNum - position]
                    }
                    count += modNum
                }
            }

            count = numRows - 1
            while (count < s.length) {
                resultString += s[count]
                count += modNum
            }
            return resultString
        }
    }
}