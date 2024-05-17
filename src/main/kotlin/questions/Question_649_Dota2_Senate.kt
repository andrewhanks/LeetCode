package questions

import java.util.*

class Question_649_Dota2_Senate {

    companion object {

        fun runQuestion() {
//            Input: senate = "RD"
//            Output: "Radiant"
            val senate = "RD"
            val result = predictPartyVictory(senate)
            println("Question 649: $result")
        }

        // https://medium.com/@cindy20303705/leetcode-649-dota2-senate-%E8%A7%A3%E6%B3%95-dcb9933a853c
        fun predictPartyVictory(senate: String): String {
            val rQueue: Queue<Int> = LinkedList()
            val dQueue: Queue<Int> = LinkedList()
            for (count in 0..senate.length - 1) {
                if (senate[count] == 'R') {
                    rQueue.add(count)
                } else {
                    dQueue.add(count)
                }
            }
            var count = 0
            while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
                if (rQueue.contains(count)) {
                    rQueue.remove()
                    rQueue.add(count + senate.length)
                    dQueue.remove()
                } else if (dQueue.contains(count)) {
                    dQueue.remove()
                    dQueue.add(count + senate.length)
                    rQueue.remove()
                }
                count++
            }
            return if (!rQueue.isEmpty()) {
                "Radiant"
            } else {
                "Dire"
            }
        }
    }
}