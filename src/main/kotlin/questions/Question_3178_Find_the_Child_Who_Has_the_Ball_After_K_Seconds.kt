package questions

class Question_3178_Find_the_Child_Who_Has_the_Ball_After_K_Seconds {

    companion object {

        fun runQuestion() {
//            Input: n = 3, k = 5
//            Output: 1
            val n = 3
            val k = 5
            val result = numberOfChild(n, k)
            println("Question 3178: $result")
        }

        fun numberOfChild(n: Int, k: Int): Int {
            var tempK = k % (2 * n - 2)
            var dir = 0
            var result = 0
            // println("-----------------------")
            for (count in 0..tempK - 1) {
                // println("dir = $dir")
                if (dir == 0) {
                    result++
                    // println("count = $count, n = $n, result = $result")
                    if (result == n - 1) {
                        dir = 1
                    }
                } else {
                    result--
                }
            }
            return result
        }
    }
}