package questions

class Question_3218_Minimum_Cost_for_Cutting_Cake_I {

    companion object {

        fun runQuestion() {
//            Input: m = 3, n = 2, horizontalCut = [1,3], verticalCut = [5]
//            Output: 13
            val m = 3
            val n = 2
            val horizontalCut = intArrayOf(1, 3)
            val verticalCut = intArrayOf(5)
            val result = minimumCost(m, n, horizontalCut, verticalCut)
            println("Question 3218: $result")
        }

        fun minimumCost(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Int {
            return cut(horizontalCut.toMutableList(), verticalCut.toMutableList())
        }

        fun cut(horizontalCut: MutableList<Int>, verticalCut: MutableList<Int>): Int {
            if (horizontalCut.size == 0 && verticalCut.size == 0) {
                return 0
            }
            if (verticalCut.size == 1 && horizontalCut.size == 0) {
                return verticalCut[0]
            }
            if (horizontalCut.size == 1 && verticalCut.size == 0) {
                return horizontalCut[0]
            }
            val horizontalMax = if (horizontalCut.size == 0) {
                0
            } else {
                horizontalCut.max()
            }
            val verticalMax = if (verticalCut.size == 0) {
                0
            } else {
                verticalCut.max()
            }
            if (horizontalMax >= verticalMax) {
                val horizontalIndex = horizontalCut.indexOf(horizontalMax)
                return cut(horizontalCut.subList(0, horizontalIndex), verticalCut) +
                        cut(horizontalCut.subList(horizontalIndex + 1, horizontalCut.size), verticalCut) +
                        horizontalMax
            } else {
                val verticalIndex = verticalCut.indexOf(verticalMax)
                return cut(horizontalCut, verticalCut.subList(0, verticalIndex)) +
                        cut(horizontalCut, verticalCut.subList(verticalIndex + 1, verticalCut.size)) +
                        verticalMax
            }
        }
    }
}