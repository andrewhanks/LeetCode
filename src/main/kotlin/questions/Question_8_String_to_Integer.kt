package questions

class Question_8_String_to_Integer {

    companion object {

        fun runQuestion8() {
            val inputString = "42"
            val result = myAtoi(inputString)
            println("Question 8: $result")
        }

        fun myAtoi(str: String): Int {
            var trimmedStr = str.trim()
            trimLoop@ for (tempCount in 1..trimmedStr.length - 1) {
                if (!trimmedStr[tempCount].isDigit()) {
                    trimmedStr = trimmedStr.substring(0, tempCount)
                }
                break@trimLoop
            }
            if (trimmedStr.length >= 2 && !trimmedStr[0].isDigit() && !trimmedStr[1].isDigit()) {
                return 0
            }
            trimmedStr = trimmedStr.trimStart('+')
            while (trimmedStr.length >= 2 && '0' == trimmedStr[0]) {
                trimmedStr = trimmedStr.trimStart('0')
            }
            if (trimmedStr.startsWith('-')) {
                trimmedStr = trimmedStr.trimStart('-')
                while (trimmedStr.length >= 2 && '0' == trimmedStr[0]) {
                    trimmedStr = trimmedStr.trimStart('0')
                }
                trimmedStr = "-$trimmedStr"
            }
            System.out.println("trimmedStr = ${trimmedStr}")
            var digitEnd = -1
            run checkLoop@{
                trimmedStr.forEachIndexed { index, c ->
                    if ((0 == index && '-' != c && '+' != c && !c.isDigit()) ||
                        (0 != index && !c.isDigit())
                    ) {
                        digitEnd = index
                        return@checkLoop
                    }
                }
                if (-1 == digitEnd) {
                    digitEnd = trimmedStr.length
                }
            }
            println("digitEnd = $digitEnd")

            if (0 == digitEnd || (1 == digitEnd && ('-' == trimmedStr[0] || '+' == trimmedStr[0]))) {
                return 0
            }

            val stringWithNumber = trimmedStr.substring(0, digitEnd)
            println("stringWithNumber = $stringWithNumber")

            if ('-' == stringWithNumber[0]) {
                if (stringWithNumber.length > 11) {
                    return Int.MIN_VALUE
                }
                val finalNum = -(stringWithNumber.substring(1, stringWithNumber.length).toLong())
                if (finalNum <= Int.MIN_VALUE) {
                    return Int.MIN_VALUE
                }
            } else {
                if (stringWithNumber.length > 11) {
                    return Int.MAX_VALUE
                }
                val finalNum = stringWithNumber.toLong()
                if (finalNum >= Int.MAX_VALUE) {
                    return Int.MAX_VALUE
                }
            }

            if ('-' == stringWithNumber[0]) {
                return -(stringWithNumber.substring(1, stringWithNumber.length).toInt())
            } else {
                return stringWithNumber.trimStart('+').toInt()
            }
        }

        fun myAtoiWebSolution(str: String): Int {
            if (str.isBlank()) {
                return 0
            }
            val trimmedStr = str.trim()
            val firstChar = trimmedStr[0]
            var sign = 1
            var start = 0
            val len = trimmedStr.length
            var sum: Long = 0
            if (firstChar == '+') {
                sign = 1
                start++
            } else if (firstChar == '-') {
                sign = -1
                start++
            }
            for (i in start until len) {
                if (!Character.isDigit(trimmedStr[i])) {
                    return sum.toInt() * sign
                }
                sum = sum * 10 + trimmedStr[i].toInt() - '0'.toInt()
                if (sign == 1 && sum > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE
                }
                if (sign == -1 && -1 * sum < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE
                }
            }

            return sum.toInt() * sign
        }
    }
}