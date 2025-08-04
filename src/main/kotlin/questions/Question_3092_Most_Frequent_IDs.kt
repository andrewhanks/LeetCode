package questions

import java.util.*

class Question_3092_Most_Frequent_IDs {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,3,2,1], freq = [3,2,-3,1]
//            Output: [3,3,2,2]
            val nums = intArrayOf(2, 3, 2, 1)
            val freq = intArrayOf(3, 2, -3, 1)
            val result = mostFrequentIDs(nums, freq)
            println("Question 3092: ${result.contentToString()}")
        }

        fun mostFrequentIDs(nums: IntArray, freq: IntArray): LongArray {
            val map: MutableMap<Int, Long> = mutableMapOf()
            val timesMap: MutableMap<Long, Int> = mutableMapOf()
            val set: TreeSet<Long> = TreeSet()
            val ans = LongArray(nums.size) { 0L }
            for (i in 0..nums.size - 1) {
                val id = nums[i]
                val f = freq[i]
                // println("id = $id, f = $f")
                if (map[id] != null) {
                    timesMap[map[id]!!] = timesMap.getOrDefault(map[id]!!, 1) - 1
                    // println("timesMap[${map[id]}] = ${timesMap[map[id]!!]}")
                    if (timesMap[map[id]!!] == 0) {
                        set.remove(map[id]!!)
                    }
                }
                val total = map.getOrDefault(id, 0L) + f
                map[id] = total
                timesMap[total] = timesMap.getOrDefault(total, 0) + 1
                // println("timesMap[$total] = ${timesMap[total]}")
                set.add(total)
                ans[i] = set.last()
            }
            return ans
        }
    }
}