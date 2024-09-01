package questions

import java.util.*

class Question_1311_Get_Watched_Videos_by_Your_Friends {

    companion object {

        fun runQuestion() {
//            Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
//            Output: ["B","C"]
            val watchedVideos = listOf(listOf("A", "B"), listOf("C"), listOf("B", "C"), listOf("D"))
            val friends = arrayOf(intArrayOf(1, 2), intArrayOf(0, 3), intArrayOf(0, 3), intArrayOf(1, 2))
            val id = 0
            val level = 1
            val result = watchedVideosByFriends(watchedVideos, friends, id, level)
            println("Question 1311: $result")
        }

        fun watchedVideosByFriends(
            watchedVideos: List<List<String>>,
            friends: Array<IntArray>,
            id: Int,
            level: Int
        ): List<String> {
            val visited = Array(friends.size) { false }
            val map: MutableMap<String, Int> = mutableMapOf()
            var currentLevel = 0
            val queue: Queue<Int> = LinkedList()
            queue.add(id)
            visited[id] = true
            while (!queue.isEmpty()) {
                val size = queue.size
                for (i in 0..size - 1) {
                    val node = queue.remove()
                    if (currentLevel == level) {
                        for (j in 0..watchedVideos[node].size - 1) {
                            val video = watchedVideos[node][j]
                            map[video] = map.getOrDefault(video, 0) + 1
                        }
                    } else {
                        for (j in 0..friends[node].size - 1) {
                            val friendId = friends[node][j]
                            if (visited[friendId]) {
                                continue
                            }
                            queue.add(friendId)
                            visited[friendId] = true
                        }
                    }
                }
                currentLevel++
            }
            val result: MutableList<String> = mutableListOf()
            val priorityQueue = PriorityQueue<Pair<String, Int>> { a, b ->
                if (a.second != b.second) {
                    a.second - b.second
                } else {
                    a.first.compareTo(b.first)
                }
            }
            for ((key, value) in map) {
                priorityQueue.add(Pair(key, value))
            }
            while (!priorityQueue.isEmpty()) {
                val item = priorityQueue.remove()
                result.add(item.first)
            }
            return result
        }
    }
}