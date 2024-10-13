package questions


class Question_1266_Minimum_Time_Visiting_All_Points {

    companion object {

        fun runQuestion() {
//            Input: points = [[1,1],[3,4],[-1,0]]
//            Output: 7
            val intArray = arrayOf(intArrayOf(1, 1), intArrayOf(3, 4), intArrayOf(-1, 0))
            val result = minTimeToVisitAllPoints(intArray)
            println("Question 1266: $result")
        }

        fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
            var result = 0
            for (count in 0..points.size - 2) {
                result += Math.max(
                    Math.abs(points[count][0] - points[count + 1][0]),
                    Math.abs(points[count][1] - points[count + 1][1])
                )
            }
            return result
        }
    }
}