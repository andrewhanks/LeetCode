package questions


class Question_131_Palindrome_Partitioning {

    companion object {

        fun runQuestion() {
//            Input: s = "aab"
//            Output: [["a","a","b"],["aa","b"]]
            val s = "aab"
            val resultList = partition(s)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 131: $result")
        }

        fun partition(s: String): List<List<String>> {
            val result: MutableList<MutableList<String>> = mutableListOf()
            val temp: MutableList<String> = mutableListOf()
            checkPalindrome(s, 0, result, temp)
            return result
        }

        fun checkPalindrome(
            s: String,
            start: Int,
            result: MutableList<MutableList<String>>,
            temp: MutableList<String>
        ) {
            // println(temp)
            if (start == s.length) {
                var finalLength = 0
                temp.forEach {
                    finalLength += it.length
                }
                // println("finalLength = $finalLength, s.length = ${s.length}")
                if (finalLength == s.length) {
                    // println(temp.toMutableList())
                    result.add(temp.toMutableList())
                }
                return
            }
            for (count in start..s.length - 1) {
                val sub = s.substring(start..count)
                // println("start = $start, count = $count, sub = $sub, isValid(sub) = ${isValid(sub)}")
                if (isValid(sub)) {
                    temp.add(sub)
                    checkPalindrome(s, count + 1, result, temp)
                    temp.removeAt(temp.size - 1)
                }
            }
        }

        fun isValid(sub: String): Boolean {
            val sb = StringBuilder(sub)
            for (count in sb.length - 1 downTo 1) {
                sb.insert(count, ".")
            }
            // println("sb.toString() = ${sb.toString()}, sb.toString().reversed() = ${sb.toString().reversed()}")
            return sb.toString() == sb.toString().reversed()
        }
    }
}