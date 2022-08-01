package questions

class Question_9_Palindrome_Number {

    companion object {

        fun runQuestion() {
            val inputInt = 121
            val result = isPalindrome(inputInt)
            println("Question 9: $result")
        }

        fun isPalindrome(x: Int): Boolean {
            val countFromFront = x.toString()
            val countFromBack = x.toString().reversed()
            return countFromFront == countFromBack
        }
    }
}