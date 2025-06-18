package questions

class Question_2952_Minimum_Number_of_Coins_to_be_Added {

    companion object {

        fun runQuestion() {
//            Input: coins = [1,1,1], target = 20
//            Output: 3
            val coins = intArrayOf(1, 1, 1)
            val target = 20
            val result = minimumAddedCoins(coins, target)
            println("Question 2952: $result")
        }

        fun minimumAddedCoins(coins: IntArray, target: Int): Int {
            var limit = 0
            var ans = 0
            var i = 0
            coins.sort()
            while (limit < target) {
                if (i == coins.size || limit + 1 < coins[i]) {
                    ans++
                    limit = 2 * limit + 1
                } else {
                    limit = limit + coins[i]
                    i++
                }
            }
            return ans
        }
    }
}