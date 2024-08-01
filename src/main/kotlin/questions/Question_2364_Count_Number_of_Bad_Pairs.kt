package questions

class Question_2364_Count_Number_of_Bad_Pairs {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,1,3,3]
//            Output: 5
            val array = intArrayOf(4, 1, 3, 3)
            val result = countBadPairs(array)
            println("Question 2364: $result")
        }

        fun countBadPairs(nums: IntArray): Long {
            val map: MutableMap<Int, Long> = mutableMapOf()
            for (count in 0..nums.size - 1) {
                val diff = count - nums[count]
                if (!map.contains(diff)) {
                    map.put(diff, 1)
                } else {
                    map[diff] = map[diff]!! + 1
                }
            }
            var goodPairs = 0L
            for ((key, value) in map) {
                if (value >= 2) {
                    goodPairs += value * (value - 1) / 2
                }
            }
            var totalPairs = nums.size.toLong() * (nums.size - 1).toLong() / 2
            return totalPairs - goodPairs
        }
    }
}