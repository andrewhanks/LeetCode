package questions

class Question_2384_Largest_Palindromic_Number {

    companion object {

        fun runQuestion() {
//            Input: num = "444947137"
//            Output: "7449447"
            val num = "444947137"
            val result = largestPalindromic(num)
            println("Question 2384: $result")
        }

        fun largestPalindromic(num: String): String {
            val store = IntArray(10) { 0 }
            for (count in 0..num.length - 1) {
                store[num[count] - '0'] += 1
            }
            // println("store = ${store.contentToString()}")
            val result = StringBuilder()
            var hasAnotherNumber = false
            for (count in store.size - 1 downTo 0) {
                if (count == 0 && !hasAnotherNumber) {
                    break
                }
                while (store[count] >= 2) {
                    if (result.isEmpty()) {
                        result.append((count + '0'.toInt()).toChar())
                        result.append((count + '0'.toInt()).toChar())
                    } else {
                        result.insert(result.length / 2, (count + '0'.toInt()).toChar())
                        result.insert(result.length / 2, (count + '0'.toInt()).toChar())
                    }
                    store[count] -= 2
                    hasAnotherNumber = true
                }
                // println("result = ${result.toString()}")
            }
            for (count in store.size - 1 downTo 0) {
                if (store[count] == 1) {
                    result.insert(result.length / 2, (count + '0'.toInt()).toChar())
                    break
                }
            }
            if (result.isEmpty()) {
                return "0"
            }
            return result.toString()
        }
    }
}