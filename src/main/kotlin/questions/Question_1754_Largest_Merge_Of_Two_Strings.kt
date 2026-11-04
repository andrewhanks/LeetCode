package questions

class Question_1754_Largest_Merge_Of_Two_Strings {

    companion object {

        fun runQuestion() {
//            Input: word1 = "cabaa", word2 = "bcaaa"
//            Output: "cbcabaaaaa"
            val word1 = "cabaa"
            val word2 = "bcaaa"
            val result = largestMerge(word1, word2)
            println("Question 1754: $result")
        }

        fun largestMerge(word1: String, word2: String): String {
            val m = word1.length
            val n = word2.length
            var ans = StringBuilder()
            var i = 0
            var j = 0
            while (i <= m - 1 && j <= n - 1) {
                if (word1[i] > word2[j]) {
                    ans.append(word1[i])
                    i++
                } else if (word2[j] > word1[i]) {
                    ans.append(word2[j])
                    j++
                } else {
                    var add = 0
                    while (i + add <= m - 1 && j + add <= n - 1 && word1[i + add] == word2[j + add]) {
                        add++
                    }
                    if (i + add > m - 1 && j + add <= n - 1) {
                        var extra = if (j + add - 1 + 1 <= n - 1 && word2[j + add - 1 + 1] >= word1[i]) {
                            true
                        } else {
                            false
                        }
                        if (extra) {
                            for (count in j..j + add) {
                                ans.append(word2[count])
                            }
                            j = j + add + 1
                        } else {
                            for (count in i..m - 1) {
                                ans.append(word1[count])
                            }
                            i = i + add + 1
                        }
                    } else if (j + add > n - 1 && i + add <= m - 1) {
                        var extra = if (i + add - 1 + 1 <= m - 1 && word1[i + add - 1 + 1] >= word2[j]) {
                            true
                        } else {
                            false
                        }
                        if (extra) {
                            for (count in i..i + add) {
                                ans.append(word1[count])
                            }
                            i = i + add + 1
                        } else {
                            for (count in j..n - 1) {
                                ans.append(word2[count])
                            }
                            j = j + add + 1
                        }
                    } else if (i + add > m - 1 && j + add > n - 1) {
                        ans.append(word1[i])
                        i++
                    } else {
                        if (word1[i + add] > word2[j + add]) {
                            ans.append(word1[i])
                            i++
                        } else if (word2[j + add] > word1[i + add]) {
                            ans.append(word2[j])
                            j++
                        }
                    }
                }
            }
            while (i <= word1.length - 1) {
                ans.append(word1[i])
                i++
            }
            while (j <= word2.length - 1) {
                ans.append(word2[j])
                j++
            }
            return ans.toString()
        }
    }
}