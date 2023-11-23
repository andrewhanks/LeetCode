package questions

import kotlin.math.abs

class Question_1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box {

    companion object {

        fun runQuestion() {
//            Input: boxes = "001011"
//            Output: [11,8,5,4,3,4]
            val boxes = "001011"
            val resultList = minOperations(boxes)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 1769: $result")
        }

        fun minOperations(boxes: String): IntArray {
            val result: IntArray = IntArray(boxes.length) { 0 }
            for (x in 0..boxes.length - 1) {
                var sum = 0
                for (y in 0..boxes.length - 1) {
                    if (x == y) {
                        continue
                    }
                    if (boxes[y] == '1') {
                        sum = sum + abs(y - x)
                    }
                }
                result[x] = sum
            }
            return result
        }
    }
}