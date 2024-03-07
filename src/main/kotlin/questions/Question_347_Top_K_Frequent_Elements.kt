package questions

class Question_347_Top_K_Frequent_Elements {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,1,1,2,2,3], k = 2
//            Output: [1,2]
            val nums = intArrayOf(1, 1, 1, 2, 2, 3)
            val k = 2
            val result = topKFrequent(nums, k)
            println("Question 347: ${result.contentToString()}")
        }

        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            val result: MutableMap<Int, Int> = mutableMapOf()
            for (count in 0..nums.size - 1) {
                if (!result.contains(nums[count])) {
                    result.put(nums[count], 1)
                } else {
                    result[nums[count]] = result[nums[count]]!! + 1
                }
            }
            val temp = result.toList().sortedBy { (_, value) -> value }.reversed().toMap()
            val finalResult: MutableList<Int> = mutableListOf()
            var count = 0
            for ((key, value) in temp) {
                finalResult.add(key)
                count++
                if (count == k) {
                    break
                }
            }
            return finalResult.toIntArray()
        }
    }
}