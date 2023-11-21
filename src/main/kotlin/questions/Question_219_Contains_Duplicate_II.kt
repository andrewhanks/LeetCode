package questions


class Question_219_Contains_Duplicate_II {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,3,1], k = 3
//            Output: true
            val nums = intArrayOf(1, 2, 3, 1)
            val k = 3
            val result = containsNearbyDuplicate(nums, k)
            println("Question 219: $result")
        }

        fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
            for (x in 0..nums.size - 1) {
                for (y in 0..x - 1) {
                    if (nums[x] == nums[y] && x - y <= k) {
                        return true
                    }
                }
            }
            return false
        }

        fun containsNearbyDuplicateList(nums: IntArray, k: Int): Boolean {
            val result: MutableList<Int> = mutableListOf()
            for (x in 0..nums.size - 1) {
                if (!result.contains(nums[x])) {
                    result.add(nums[x])
                    if (result.size > k) {
                        result.removeAt(0)
                    }
                } else {
                    return true
                }
            }
            return false
        }

        fun containsNearbyDuplicateSet(nums: IntArray, k: Int): Boolean {
            val set = HashSet<Int>()
            for (i in nums.indices) {
                if (i > k) {
                    set.remove(nums[i - k - 1])
                }
                if (!set.add(nums[i])) {
                    return true
                }
            }
            return false
        }
    }
}