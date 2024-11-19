package questions


class Question_2420_Find_All_Good_Indices {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,1,1,1,3,4,1], k = 2
//            Output: [2,3]
            val nums = intArrayOf(2, 1, 1, 1, 3, 4, 1)
            val k = 2
            val result = goodIndices(nums, k)
            println("Question 2420: $result")
        }

        fun goodIndices(nums: IntArray, k: Int): List<Int> {
            if (nums.size < 2 * k + 1) {
                return listOf()
            }
            val nonIncreasingList: MutableList<Int> = mutableListOf()
            val isNonIncreasing = Array(nums.size - 2 * k) { false }
            val nonDecreasingList: MutableList<Int> = mutableListOf()
            val isNonDecreasing = Array(nums.size - 2 * k) { false }
            for (i in 0..nums.size - 1 - k - 1) {
                if (nonIncreasingList.isEmpty() || (k >= 2 && nums[i] <= nonIncreasingList[nonIncreasingList.size - 1]) || k == 1) {
                    if (nonIncreasingList.size >= k) {
                        nonIncreasingList.removeAt(0)
                    }
                } else {
                    nonIncreasingList.clear()
                }
                nonIncreasingList.add(nums[i])
                if (nonIncreasingList.size == k) {
                    isNonIncreasing[i - k + 1] = true
                }
            }
            for (i in k + 1..nums.size - 1) {
                if (nonDecreasingList.isEmpty() || (k >= 2 && nums[i] >= nonDecreasingList[nonDecreasingList.size - 1]) || k == 1) {
                    if (nonDecreasingList.size >= k) {
                        nonDecreasingList.removeAt(0)
                    }
                } else {
                    nonDecreasingList.clear()
                }
                nonDecreasingList.add(nums[i])
                if (nonDecreasingList.size == k) {
                    isNonDecreasing[i - 2 * k] = true
                }
            }
            // println("isNonIncreasing = ${isNonIncreasing.contentToString()}, isNonDecreasing = ${isNonDecreasing.contentToString()}")
            var ans: MutableList<Int> = mutableListOf()
            for (count in 0..isNonIncreasing.size - 1) {
                if (isNonIncreasing[count] && isNonDecreasing[count]) {
                    ans.add(count + k)
                }
            }
            return ans.toList()
        }
    }
}