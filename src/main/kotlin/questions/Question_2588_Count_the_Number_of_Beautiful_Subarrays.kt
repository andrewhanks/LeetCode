package questions

class Question_2588_Count_the_Number_of_Beautiful_Subarrays {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,3,1,2,4]
//            Output: 2
            val intArray = intArrayOf(4, 3, 1, 2, 4)
            val result = beautifulSubarrays(intArray)
            println("Question 2588: $result")
        }

        fun beautifulSubarrays(nums: IntArray): Long {
            val map: MutableMap<Int, Int> = mutableMapOf()
            var ans = 0L
            var current = 0
            map.put(0, 1)
            for (i in 0..nums.size - 1) {
                current = current xor nums[i]
                ans = ans + map.getOrDefault(current, 0)
                map[current] = map.getOrDefault(current, 0) + 1
            }
            return ans
        }
    }
}