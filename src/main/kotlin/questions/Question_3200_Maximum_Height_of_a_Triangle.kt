package questions

import kotlin.math.max

class Question_3200_Maximum_Height_of_a_Triangle {

    companion object {

        fun runQuestion() {
//            Input: red = 2, blue = 4
//            Output: 3
            val red = 2
            val blue = 4
            val result = maxHeightOfTriangle(red, blue)
            println("Question 3200: $result")
        }

        fun maxHeightOfTriangle(red: Int, blue: Int): Int {
            var max = 0
            var count = 0
            var tempRed = red
            var tempBlue = blue
            // first level is red
            while (true) {
                count++
                if (count % 2 == 1 && tempRed - count >= 0) {
                    tempRed -= count
                } else if (count % 2 == 0 && tempBlue - count >= 0) {
                    tempBlue -= count
                } else {
                    break
                }
            }
            count--
            max = max(max, count)
            count = 0
            tempRed = red
            tempBlue = blue
            // first level is blue
            while (true) {
                count++
                if (count % 2 == 1 && tempBlue - count >= 0) {
                    tempBlue -= count
                } else if (count % 2 == 0 && tempRed - count >= 0) {
                    tempRed -= count
                } else {
                    break
                }
            }
            count--
            max = max(max, count)
            return max
        }
    }
}