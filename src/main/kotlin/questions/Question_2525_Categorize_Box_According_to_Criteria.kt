package questions


class Question_2525_Categorize_Box_According_to_Criteria {

    companion object {

        fun runQuestion() {
//            Input: length = 1000, width = 35, height = 700, mass = 300
//            Output: "Heavy"
            val length = 1000
            val width = 35
            val height = 700
            val mass = 300
            val result = categorizeBox(length, width, height, mass)
            println("Question 2525: $result")
        }

        fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {
            return if (isBulky(length, width, height) && mass >= 100) {
                "Both"
            } else if (isBulky(length, width, height) && mass < 100) {
                "Bulky"
            } else if (!isBulky(length, width, height) && mass >= 100) {
                "Heavy"
            } else {
                "Neither"
            }
        }

        fun isBulky(length: Int, width: Int, height: Int): Boolean {
            val volume: Long = length.toLong() * width * height
            println(volume)
            if (volume >= 1000000000) {
                return true
            }
            if (length >= 10000 || width >= 10000 || height >= 10000) {
                return true
            }
            return false
        }
    }
}