package questions

import java.util.*

class Question_907_Sum_of_Subarray_Minimums {

    companion object {

        fun runQuestion() {
//            Input: arr = [3,1,2,4]
//            Output: 17
            val arr = intArrayOf(3, 1, 2, 4)
            val result = sumSubarrayMins(arr)
            println("Question 907: $result")
        }

        // will TLE
        fun sumSubarrayMinsBruteForce(arr: IntArray): Int {
            var sum = 0
            for (count in 1..arr.size) {
                for (subArray in 0..arr.size - count) {
                    sum += arr.copyOfRange(subArray, subArray + count).toList().minOrNull() ?: 0
                }
            }
            return sum
        }

        val mod = 1000000000 + 7

        fun sumSubarrayMins(arr: IntArray): Int {
            val stack: Stack<Pair<Int, Int>> = Stack()  // <值, 貢獻>

            var answer = 0 // 答案
            var sum = 0 // 維護當前 stack 內的總和
            for (value in arr) {
                var weight = 1
                while (!stack.empty() && value < stack.peek().first) { // 刪除棧頂所有比當前數字大的數字，以維護單調性
                    sum -= stack.peek().first * stack.peek().second // 維護棧內 sum 的值
                    weight += stack.peek().second // 每刪除一個數字，就吸收了他的貢獻
                    stack.pop();
                }
                stack.push(Pair(value, weight))
                sum += value * weight // 維護棧內 sum 的值
                answer = (answer + sum % mod) % mod // sum 為以 value 為右邊界的所有區間的最小值的和
            }
            return answer
        }
    }
}