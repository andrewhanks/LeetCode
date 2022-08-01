package questions

class Question_1346_Check_If_N_and_Its_Double_Exist {

    companion object {

        fun runQuestion() {
            val numberArray = intArrayOf(10, 2, 5, 3)
            val result = checkIfExist(numberArray)
            println("Question 1346: $result")
        }

        fun checkIfExist(arr: IntArray): Boolean {
            arr.forEachIndexed { index1, number1 ->
                arr.forEachIndexed { index2, number2 ->
                    if (2 * number1 == number2 && index1 != index2) {
                        return true
                    }
                }
            }
            return false
        }
    }
}