package questions


class Question_2517_Maximum_Tastiness_of_Candy_Basket {

    companion object {

        fun runQuestion() {
//            Input: price = [13,5,1,8,21,2], k = 3
//            Output: 8
            val price = intArrayOf(13, 5, 1, 8, 21, 2)
            val k = 3
            val result = maximumTastiness(price, k)
            println("Question 2517: $result")
        }

        fun maximumTastiness(price: IntArray, k: Int): Int {
            price.sort()
            println("price = ${price.joinToString()}")
            var high = price[price.size - 1]
            var low = 1
            while (low < high) {
                val mid = low + (high - low) / 2
                println("mid = $mid, high = $high, low = $low")
                if (bfs(mid, price, k)) {
                    low = mid + 1
                } else {
                    high = mid
                }
            }
            return low - 1
        }

        fun bfs(mid: Int, price: IntArray, k: Int): Boolean {
            var last = price[0]
            var number = k
            number--
            for (count in 1..price.size - 1) {
                if (price[count] - last >= mid) {
                    last = price[count]
                    number--
                }
            }
            return number <= 0
        }
    }
}