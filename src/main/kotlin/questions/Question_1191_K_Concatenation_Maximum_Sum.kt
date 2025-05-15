package questions

import kotlin.math.max
import kotlin.math.min


class Question_1191_K_Concatenation_Maximum_Sum {

    companion object {

        fun runQuestion() {
//            Input: arr = [1,-2,1], k = 5
//            Output: 2
            val arr = intArrayOf(1, -2, 1)
            val k = 5
            val result = kConcatenationMaxSum(arr, k)
            println("Question 1191: $result")
        }

        fun kConcatenationMaxSum(arr: IntArray, k: Int): Int {
            val mod = 1000000007
            var sum = 0L
            for (i in 0..arr.size - 1) {
                sum = sum + arr[i]
                sum = sum % mod
            }
            if (sum < 0) {
                var max = 0L
                sum = 0
                var count = if (k <= 1) {
                    arr.size
                } else {
                    arr.size * 2
                }
                for (i in 0..count - 1) {
                    sum = sum + arr[i % arr.size]
                    sum = sum % mod
                    max = max(max, sum)
                    if (sum < 0) {
                        sum = 0
                    }
                }
                return max.toInt()
            }
            var minFromLeft = 0L
            var sumFromLeft = 0L
            for (i in 0..arr.size - 1) {
                sumFromLeft = sumFromLeft + arr[i]
                minFromLeft = min(minFromLeft, sumFromLeft)
            }
            var minFromRight = 0L
            var sumFromRight = 0L
            for (i in arr.size - 1 downTo 0) {
                sumFromRight = sumFromRight + arr[i]
                minFromRight = min(minFromRight, sumFromRight)
            }
            // println("sum = $sum, minFromLeft = $minFromLeft, minFromRight = $minFromRight")
            val ans = ((sum * k) % mod - minFromLeft - minFromRight) % mod
            return max(0, ans.toInt())
        }

        fun kConcatenationMaxSumAnotherSolution(arr: IntArray, k: Int): Int {
            val mod = 1000000007
            val count = if (k == 1) {
                arr.size - 1
            } else {
                arr.size * 2 - 1
            }
            var max = 0L
            var sum = 0L
            for (i in 0..count) {
                sum = sum + arr[i % arr.size]
                max = max(max, sum)
                if (sum < 0) {
                    sum = 0
                }
            }
            var total = 0L
            for (i in 0..arr.size - 1) {
                total = total + arr[i]
            }
            // println("max = $max, total = $total")
            if (total <= 0L || k <= 2) {
                return (max % mod).toInt()
            } else {
                return ((total * (k - 2) + max) % mod).toInt()
            }
        }
    }
}