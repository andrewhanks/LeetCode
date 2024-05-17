package questions

class Question_673_Number_of_Longest_Increasing_Subsequence {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,3,5,4,7]
//            Output: 2
            val array = intArrayOf(1, 3, 5, 4, 7)
            val result = findNumberOfLIS(array)
            println("Question 673: $result")
        }

        // https://hackmd.io/@Hungen/Hkaq1EB9i?utm_source=preview-mode&utm_medium=rec
        fun findNumberOfLIS(nums: IntArray): Int {
            val size = IntArray(nums.size) { 1 }
            val count = IntArray(nums.size) { 1 }
            for (i in 0..nums.size - 1) {
                for (j in 0..i - 1) {
                    if (nums[j] >= nums[i]) {
                        continue
                    }
                    if (size[j] >= size[i]) {
                        size[i] = size[j] + 1
                        count[i] = count[j]
                    } else if (size[j] + 1 == size[i]) {
                        count[i] += count[j]
                    }
                    // println("size = ${size.contentToString()}, count = ${count.contentToString()}")
                }
            }
            val max = size.max()
            var sum = 0
            for (i in 0..size.size - 1) {
                if (size[i] == max) {
                    sum += count[i]
                }
            }
            return sum
        }
    }
}