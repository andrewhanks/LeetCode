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

        fun countPrimesSieveOfEratosthenesAlgorithm(n: Int): Int {
            if (n == 0 || n == 1) {
                return 0
            }
            val result: MutableList<Boolean> = MutableList(n) { true }
            result[0] = false
            result[1] = false
            val sqrtNumber = sqrt((n - 1).toDouble()).toInt()
            for (x in 2..sqrtNumber) {
                if (result[x] == true) {
                    var y = 2
                    while (y * x <= n - 1) {
                        result[y * x] = false
                        y++
                    }
                }
            }
            //println(result)
            return result.filter { it == true }.count()
        }
    }
}