package questions

import java.util.*

class Question_950_Reveal_Cards_In_Increasing_Order {

    companion object {

        fun runQuestion() {
//            Input: deck = [17,13,11,2,3,5,7]
//            Output: [2,13,3,11,5,17,7]
            val deck = intArrayOf(17, 13, 11, 2, 3, 5, 7)
            val result = deckRevealedIncreasing(deck)
            println("Question 950: ${result.contentToString()}")
        }

        fun deckRevealedIncreasing(deck: IntArray): IntArray {
            val queue: Queue<Int> = LinkedList()
            for (count in 0..deck.size - 1) {
                queue.add(count)
            }
            deck.sort()
            val orderList: MutableList<Int> = mutableListOf()
            while (!queue.isEmpty()) {
                val index = queue.remove()
                orderList.add(index)
                if (!queue.isEmpty()) {
                    queue.add(queue.remove())
                }
            }
            // println("deck = ${deck.contentToString()}")
            // println("orderList = $orderList")
            val ans = IntArray(deck.size) { 0 }
            for (count in 0..deck.size - 1) {
                ans[orderList[count]] = deck[count]
            }
            return ans
        }
    }
}