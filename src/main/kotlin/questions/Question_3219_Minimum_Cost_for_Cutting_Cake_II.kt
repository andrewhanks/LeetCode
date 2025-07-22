package questions


class Question_3219_Minimum_Cost_for_Cutting_Cake_II {

    companion object {

        fun runQuestion() {
//            Input: m = 3, n = 2, horizontalCut = [1,3], verticalCut = [5]
//            Output: 13
            val m = 3
            val n = 2
            val horizontalCut = intArrayOf(1, 3)
            val verticalCut = intArrayOf(5)
            val result = minimumCost(m, n, horizontalCut, verticalCut)
            println("Question 3219: $result")
        }

        fun minimumCost(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Long {
            var ans = 0L
            var cutV = 1
            var cutH = 1
            var sortH = horizontalCut.sortedWith(Comparator { a, b ->
                b - a
            })
            var sortV = verticalCut.sortedWith(Comparator { a, b ->
                b - a
            })
            var indexH = 0
            var indexV = 0
            for (i in 0..m + n - 1) {
                val currH = if (indexH <= sortH.size - 1) {
                    sortH[indexH]
                } else {
                    0
                }
                val currV = if (indexV <= sortV.size - 1) {
                    sortV[indexV]
                } else {
                    0
                }
                if (currH > currV) {
                    ans += currH * cutV
                    cutH++
                    indexH++
                } else if (currH < currV) {
                    ans += currV * cutH
                    cutV++
                    indexV++
                } else {
                    if (cutV <= cutH) {
                        ans += currH * cutV
                        cutH++
                        indexH++
                    } else {
                        ans += currV * cutH
                        cutV++
                        indexV++
                    }
                }
                // println("ans = $ans")
            }
            return ans
        }

        fun minimumCostAnotherSolution(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Long {
            var ans = 0L
            var cutV = 1
            var cutH = 1
            var sortH = horizontalCut.sorted()
            var sortV = verticalCut.sorted()
            var indexH = m - 2
            var indexV = n - 2
            while (indexH >= 0 && indexV >= 0) {
                if (sortH[indexH] >= sortV[indexV]) {
                    ans += sortH[indexH] * cutV
                    cutH++
                    indexH--
                } else {
                    ans += sortV[indexV] * cutH
                    cutV++
                    indexV--
                }
            }
            while (indexH >= 0) {
                ans += sortH[indexH] * cutV
                indexH--
            }
            while (indexV >= 0) {
                ans += sortV[indexV] * cutH
                indexV--
            }
            return ans
        }
    }
}