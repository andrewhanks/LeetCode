package questions

class Question_17_Letter_Combinations_of_a_Phone_Number {

    companion object {

        fun runQuestion() {
//            Input: digits = "23"
//            Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
            val number = "23"
            val result = letterCombinations(number)
            println("Question 17: $result")
        }

        val map = listOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

        fun letterCombinations(digits: String): List<String> {
            if (digits.length == 0) {
                return listOf()
            }
            val result: MutableList<String> = mutableListOf()
            val temp: StringBuilder = StringBuilder("")
            combination(digits, 0, result, temp)
            return result
        }

        fun combination(digits: String, start: Int, result: MutableList<String>, temp: StringBuilder) {
            if (temp.length == digits.length) {
                result.add(temp.toString())
                return
            }
            val characters = map[digits[start].digitToInt()]
            for (count in 0..characters.length - 1) {
                combine(characters[count], digits, start, result, temp)
            }
        }

        fun combine(alphabet: Char, digits: String, start: Int, result: MutableList<String>, temp: StringBuilder) {
            temp.append(alphabet)
            combination(digits, start + 1, result, temp)
            temp.deleteAt(temp.length - 1)
        }

        val resultString = ArrayList<String>()

        fun letterCombinationsOld(digits: String): List<String> {

            if (digits.isEmpty()) {
                return emptyList()
            }

            val mapping = arrayOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
            val digitCharArray = Array<String>(digits.length) { "" }

            digits.forEachIndexed { index, c ->
                digitCharArray[index] = mapping[c.toString().toInt()]
            }

            combineChars("", digitCharArray)

            return resultString
        }

        private fun combineChars(combination: String, digitCharArray: Array<String>) {
            if (combination.length == digitCharArray.size) {
                resultString.add(combination)
                return
            }
            val currentPosition = combination.length
            digitCharArray[currentPosition].forEach {
                val tempResult = combination + it
                combineChars(tempResult, digitCharArray)
            }
        }

        fun letterCombinationsWebSolution(digits: String): List<String> {
            val ans = ArrayList<String>()
            if (digits.isEmpty()) return ans
            val mapping = arrayOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
            ans.add("")
            for (i in 0 until digits.length) {
                val x = Character.getNumericValue(digits[i])
                while (ans[0].length == i) {
                    val t = ans.removeAt(0)
                    for (s in mapping[x].toCharArray())
                        ans.add(t + s)
                }
            }
            return ans
        }
    }
}