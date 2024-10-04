package questions

import java.util.*
import kotlin.math.min


class Question_1130_Minimum_Cost_Tree_From_Leaf_Values {

    companion object {

        fun runQuestion() {
//            Input: arr = [6,2,4]
//            Output: 32
            val arr = intArrayOf(6, 2, 4)
            val result = mctFromLeafValues(arr)
            println("Question 1130: $result")
        }

        fun mctFromLeafValues(arr: IntArray): Int {
            val dp = Array(arr.size) { IntArray(arr.size) { 0 } }
            for (len in 2..dp.size) {
                for (i in 0..dp.size - 1 - len + 1) {
                    val j = i + len - 1
                    if (len == 2) {
                        dp[i][j] = arr[i] * arr[j]
                        continue
                    }
                    var current = Int.MAX_VALUE
                    for (k in i..j - 1) {
                        val left = arr.slice(i..k).max()
                        val right = arr.slice(k + 1..j).max()
                        current = min(current, dp[i][k] + dp[k + 1][j] + left * right)
                    }
                    dp[i][j] = current
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            return dp[0][dp[0].size - 1]
        }

        fun mctFromLeafValuesWithPrevAndNextGreaters(arr: IntArray): Int {
            val prevGreater = IntArray(arr.size) { Int.MAX_VALUE }
            val nextGreater = IntArray(arr.size) { Int.MAX_VALUE }
            val stack: Stack<Int> = Stack()
            for (count in 0..arr.size - 1) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[count]) {
                    val pos = stack.removeLast()
                    nextGreater[pos] = arr[count]
                }
                stack.add(count)
            }
            // println("nextGreater = ${nextGreater.contentToString()}")
            stack.clear()
            for (count in 0..arr.size - 1) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[count]) {
                    stack.removeLast()
                }
                if (!stack.isEmpty()) {
                    prevGreater[count] = arr[stack.peek()]
                }
                stack.add(count)
            }
            // println("prevGreater = ${prevGreater.contentToString()}")
            var ans = 0
            for (count in 0..arr.size - 1) {
                val min = min(nextGreater[count], prevGreater[count])
                if (min != Int.MAX_VALUE) {
                    ans += arr[count] * min
                }
            }
            return ans
        }
    }
}