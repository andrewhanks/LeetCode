package questions

import java.util.*


class Question_1298_Maximum_Candies_You_Can_Get_from_Boxes {

    companion object {

        fun runQuestion() {
//            Input: status = [1,0,1,0], candies = [7,5,4,100], keys = [[],[],[1],[]],
//                   containedBoxes = [[1,2],[3],[],[]], initialBoxes = [0]
//            Output: 16
            val status = intArrayOf(1, 0, 1, 0)
            val candies = intArrayOf(7, 5, 4, 100)
            val keys = arrayOf(intArrayOf(), intArrayOf(), intArrayOf(1), intArrayOf())
            val containedBoxes = arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(), intArrayOf())
            val initialBoxes = intArrayOf(0)
            val result = maxCandies(status, candies, keys, containedBoxes, initialBoxes)
            println("Question 1298: $result")
        }

        fun maxCandies(
            status: IntArray,
            candies: IntArray,
            keys: Array<IntArray>,
            containedBoxes: Array<IntArray>,
            initialBoxes: IntArray
        ): Int {
            val openedBoxes = BooleanArray(status.size) { false }
            val ownKeys = BooleanArray(status.size) { false }
            val ownBoxes: Queue<Int> = LinkedList(initialBoxes.asList())
            var answer = 0
            while (!ownBoxes.isEmpty()) {
                val prevList = ownBoxes.toMutableList()
                val size = ownBoxes.size
                for (i in 0..size - 1) {
                    val currentBox = ownBoxes.remove()
                    // println("status[$currentBox] = ${status[currentBox]}, ownKeys[$currentBox] = ${ownKeys[currentBox]}")
                    if (status[currentBox] == 1 || (status[currentBox] == 0 && ownKeys[currentBox] == true)) {
                        openedBoxes[currentBox] = true
                        answer += candies[currentBox]
                        for (box in containedBoxes[currentBox]) {
                            if (!ownBoxes.contains(box)) {
                                ownBoxes.add(box)
                            }
                        }
                        for (key in keys[currentBox]) {
                            ownKeys[key] = true
                        }
                    } else {
                        ownBoxes.add(currentBox)
                    }
                    // println("answer = $answer, ownBoxes.size = ${ownBoxes.size}")
                }
                if (prevList == ownBoxes.toMutableList()) {
                    break
                }
            }
            return answer
        }

        fun maxCandiesWithOpenedParam(
            status: IntArray,
            candies: IntArray,
            keys: Array<IntArray>,
            containedBoxes: Array<IntArray>,
            initialBoxes: IntArray
        ): Int {
            val openedBoxes = BooleanArray(status.size) { false }
            val ownKeys = BooleanArray(status.size) { false }
            val ownBoxes: Queue<Int> = LinkedList(initialBoxes.asList())
            var answer = 0
            var opened = true
            while (!ownBoxes.isEmpty() && opened) {
                opened = false
                val size = ownBoxes.size
                for (i in 0..size - 1) {
                    val currentBox = ownBoxes.remove()
                    // println("status[$currentBox] = ${status[currentBox]}, ownKeys[$currentBox] = ${ownKeys[currentBox]}")
                    if (status[currentBox] == 1 || (status[currentBox] == 0 && ownKeys[currentBox] == true)) {
                        opened = true
                        openedBoxes[currentBox] = true
                        answer += candies[currentBox]
                        for (box in containedBoxes[currentBox]) {
                            if (!ownBoxes.contains(box)) {
                                ownBoxes.add(box)
                            }
                        }
                        for (key in keys[currentBox]) {
                            ownKeys[key] = true
                        }
                    } else {
                        ownBoxes.add(currentBox)
                    }
                    // println("answer = $answer, ownBoxes.size = ${ownBoxes.size}")
                }
            }
            return answer
        }
    }
}