package questions


class Question_2563_Count_the_Number_of_Fair_Pairs {

    companion object {

        fun runQuestion() {
//            Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
//            Output: 6
            val nums = intArrayOf(0, 1, 7, 4, 4, 5)
            val lower = 3
            val upper = 6
            val result = countFairPairs(nums, lower, upper)
            println("Question 2563: $result")
        }

        fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
            nums.sort()
            // println("nums = ${nums.contentToString()}")
            var ans = 0L
            for (i in 0..nums.size - 1) {
                val start = searchFirstItem(nums, i + 1, lower - nums[i])
                val end = searchLastItem(nums, i + 1, upper - nums[i])
                // println("nums[$i] = ${nums[i]}, start = $start, end = $end")
                if (end < start) {
                    continue
                }
                ans = ans + end - start
            }
            return ans
        }

        fun searchFirstItem(nums: IntArray, start: Int, target: Int): Int {
            var start = start
            var end = nums.size
            while (start < end) {
                val mid = start + (end - start) / 2
                if (nums[mid] >= target) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return start
        }

        fun searchLastItem(nums: IntArray, start: Int, target: Int): Int {
            var start = start
            var end = nums.size
            while (start < end) {
                val mid = start + (end - start) / 2
                if (nums[mid] > target) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return start
        }
    }
}