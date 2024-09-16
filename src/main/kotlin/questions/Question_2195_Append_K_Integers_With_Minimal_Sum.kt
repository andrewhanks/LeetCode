package questions


class Question_2195_Append_K_Integers_With_Minimal_Sum {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,4,25,10,25], k = 2
//            Output: 5
            val nums = intArrayOf(1, 4, 25, 10, 25)
            val k = 2
            val result = minimalKSum(nums, k)
            println("Question 2195: $result")
        }

        fun minimalKSum(nums: IntArray, k: Int): Long {
            val sorted = nums.sorted()
            var smallerNumber = 0L
            var smallerTotal = 0L
            // println("sorted = ${sorted}")
            for (count in 0..sorted.size - 1) {
                if (sorted[count] <= k + smallerNumber) {
                    smallerNumber++
                    smallerTotal += sorted[count]
                }
                if (sorted[count] <= k + smallerNumber && count >= 1 && sorted[count] == sorted[count - 1]) {
                    smallerNumber--
                    smallerTotal -= sorted[count]
                }
            }
            var ans = (1 + k + smallerNumber) * (k + smallerNumber) / 2 - smallerTotal
            // println("smallerNumber = $smallerNumber, smallerTotal = $smallerTotal, ans = $ans")
            return ans
        }
    }
}