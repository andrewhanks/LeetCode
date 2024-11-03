package questions

import java.util.*

class Question_2233_Maximum_Product_After_K_Increments {

    companion object {

        fun runQuestion() {
//            Input: nums = [6,3,3,2], k = 2
//            Output: 216
            val nums = intArrayOf(6, 3, 3, 2)
            val k = 2
            val result = maximumProduct(nums, k)
            println("Question 2233: $result")
        }

        fun maximumProduct(nums: IntArray, k: Int): Int {
            val mod = 1000000007
            val queue: PriorityQueue<Int> = PriorityQueue { a, b ->
                a - b
            }
            for (count in 0..nums.size - 1) {
                queue.add(nums[count])
            }
            for (count in 1..k) {
                val num = queue.remove()
                queue.add(num + 1)
            }
            var ans = 1L
            while (!queue.isEmpty()) {
                val num = queue.remove()
                ans = ans * num % mod
            }
            return ans.toInt()
        }
    }
}