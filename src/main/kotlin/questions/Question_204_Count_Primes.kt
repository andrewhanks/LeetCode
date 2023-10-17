package questions

import kotlin.math.sqrt


class Question_204_Count_Primes {

    companion object {

        fun runQuestion() {
            val n = 10
            val result = countPrimes(n)
            println("Question 204: $result")
        }

        fun countPrimes(n: Int): Int {
            var primeCount = 0
            for (count in 2..n - 1) {
                val sqrtValue = sqrt(count.toDouble()).toInt()
                var isPrime = true
                for (number in 2..sqrtValue) {
                    if (count % number == 0) {
                        isPrime = false
                        break
                    }
                }
                if (isPrime) {
                    primeCount++
                }
            }
            return primeCount
        }
    }
}