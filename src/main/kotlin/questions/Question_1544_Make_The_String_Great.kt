package questions

class Question_1544_Make_The_String_Great {

    companion object {

        fun runQuestion() {
            val string = "leEeetcode"
            val result = makeGood(string)
            println("Question 1544: $result")
        }

        fun makeGood(s: String): String {
            var result = StringBuilder(s)
            var count = 0
            while (count <= result.length - 2 && result.length >= 2) {
                println(result)
                if (result[count].toLowerCase() == result[count + 1].toLowerCase() && result[count] != result[count + 1]) {
                    result.deleteAt(count)
                    result.deleteAt(count)
                    if (count > 0) {
                        count--
                    }
                } else {
                    count++
                }
            }
            return result.toString()
        }
    }
}