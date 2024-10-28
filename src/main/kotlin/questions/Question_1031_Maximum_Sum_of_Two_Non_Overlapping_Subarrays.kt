package questions

import kotlin.math.max

class Question_1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays {

    companion object {

        fun runQuestion() {
//            Input: nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
//            Output: 20
            val nums = intArrayOf(0, 6, 5, 2, 2, 5, 1, 9, 4)
            val firstLen = 1
            val secondLen = 2
            val result = maxSumTwoNoOverlap(nums, firstLen, secondLen)
            println("Question 1031: $result")
        }

        fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
            val firstSum = IntArray(nums.size - firstLen + 1) { 0 }
            val secondSum = IntArray(nums.size - secondLen + 1) { 0 }
            var sum = 0
            for (i in 0..nums.size - 1) {
                sum += nums[i]
                if (i >= firstLen - 1) {
                    if (i - firstLen >= 0) {
                        sum -= nums[i - firstLen]
                    }
                    firstSum[i - firstLen + 1] = sum
                }
            }
            sum = 0
            for (i in 0..nums.size - 1) {
                sum += nums[i]
                if (i >= secondLen - 1) {
                    if (i - secondLen >= 0) {
                        sum -= nums[i - secondLen]
                    }
                    secondSum[i - secondLen + 1] = sum
                }
            }
            var ans = 0
            for (i in 0..firstSum.size - 1) {
                for (j in 0..secondSum.size - 1) {
                    if ((j >= i && j <= i + firstLen - 1) || (j + secondLen - 1 >= i && j + secondLen - 1 <= i + firstLen - 1) ||
                        (i >= j && i + firstLen - 1 <= j + secondLen - 1)
                    ) {
                        continue
                    }
                    ans = max(ans, firstSum[i] + secondSum[j])
                    // println("firstSum[$i~${i+firstLen-1}] = ${firstSum[i]}, secondSum[$j~${j+secondLen-1}] = ${secondSum[j]}, ans = $ans")
                }
            }
            return ans
        }
    }
}