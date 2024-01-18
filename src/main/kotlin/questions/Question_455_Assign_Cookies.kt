package questions

class Question_455_Assign_Cookies {

    companion object {

        fun runQuestion() {
//            Input: g = [1,2], s = [1,2,3]
//            Output: 2
            val g = intArrayOf(1, 2)
            val s = intArrayOf(1, 2, 3)
            val result = findContentChildren(g, s)
            println("Question 455: $result")
        }

        fun findContentChildren(g: IntArray, s: IntArray): Int {
            g.sortDescending()
            s.sortDescending()
            var gCount = 0
            var sCount = 0
            var childCount = 0
            while (gCount <= g.size - 1 && sCount <= s.size - 1) {
                if (s[sCount] >= g[gCount]) {
                    childCount++
                    gCount++
                    sCount++
                } else if (s[sCount] < g[gCount]) {
                    gCount++
                }
            }
            return childCount
        }

        fun findContentChildrenWithTwoLoops(g: IntArray, s: IntArray): Int {
            g.sortDescending()
            s.sortDescending()
            var childCount = 0
            for (gCount in 0..g.size - 1) {
                for (sCount in 0..s.size - 1) {
                    if (s[sCount] >= g[gCount]) {
                        s[sCount] = 0
                        childCount++
                        break
                    }
                }
            }
            return childCount
        }
    }
}