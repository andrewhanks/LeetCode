package questions


class Question_1936_Add_Minimum_Number_of_Rungs {

    companion object {

        fun runQuestion() {
//            Input: rungs = [1,3,5,10], dist = 2
//            Output: 2
            val rungs = intArrayOf(1, 3, 5, 10)
            val dist = 2
            val result = addRungs(rungs, dist)
            println("Question 1936: $result")
        }

        fun addRungs(rungs: IntArray, dist: Int): Int {
            var insert = 0
            for (count in 0..rungs.size - 1) {
                var diff = 0
                if (count == 0) {
                    diff = rungs[count] - 0
                } else {
                    diff = rungs[count] - rungs[count - 1]
                }
                if (diff > dist) {
                    insert = insert + diff / dist
                    if (diff % dist == 0) {
                        insert = insert - 1
                    }
                }
            }
            return insert
        }
    }
}