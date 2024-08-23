package questions

class Question_2375_Construct_Smallest_Number_From_DI_String {

    companion object {

        fun runQuestion() {
//            Input: pattern = "IIIDIDDD"
//            Output: "123549876"
            val pattern = "IIIDIDDD"
            val result = smallestNumber(pattern)
            println("Question 2375: $result")
        }

        fun smallestNumber(pattern: String): String {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            val used = Array(9) { false }
            generate(result, temp, used, pattern, 0)
            result.sortBy { it.joinToString() }
            // println("result[0] = ${result[0].joinToString()}")
            return result[0].joinToString().replace(", ", "")
        }

        fun generate(
            result: MutableList<MutableList<Int>>,
            temp: MutableList<Int>,
            used: Array<Boolean>,
            pattern: String,
            index: Int
        ) {
            if (temp.size >= pattern.length + 1) {
                if (temp.size == pattern.length + 1) {
                    result.add(temp.toMutableList())
                }
                return
            }
            for (count in 1..pattern.length + 1) {
                if (used[count - 1]) {
                    continue
                }
                if (temp.size >= 1) {
                    if (pattern[temp.size - 1] == 'I' && count <= temp[temp.size - 1]) {
                        continue
                    } else if (pattern[temp.size - 1] == 'D' && count >= temp[temp.size - 1]) {
                        continue
                    }
                }
                temp.add(count)
                used[count - 1] = true
                generate(result, temp, used, pattern, index + 1)
                temp.removeAt(temp.size - 1)
                used[count - 1] = false
            }
        }
    }
}