package questions

class Question_1386_Cinema_Seat_Allocation {

    companion object {

        fun runQuestion() {
//            Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
//            Output: 4
            val n = 3
            val reservedSeats = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(1, 8),
                intArrayOf(2, 6),
                intArrayOf(3, 1),
                intArrayOf(3, 10)
            )
            val result = maxNumberOfFamilies(n, reservedSeats)
            println("Question 1386: $result")
        }

        fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
            val map: MutableMap<Int, MutableList<Boolean>> = mutableMapOf()
            for (count in 0..reservedSeats.size - 1) {
                val row = reservedSeats[count][0]
                val column = reservedSeats[count][1]
                if (map.contains(row)) {
                    map[row]!![column] = true
                } else {
                    val isOccupied = MutableList(11) { false }
                    isOccupied[column] = true
                    map[row] = isOccupied
                }
            }
            // println("map = $map")
            var ans = 0
            for ((key, value) in map) {
                var seat = 2
                var firstTaken = false
                if (isEnough(value, seat)) {
                    ans++
                    // println("add in $key, $seat")
                    firstTaken = true
                }
                var secondTaken = false
                if (!firstTaken) {
                    seat = 4
                    if (isEnough(value, seat)) {
                        ans++
                        // println("add in $key, $seat")
                        secondTaken = true
                    }
                }
                if (!secondTaken) {
                    seat = 6
                    if (isEnough(value, seat)) {
                        ans++
                        // println("add in $key, $seat")
                    }
                }
            }
            ans += (n - map.size) * 2
            return ans
        }

        fun isEnough(list: MutableList<Boolean>, seat: Int): Boolean {
            // println("list = $list")
            var isEnough = true
            for (count in 0..3) {
                if (list[seat + count]) {
                    isEnough = false
                    break
                }
            }
            return isEnough
        }
    }
}