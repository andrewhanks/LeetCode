package questions


class Question_825_Friends_Of_Appropriate_Ages {

    companion object {

        fun runQuestion() {
//            Input: ages = [73,106,39,6,26,15,30,100,71,35,46,112,6,60,110]
//            Output: 29
            val nums = intArrayOf(73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110)
            val result = numFriendRequests(nums)
            println("Question 825: $result")
        }

        fun numFriendRequests(ages: IntArray): Int {
            ages.sortDescending()
            var ans = 0
            // println("ages = ${ages.contentToString()}")
            for (i in 0..ages.size - 2) {
                for (j in i + 1..ages.size - 1) {
                    if (ages[i] == ages[j] && ages[i] > 14) {
                        ans += 2
                    } else if (ages[j] > ages[i] * 0.5 + 7) {
                        ans++
                    }
                }
            }
            return ans
        }

        fun numFriendRequestsWithCumulativeArray(ages: IntArray): Int {
            val result = IntArray(121) { 0 }
            for (i in 0..ages.size - 1) {
                result[ages[i]]++
            }
            for (i in 1..result.size - 1) {
                result[i] = result[i - 1] + result[i]
            }
            var ans = 0
            for (i in 0..result.size - 1) {
                if (i <= 14) {
                    continue
                }
                val min = (i * 0.5 + 7).toInt() + 1
                if (i - 1 >= min) {
                    ans += (result[i] - result[i - 1]) * (result[i - 1] - result[min - 1])
                }
                if ((result[i] - result[i - 1]) > 1) {
                    ans += (result[i] - result[i - 1]) * (result[i] - result[i - 1] - 1)
                }
            }
            return ans
        }
    }
}