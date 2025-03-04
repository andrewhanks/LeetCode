package questions


class Question_1220_Count_Vowels_Permutation {

    companion object {

        fun runQuestion() {
//            Input: n = 2
//            Output: 10
            val n = 2
            val result = countVowelPermutation(n)
            println("Question 1220: $result")
        }

        fun countVowelPermutation(n: Int): Int {
            val mod = 1000000007
            val result = Array(5) { 1L }
            for (i in 2..n) {
                val temp = result.toList()
                result[0] = (temp[1] + temp[2] + temp[4]) % mod
                result[1] = (temp[0] + temp[2]) % mod
                result[2] = (temp[1] + temp[3]) % mod
                result[3] = (temp[2]) % mod
                result[4] = (temp[2] + temp[3]) % mod
            }
            // println("result = ${result.contentToString()}")
            val ans = result.sum() % mod
            return ans.toInt()
        }
    }
}