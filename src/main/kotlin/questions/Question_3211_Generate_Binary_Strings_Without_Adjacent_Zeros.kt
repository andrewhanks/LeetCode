package questions

class Question_3211_Generate_Binary_Strings_Without_Adjacent_Zeros {

    companion object {

        fun runQuestion() {
//            Input: n = 3
//            Output: ["010","011","101","110","111"]
            val n = 3
            val result = validStrings(n)
            println("Question 3211: $result")
        }

        fun validStrings(n: Int): List<String> {
            val result: MutableList<String> = mutableListOf()
            val temp = StringBuilder()
            helper(n, result, temp)
            // println(result)
            return result
        }

        fun helper(n: Int, result: MutableList<String>, temp: StringBuilder) {
            if (n == temp.length) {
                if (!result.contains(temp.toString())) {
                    result.add(temp.toString())
                }
                return
            }
            if (temp.length < 1 || (temp.length >= 1 && temp[temp.length - 1] != '0')) {
                temp.append('0')
                helper(n, result, temp)
                temp.deleteAt(temp.length - 1)
            }
            temp.append('1')
            helper(n, result, temp)
            temp.deleteAt(temp.length - 1)
        }
    }
}