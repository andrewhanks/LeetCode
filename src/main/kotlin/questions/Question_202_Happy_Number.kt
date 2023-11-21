package questions

class Question_202_Happy_Number {

    companion object {

        fun runQuestion() {
//            Input: n = 19
//            Output: true
            val n = 19
            val result = isHappy(n)
            println("Question 202: $result")
        }

        fun isHappy(n: Int): Boolean {
            val result: MutableList<Int> = mutableListOf()
            result.add(n)
            var tempN = n
            while (tempN > 1) {
                var nextNumber = helper(tempN)
                if (result.contains(nextNumber)) {
                    return false
                }
                result.add(nextNumber)
                tempN = nextNumber
            }
            return true
        }

        fun isHappyTwoPointers(n: Int): Boolean {
            var slow = n
            var fast = n
            while (slow != 1 && fast != 1) {
                slow = helper(slow)
                fast = helper(helper(fast))
                if (slow == 1 || fast == 1) {
                    return true
                } else if (slow == fast) {
                    return false
                }
            }
            return true
        }

        fun helper(n: Int): Int {
            var tempN = n
            var sum = 0
            while (tempN > 0) {
                sum += (tempN % 10) * (tempN % 10)
                tempN = tempN / 10
            }
            return sum
        }
    }
}