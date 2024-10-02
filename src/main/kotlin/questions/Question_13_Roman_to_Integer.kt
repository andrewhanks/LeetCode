package questions

class Question_13_Roman_to_Integer {

    companion object {

        fun runQuestion() {
//            Input: s = "III"
//            Output: 3
            val s = "III"
            val result = romanToInt(s)
            println("Question 13: $result")
        }

        fun romanToInt(s: String): Int {
            var totalCount = 0
            var breakNextLoop = false
            for (count in 0..(s.length - 1)) {
                if (breakNextLoop) {
                    breakNextLoop = false
                    continue
                }
                if ('I' == s[count]) {
                    if (count + 1 < s.length && 'V' == s[count + 1]) {
                        breakNextLoop = true
                        totalCount += 4
                    } else if (count + 1 < s.length && 'X' == s[count + 1]) {
                        breakNextLoop = true
                        totalCount += 9
                    } else {
                        totalCount += 1
                    }
                } else if ('V' == s[count]) {
                    totalCount += 5
                } else if ('X' == s[count]) {
                    if (count + 1 < s.length && 'L' == s[count + 1]) {
                        breakNextLoop = true
                        totalCount += 40
                    } else if (count + 1 < s.length && 'C' == s[count + 1]) {
                        breakNextLoop = true
                        totalCount += 90
                    } else {
                        totalCount += 10
                    }
                } else if ('L' == s[count]) {
                    totalCount += 50
                } else if ('C' == s[count]) {
                    if (count + 1 < s.length && 'D' == s[count + 1]) {
                        breakNextLoop = true
                        totalCount += 400
                    } else if (count + 1 < s.length && 'M' == s[count + 1]) {
                        breakNextLoop = true
                        totalCount += 900
                    } else {
                        totalCount += 100
                    }
                } else if ('D' == s[count]) {
                    totalCount += 500
                } else if ('M' == s[count]) {
                    totalCount += 1000
                }
            }
            return totalCount
        }
    }
}