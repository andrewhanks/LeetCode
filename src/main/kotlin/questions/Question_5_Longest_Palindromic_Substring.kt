package questions

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
            var result = ""
            for(i in 0..s.length-1) {
                for(j in 0..i) {
                    val temp = s.substring(j..i)
                    if(check(temp) && temp.length>result.length) {
                        result = temp
                    }
                }
            }
            return result
        }

        fun check(s:String) :Boolean{
            var i=0
            var j=s.length-1
            while(i<j) {
                if(s[i]!=s[j]) {
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