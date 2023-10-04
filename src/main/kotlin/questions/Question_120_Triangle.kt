package questions

import kotlin.math.min


class Question_120_Triangle {

    companion object {

        fun runQuestion() {
//            Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//            Output: 11
            val intArray = listOf(listOf(2), listOf(3, 4), listOf(6, 5, 7), listOf(4, 1, 8, 3))
            val result = minimumTotal(intArray)
            println("Question 120: $result")
        }

        fun minimumTotal(triangle: List<List<Int>>): Int {
            val tempTriangle: MutableList<MutableList<Int>> = mutableListOf()
            for (count in 1..triangle.size) {
                tempTriangle.add(MutableList(count) { 0 })
            }
            for (count in triangle.size - 1 downTo 0) {
                for (pos in 0..count) {
                    if (count == tempTriangle.size - 1) {
                        tempTriangle[count][pos] = triangle[count][pos]
                    } else {
                        tempTriangle[count][pos] =
                            min(tempTriangle[count + 1][pos], tempTriangle[count + 1][pos + 1]) + triangle[count][pos]
                    }
                }
            }
            println(tempTriangle)
            return tempTriangle[0][0]
        }
    }
}