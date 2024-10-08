package questions

class Question_647_Palindromic_Substrings {

    companion object {

        fun runQuestion() {
//            Input: s = "aaa"
//            Output: 6
            val s = "aaa"
            val result = countSubstrings(s)
            println("Question 647: $result")
        }

        fun countSubstrings(s: String): Int {
            var temp = "#"
            for (count in 0..s.length - 1) {
                temp = temp + s[count] + "#"
            }
            var ans = 0
            for (i in 0..temp.length - 1) {
                if (temp[i] != '#') {
                    ans++
                }
                var len = 0
                while (i - len - 1 >= 0 && i + len + 1 <= temp.length - 1 && temp[i - len - 1] == temp[i + len + 1]) {
                    if (temp[i - len - 1] != '#') {
                        ans++
                    }
                    len++
                }
            }
            return ans
        }

        fun countSubstringsDp(s: String): Int {
            val result = Array(s.length) { Array<Boolean>(s.length) { false } }
            var count = 0
            for (i in 0..s.length - 1) {
                for (j in 0..i) {
                    if (s[j] == s[i] && i - j < 2) {
                        result[j][i] = true
                        // println("i = $i, j = $j")
                        count++
                    } else if (s[j] == s[i] && i - 1 >= 0 && j + 1 <= s.length - 1 && result[j + 1][i - 1]) {
                        result[j][i] = true
                        // println("i = $i, j = $j")
                        count++
                    }
                }
            }
            return count
        }

        fun countSubstringsBruteForce(s: String): Int {
            var count = 0
            for (i in 0..s.length - 1) {
                for (j in 0..i) {
                    val temp = s.substring(j..i)
                    if (check(temp)) {
                        count++
                    }
                }
            }
            return count
        }

        fun check(s: String): Boolean {
            var i = 0
            var j = s.length - 1
            while (i < j) {
                if (s[i] != s[j]) {
                    return false
                }
                i++
                j--
            }
            return true
        }
    }
}