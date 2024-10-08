package questions

import kotlin.math.min

class Question_5_Longest_Palindromic_Substring {

    companion object {

        fun runQuestion() {
//            Input: s = "babad"
//            Output: "bab"
            val inputString = "babad"
            val result = longestPalindrome(inputString)
            println("Question 5: $result")
        }

        fun longestPalindrome(s: String): String {
            val builder = StringBuilder()
            for (count in 0..s.length - 1) {
                if (count == 0) {
                    builder.append("_")
                }
                builder.append(s[count])
                builder.append("_")
            }
            var max = 0
            var ans = ""
            for (count in 0..builder.length - 1) {
                var len = 0
                while (count - len - 1 >= 0 && count + len + 1 <= builder.length - 1 &&
                    builder[count - len - 1] == builder[count + len + 1]
                ) {
                    len++
                }
                // println("count = $count, len = $len")
                if (len > max) {
                    max = len
                    ans = builder.substring(count - len..count + len)
                }
            }
            return ans.replace("_", "")
        }

        fun longestPalindromeWithManacherAlgorithm(s: String): String {
            var temp = "#"
            for(count in 0..s.length-1) {
                temp = temp+s[count]+"#"
            }
            val result = IntArray(temp.length){0}
            var maxRight = -1
            var maxCenter = -1
            for(i in 0..result.size-1) {
                var len = 0
                if(i<=maxRight) {
                    val j = maxCenter-(i-maxCenter)
                    len = min(result[j], maxRight-i)
                    while(i-len-1>=0 && i+len+1<=result.size-1 && temp[i-len-1]==temp[i+len+1]) {
                        len++
                    }
                }else {
                    len = 0
                    while(i-len-1>=0 && i+len+1<=result.size-1 && temp[i-len-1]==temp[i+len+1]) {
                        len++
                    }
                }
                result[i] = len
            }
            var maxLen = 0
            var ans = ""
            for(count in 0..result.size-1) {
                if(result[count] > maxLen) {
                    ans = temp.substring(count-result[count], count+result[count])
                    maxLen = result[count]
                }
            }
            return ans.replace("#", "")
        }

        fun longestPalindromeWithBruteForce(s: String): String {
            var result = ""
            for (i in 0..s.length - 1) {
                for (j in 0..i) {
                    val temp = s.substring(j..i)
                    if (check(temp) && temp.length > result.length) {
                        result = temp
                    }
                }
            }
            return result
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

        // Recording whether substrings of input are Palindrome from 1 to s.length characters
        fun longestPalindromeWebSolution(s: String): String {
            if (s.isEmpty()) {
                return ""
            }
            val n = s.length
            var longestBegin = 0
            var maxLen = 1
            val table = Array(1000) { Array(1000) { false } }
            for (i in 0..n - 1) {
                table[i][i] = true
            }
            for (i in 0..n - 2) {
                if (s[i] == s[i + 1]) {
                    table[i][i + 1] = true
                    longestBegin = i
                    maxLen = 2
                }
            }
            for (len in 3..n) {
                for (i in 0..n - len) {
                    val j = i + len - 1
                    if (s[i] == s[j] && table[i + 1][j - 1]) {
                        table[i][j] = true
                        longestBegin = i
                        maxLen = len
                    }
                }
            }
            return s.substring(longestBegin, longestBegin + maxLen)
        }

        fun longestPalindromeExpandAroundCenter(s: String): String {
            var result = ""
            for (count in 0..s.length - 1) {
                var add = 0
                while (count - add >= 0 && count + add <= s.length - 1) {
                    if (s[count - add] == s[count + add]) {
                        if (add * 2 + 1 > result.length) {
                            result = s.substring(count - add..count + add)
                        }
                    } else {
                        break
                    }
                    add++
                }
            }
            for (count in 0..s.length - 2) {
                var add = 0
                if (s[count] != s[count + 1]) {
                    continue
                }
                while (count - add >= 0 && count + add + 1 <= s.length - 1) {
                    if (s[count - add] == s[count + add + 1]) {
                        if (add * 2 + 2 > result.length) {
                            result = s.substring(count - add..count + add + 1)
                        }
                    } else {
                        break
                    }
                    add++
                }
            }
            return result
        }
    }
}