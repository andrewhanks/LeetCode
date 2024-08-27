package questions

class Question_2423_Remove_Letter_To_Equalize_Frequency {

    companion object {

        fun runQuestion() {
//            Input: word = "abcc"
//            Output: true
            val word = "abcc"
            val result = equalFrequency(word)
            println("Question 2423: $result")
        }

        fun equalFrequency(word: String): Boolean {
            var finalAns = false
            for (i in 0..word.length - 1) {
                val result = IntArray(26) { 0 }
                for (j in 0..word.length - 1) {
                    if (i == j) {
                        continue
                    }
                    result[word[j] - 'a']++
                }
                var hasFreq = -1
                var ans = true
                for (j in 0..result.size - 1) {
                    if (result[j] == 0) {
                        continue
                    }
                    if (hasFreq == -1) {
                        hasFreq = result[j]
                    } else {
                        if (hasFreq != result[j]) {
                            ans = false
                        }
                    }
                }
                finalAns = finalAns || ans
            }
            return finalAns
        }
    }
}