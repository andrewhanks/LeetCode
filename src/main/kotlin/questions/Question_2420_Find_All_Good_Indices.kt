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

        fun goodIndicesFromLeftAndRight(nums: IntArray, k: Int): List<Int> {
            if (nums.size < 2 * k + 1) {
                return listOf()
            }
            if (k == 1) {
                val ans: MutableList<Int> = mutableListOf()
                for (count in 1..nums.size - 2) {
                    ans.add(count)
                }
                return ans.toList()
            }
            var left = IntArray(nums.size) { 1 }
            var right = IntArray(nums.size) { 1 }
            val ans: MutableList<Int> = mutableListOf()
            for (i in 1..nums.size - 1) {
                if (nums[i] <= nums[i - 1]) {
                    left[i] = left[i - 1] + 1
                } else {
                    left[i] = 1
                }
            }
            for (i in nums.size - 2 downTo 0) {
                if (nums[i] <= nums[i + 1]) {
                    right[i] = right[i + 1] + 1
                } else {
                    right[i] = 1
                }
            }
            // println("left = ${left.contentToString()}, right = ${right.contentToString()}")
            for (i in k..nums.size - 1 - k) {
                if (left[i - 1] >= k && right[i + 1] >= k) {
                    ans.add(i)
                }
            }
            return ans.toList()
        }

        fun goodIndicesFaster(nums: IntArray, k: Int): List<Int> {
            if (nums.size < 2 * k + 1) {
                return listOf()
            }
            if (k == 1) {
                val ans: MutableList<Int> = mutableListOf()
                for (count in 1..nums.size - 2) {
                    ans.add(count)
                }
                return ans.toList()
            }
            var nonIncreasingCount = 0
            var nonDecreasingCount = 0
            val ans: MutableList<Int> = mutableListOf()
            for (i in 0..nums.size - k - 3) {
                if (nums[i + 1] <= nums[i]) {
                    if (nonIncreasingCount == k) {
                        nonIncreasingCount--
                    } else if (nonIncreasingCount == 0) {
                        nonIncreasingCount = 1
                    }
                } else {
                    nonIncreasingCount = 0
                }
                nonIncreasingCount++
                if (nums[i + k + 2] >= nums[i + k + 1]) {
                    if (nonDecreasingCount == k) {
                        nonDecreasingCount--
                    } else if (nonDecreasingCount == 0) {
                        nonDecreasingCount = 1
                    }
                } else {
                    nonDecreasingCount = 0
                }
                nonDecreasingCount++
                // println("nonIncreasingCount = $nonIncreasingCount, nonDecreasingCount = $nonDecreasingCount")
                if (nonIncreasingCount == k && nonDecreasingCount == k) {
                    ans.add(i + 2)
                }
            }
            return ans.toList()
        }
    }
}