package questions

import java.util.*
import kotlin.math.abs

class Question_2449_Minimum_Number_of_Operations_to_Make_Arrays_Similar {

    companion object {

        fun runQuestion() {
//            Input: nums = [8,12,6], target = [2,14,10]
//            Output: 2
            val nums = intArrayOf(8, 12, 6)
            val target = intArrayOf(2, 14, 10)
            val result = makeSimilar(nums, target)
            println("Question 2449: $result")
        }

        fun makeSimilar(nums: IntArray, target: IntArray): Long {
            val numsOdd: PriorityQueue<Int> = PriorityQueue()
            val numsEven: PriorityQueue<Int> = PriorityQueue()
            val targetOdd: PriorityQueue<Int> = PriorityQueue()
            val targetEven: PriorityQueue<Int> = PriorityQueue()
            for (count in 0..nums.size - 1) {
                if (nums[count] % 2 == 0) {
                    numsEven.add(nums[count])
                } else {
                    numsOdd.add(nums[count])
                }
            }
            for (count in 0..target.size - 1) {
                if (target[count] % 2 == 0) {
                    targetEven.add(target[count])
                } else {
                    targetOdd.add(target[count])
                }
            }
            var ans = 0L
            for (count in 0..numsOdd.size - 1) {
                val nums = numsOdd.remove()
                val target = targetOdd.remove()
                ans += abs(nums - target)
            }
            for (count in 0..numsEven.size - 1) {
                val nums = numsEven.remove()
                val target = targetEven.remove()
                ans += abs(nums - target)
            }
            return ans / 4
        }
    }
}