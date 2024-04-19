package questions

import kotlin.math.min
import kotlin.math.sqrt

class Question_279_Perfect_Squares {

    companion object {

        fun runQuestion() {
//            Input: n = 12
//            Output: 3
            val n = 12
            val result = numSquares(n)
            println("Question 279: $result")
        }

        fun numSquares(n: Int): Int {
            val dp = IntArray(n + 1) { -1 }
            return dfs(n, dp)
        }

        fun dfs(n: Int, dp: IntArray): Int {
            if (n <= 0) return 0
            if (dp[n] != -1) return dp[n]

            var ans = n
            var i = 1
            while (i * i <= n) {
                ans = min(ans, (1 + dfs(n - i * i, dp)))
                i++
            }
            dp[n] = ans
            return dp[n]
        }

        fun numSquaresWithMathTrick(n: Int): Int {
            // Math trick!!
            // Any number can be represented by 4 perfect squares
            // but since the question asks for minimum let us try is 1, 2, 3 are possible or else return 4

            // 1 is possible when a number is a perfect square
            val sqrt = sqrt(n.toDouble()).toInt()
            if (sqrt * sqrt == n) return 1

            // 2 is possible if a^2+b^2=n T:O(root(n))
            var i = 1
            while (i * i <= n) {
                val rest = n - i * i
                val numsqrt = sqrt(rest.toDouble()).toInt()
                // check if rest is also a perfect square
                if (numsqrt * numsqrt == rest) return 2
                i++
            }

            // now for 3: a number can be expressed a sum of three
            // perfect squares only it the number is not of the form
            // n!=4^k(8m+7). So instead of checking for non equality
            // if n is of this form, it would imply it is sum of 4 perfect squares minimum.
            // else let us return a 3
            var tempN = n
            while (tempN % 4 == 0) tempN = tempN / 4
            return if ((tempN - 7) % 8 == 0) {
                4
            } else {
                3
            }
        }
    }
}