package questions


class Question_1238_Circular_Permutation_in_Binary_Representation {

    companion object {

        fun runQuestion() {
//            Input: n = 3, start = 2
//            Output: [2,6,7,5,4,0,1,3]
            val n = 3
            val start = 2
            val result = circularPermutation(n, start)
            println("Question 1238: $result")
        }

//        original -> reverse copy -> add leftmost bit
//        00          00              000
//        01          01              001
//        11          11              011
//        10          10              010
//                    10              110
//                    11              111
//                    01              101
//                    00              100
        fun circularPermutation(n: Int, start: Int): List<Int> {
            val codes: MutableList<Int> = mutableListOf()
            codes.add(0)
            for (i in 0..n - 1) {
                for (j in codes.size - 1 downTo 0) {
                    val greyCode = codes[j] + (1 shl i)
                    codes.add(greyCode)
                }
            }
            var startIndex = 0
            for (i in 0..codes.size - 1) {
                if (codes[i] == start) {
                    startIndex = i
                    break
                }
            }
            val ans = MutableList<Int>(codes.size) { 0 }
            for (i in 0..ans.size - 1) {
                ans[i] = codes[(i + startIndex) % codes.size]
            }
            return ans
        }
    }
}