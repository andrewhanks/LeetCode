package questions


class Question_2261_K_Divisible_Elements_Subarrays {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,3,3,2,2], k = 2, p = 2
//            Output: 11
            val nums = intArrayOf(2, 3, 3, 2, 2)
            val k = 2
            val p = 2
            val result = countDistinct(nums, k, p)
            println("Question 2261: $result")
        }

        fun countDistinct(nums: IntArray, k: Int, p: Int): Int {
            val divisible = Array(nums.size) { false }
            val ans: MutableSet<List<Int>> = mutableSetOf()
            for (i in 0..nums.size - 1) {
                if (nums[i] % p == 0) {
                    divisible[i] = true
                }
            }
            for (i in 1..nums.size) {
                for (j in 0..nums.size - 1 - i + 1) {
                    var total = 0
                    for (l in j..j + i - 1) {
                        if (divisible[l]) {
                            total++
                        }
                    }
                    // println("j = $j, j+i-1 = ${j+i-1}, total = $total")
                    if (total <= k) {
                        val item = nums.slice(j..j + i - 1)
                        // println("item = $item")
                        ans.add(item)
                    }
                }
            }
            return ans.size
        }

        fun countDistinctFasterSolution(nums: IntArray, k: Int, p: Int): Int {
            val divisible = Array(nums.size) { false }
            val ans: MutableSet<MutableList<Int>> = mutableSetOf()
            for (i in 0..nums.size - 1) {
                if (nums[i] % p == 0) {
                    divisible[i] = true
                }
            }
            for (i in 0..nums.size - 1) {
                var item: MutableList<Int> = mutableListOf()
                var total = 0
                for (j in i..nums.size - 1) {
                    if (divisible[j]) {
                        total++
                    }
                    if (total <= k) {
                        item.add(nums[j])
                        ans.add(item.toMutableList())
                    } else {
                        break
                    }
                }
            }
            return ans.size
        }
    }
}