package questions


class Question_2860_Happy_Students {

    companion object {

        fun runQuestion() {
//            Input: nums = [6,0,3,3,6,7,2,7]
//            Output: 3
            val nums = listOf(6, 0, 3, 3, 6, 7, 2, 7)
            val result = countWays(nums)
            println("Question 2860: $result")
        }

        fun countWays(nums: List<Int>): Int {
            val temp = nums.sorted()
            var ans = if (temp[0] > 0) {
                1
            } else {
                0
            }
            for (count in 0..temp.size - 1) {
                if (count + 1 <= temp.size - 1) {
                    if (count + 1 > temp[count] && count + 1 < temp[count + 1]) {
                        ans++
                    }
                } else {
                    if (count + 1 > temp[count]) {
                        ans++
                    }
                }
            }
            return ans
        }
    }
}