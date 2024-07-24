package questions


class Question_3080_Mark_Elements_on_Array_by_Performing_Queries {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,2,1,2,3,1], queries = [[1,2],[3,3],[4,2]]
//            Output: [8,3,0]
            val nums = intArrayOf(1, 2, 2, 1, 2, 3, 1)
            val queries = arrayOf(intArrayOf(1, 2), intArrayOf(3, 3), intArrayOf(4, 2))
            val result = unmarkedSumArray(nums, queries)
            println("Question 57: ${result.contentToString()}")
        }

        fun unmarkedSumArray(nums: IntArray, queries: Array<IntArray>): LongArray {
            var sum = 0L
            for (count in 0..nums.size - 1) {
                sum += nums[count].toLong()
            }
            val result: MutableList<Long> = mutableListOf()
            val sorted: MutableList<Int> = mutableListOf()
            for (count in 0..nums.size - 1) {
                sorted.add(count)
            }
            sorted.sortWith(Comparator { a, b ->
                nums[a] - nums[b]
            })
            var index = 0
            for (count in 0..queries.size - 1) {
                val markValue = nums[queries[count][0]]
                sum -= markValue
                nums[queries[count][0]] = 0

                var markNumber = 0
                while (markNumber < queries[count][1] && index <= sorted.size - 1) {
                    if (nums[sorted[index]] != 0) {
                        sum -= nums[sorted[index]]
                        nums[sorted[index]] = 0
                        markNumber++
                    }
                    index++
                }
                // println("nums = $nums, sorted = ${sorted}, sum = $sum")
                result.add(sum)
            }
            return result.toLongArray()
        }
    }
}