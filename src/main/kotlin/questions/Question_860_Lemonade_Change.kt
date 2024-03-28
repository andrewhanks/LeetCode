package questions

class Question_860_Lemonade_Change {

    companion object {

        fun runQuestion() {
//            Input: bills = [5,5,10,10,20]
//            Output: false
            val bills = intArrayOf(5, 5, 10, 10, 20)
            val result = lemonadeChange(bills)
            println("Question 860: $result")
        }

        fun lemonadeChange(bills: IntArray): Boolean {
            var num5 = 0
            var num10 = 0
            var num20 = 0
            for (count in 0..bills.size - 1) {
                if (bills[count] != 5 && num5 == 0) {
                    return false
                } else {
                    if (bills[count] == 5) {
                        num5++
                    } else if (bills[count] == 10) {
                        if (num5 > 0) {
                            num5--
                            num10++
                        } else {
                            return false
                        }
                    } else if (bills[count] == 20) {
                        if ((num10 >= 1 && num5 >= 1) || num5 >= 3) {
                            if (num10 >= 1) {
                                num10--
                                num5--
                            } else {
                                num5 -= 3
                            }
                        } else {
                            return false
                        }
                    }
                }
            }
            return true
        }
    }
}