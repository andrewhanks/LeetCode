package questions

class Question_16_3Sum_Closest {

    companion object {

        fun runQuestion() {
            val inputNums = intArrayOf(1, 1, -1, -1, 3)
            val inputTarget = -1
            val result = threeSumClosest(inputNums, inputTarget)
            println("Question 16: $result")
        }

        fun threeSumClosest(nums: IntArray, target: Int): Int {
            var result = Int.MAX_VALUE
            for (i in 0..nums.size - 1) {
                for (j in i + 1..nums.size - 1) {
                    for (k in j + 1..nums.size - 1) {
                        val tempResult = nums[i] + nums[j] + nums[k]
                        if (Int.MAX_VALUE < (result.toLong() - target.toLong()) ||
                            (Math.abs(tempResult - target) < Math.abs(result - target))
                        ) {
                            result = tempResult
                        }
                    }
                }
            }
            return result
        }

        fun threeSumClosestWebSolution(nums: IntArray, target: Int): Int {
            var result = nums[0] + nums[1] + nums[nums.size - 1]
            nums.sort()
            for (i in 0 until nums.size - 2) {
                var start = i + 1
                var end = nums.size - 1
                while (start < end) {
                    val sum = nums[i] + nums[start] + nums[end]
                    if (sum > target) {
                        end--
                    } else {
                        start++
                    }
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum
                    }
                }
            }
            return result
        }
    }
}