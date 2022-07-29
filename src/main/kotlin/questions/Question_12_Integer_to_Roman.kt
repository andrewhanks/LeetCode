package questions

class Question_12_Integer_to_Roman {

    companion object {

        fun runQuestion12() {
            val input = 3
            val result = intToRoman(input)
            println("Question 12: $result")
        }

        fun intToRoman(num: Int): String {
            var resultString = ""

            // handle the fourth digit
            val fourthDigit = num / 1000
            val restThreeDigit = num % 1000
            for (i in 1..fourthDigit) {
                resultString += "M"
            }

            // handle the third digit
            var thirdDigit = restThreeDigit / 100
            val restTwoDigit = restThreeDigit % 100
            if (4 == thirdDigit) {
                resultString += "CD"
            } else if (9 == thirdDigit) {
                resultString += "CM"
            } else {
                if (thirdDigit >= 5) {
                    thirdDigit -= 5
                    resultString += "D"
                }
                for (i in 1..thirdDigit) {
                    resultString += "C"
                }
            }

            // handle the second digit
            var secondDigit = restTwoDigit / 10
            var restOneDigit = restTwoDigit % 10
            if (4 == secondDigit) {
                resultString += "XL"
            } else if (9 == secondDigit) {
                resultString += "XC"
            } else {
                if (secondDigit >= 5) {
                    secondDigit -= 5
                    resultString += "L"
                }
                for (i in 1..secondDigit) {
                    resultString += "X"
                }
            }

            // handle the first digit
            if (4 == restOneDigit) {
                resultString += "IV"
            } else if (9 == restOneDigit) {
                resultString += "IX"
            } else {
                if (restOneDigit >= 5) {
                    restOneDigit -= 5
                    resultString += "V"
                }
                for (i in 1..restOneDigit) {
                    resultString += "I"
                }
            }

            return resultString
        }
    }
}