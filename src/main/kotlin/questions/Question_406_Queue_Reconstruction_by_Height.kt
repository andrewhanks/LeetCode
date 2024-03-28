package questions


class Question_406_Queue_Reconstruction_by_Height {

    companion object {

        fun runQuestion() {
//            Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//            Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
            val people = arrayOf(
                intArrayOf(7, 0),
                intArrayOf(4, 4),
                intArrayOf(7, 1),
                intArrayOf(5, 0),
                intArrayOf(6, 1),
                intArrayOf(5, 2)
            )
            val result = reconstructQueue(people)
            println("Question 406: ${result.contentDeepToString()}")
        }

        fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
            val sortedPeople = people.sortedBy { -it[0] }.sortedBy { it[1] }
            val result: MutableList<IntArray> = mutableListOf()
            for (count in 0..sortedPeople.size - 1) {
                if (count == 0) {
                    result.add(sortedPeople[count])
                } else {
                    var front = 0
                    var added = false
                    for (position in 0..result.size - 1) {
                        if (front == sortedPeople[count][1]) {
                            result.add(position, sortedPeople[count])
                            added = true
                            break
                        }
                        if (result[position][0] >= sortedPeople[count][0]) {
                            front++
                        }
                    }
                    if (!added) {
                        result.add(result.size, sortedPeople[count])
                    }
                }
            }
            return result.toTypedArray()
        }
    }
}