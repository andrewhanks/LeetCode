package questions

import kotlin.math.min
import kotlin.math.pow

class Question_2826_Sorting_Three_Groups {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,1,3,2,1]
//            Output: 3
            val nums = listOf(2, 1, 3, 2, 1)
            val result = minimumOperations(nums)
            println("Question 2826: $result")
        }

        fun minimumOperations(nums: List<Int>): Int {
            val max = (3.0).pow(nums.size).toInt()
            var ans = Int.MAX_VALUE
            var bitList = MutableList(nums.size) { 0 }
            for (i in 0..nums.size) {
                for (j in 0..nums.size) {
                    bitList = generateBitList(i, j, nums.size)
                    var diff = 0
                    for (k in 0..nums.size - 1) {
                        if (bitList[k] != nums[k]) {
                            diff++
                        }
                    }
                    // println("bitList = $bitList, diff = $diff")
                    ans = min(ans, diff)
                }
            }
            return ans
        }

        fun generateBitList(oneEnd: Int, twoEnd: Int, size: Int): MutableList<Int> {
            val list = MutableList(size) { 0 }
            var curr = 0
            while (curr <= size - 1) {
                if (curr < oneEnd) {
                    list[curr] = 1
                } else if (curr >= oneEnd && curr < twoEnd) {
                    list[curr] = 2
                } else {
                    list[curr] = 3
                }
                curr++
            }
            return list
        }
    }
}