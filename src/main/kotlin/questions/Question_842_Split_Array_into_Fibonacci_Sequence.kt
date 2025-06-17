package questions

class Question_842_Split_Array_into_Fibonacci_Sequence {

    companion object {

        fun runQuestion() {
//            Input: num = "11235813"
//            Output: [1,1,2,3,5,8,13]
            val num = "11235813"
            val result = splitIntoFibonacci(num)
            println("Question 842: $result")
        }

        fun splitIntoFibonacci(num: String): List<Int> {
            val result: MutableList<Int> = mutableListOf()
            val ret = split(num, result)
            if (!ret) {
                return listOf()
            } else {
                return result
            }
        }

        fun split(num: String, result: MutableList<Int>): Boolean {
            val size = result.size
            if (num.isEmpty()) {
                if (size >= 3 && isFibLike(result)) {
                    return true
                }
                return false
            }
            for (i in 0..num.length - 1) {
                val numberLong = num.substring(0..i).toLong()
                if (numberLong > Int.MAX_VALUE) {
                    break
                }
                val number = numberLong.toInt()
                if (num[0] == '0' && number != 0) {
                    break
                }
                // println("result = $result, number = $number")
                val size = result.size
                if (size >= 2 && result[size - 1] + result[size - 2] != number) {
                    continue
                }
                result.add(number)
                if (split(num.substring(i + 1..num.length - 1), result)) {
                    return true
                }
                result.removeAt(result.size - 1)
            }
            return false
        }

        fun isFibLike(result: MutableList<Int>): Boolean {
            for (i in 2..result.size - 1) {
                if (result[i] != result[i - 1] + result[i - 2]) {
                    return false
                }
            }
            return true
        }
    }
}