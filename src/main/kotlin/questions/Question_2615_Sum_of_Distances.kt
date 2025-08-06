package questions

class Question_2615_Sum_of_Distances {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,3,1,1,2]
//            Output: [5,0,3,4,0]
            val nums = intArrayOf(1, 3, 1, 1, 2)
            val result = distance(nums)
            println("Question 2615: ${result.contentToString()}")
        }

        fun distance(nums: IntArray): LongArray {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            val totalMap: MutableMap<Int, Long> = mutableMapOf()
            val ans = LongArray(nums.size) { 0L }
            for (i in 0..nums.size - 1) {
                map.putIfAbsent(nums[i], mutableListOf())
                map[nums[i]]!!.add(i)
                totalMap[nums[i]] = totalMap.getOrDefault(nums[i], 0L) + i
            }
            for ((key, list) in map) {
                if (list.size == 1) {
                    continue
                }
                var acc = 0L
                for (i in 0..list.size - 1) {
                    val total = totalMap[key]
                    if (total == null) {
                        continue
                    }
                    val index = list[i]
                    val iLong = i.toLong()
                    acc += index
                    ans[index] = (iLong + 1) * index - acc - (list.size - iLong - 1) * index + (total - acc)
                }
            }
            return ans
        }
    }
}