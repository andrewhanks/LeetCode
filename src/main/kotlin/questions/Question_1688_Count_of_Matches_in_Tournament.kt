package questions

class Question_1688_Count_of_Matches_in_Tournament {

    companion object {

        fun runQuestion() {
//            Input: n = 7
//            Output: 6
            val n = 7
            val result = numberOfMatches(n)
            println("Question 1688: $result")
        }

        fun numberOfMatches(n: Int): Int {
            var rest = n
            var total = 0
            while (rest > 1) {
                if (rest % 2 == 0) {
                    total += rest / 2
                    rest = rest / 2
                } else {
                    total += rest / 2
                    rest = rest / 2 + 1
                }
            }
            return total
        }
    }
}