package questions

import java.util.*


class Question_841_Keys_and_Rooms {

    companion object {

        fun runQuestion() {
//            Input: rooms = [[1],[2],[3],[]]
//            Output: true
            val rooms = listOf(listOf(1), listOf(2), listOf(3), listOf(1))
            val result = canVisitAllRooms(rooms)
            println("Question 841: $result")
        }

        fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
            val queue: Queue<Int> = LinkedList()
            val unlocked: MutableList<Boolean> = MutableList(rooms.size) { false }
            queue.add(0)
            unlocked[0] = true
            while (!queue.isEmpty()) {
                val room = queue.remove()
                for (key in rooms[room]) {
                    if (unlocked[key]) {
                        continue;
                    }
                    unlocked[key] = true
                    queue.add(key)
                }
            }
            val allUnlocked = (unlocked.filter { it }.count() == unlocked.size)
            return allUnlocked
        }
    }
}