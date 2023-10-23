package questions

class Question_210_Course_Schedule_II {

    companion object {

        fun runQuestion() {
//            Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//            Output: [0,2,1,3]
            val prerequisites = arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 1), intArrayOf(3, 2))
            val numCourses = 4
            val resultList = findOrder(numCourses, prerequisites)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 210: $result")
        }

        fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
            val result: MutableList<MutableList<Int>> = MutableList(numCourses) { mutableListOf() }
            val ans: MutableSet<Int> = mutableSetOf()
            for (count in 0..prerequisites.size - 1) {
                result[prerequisites[count][0]].add(prerequisites[count][1])
            }
            val visited = IntArray(numCourses) { 0 }
            for (count in 0..numCourses - 1) {
                if (dfs(count, result, visited, ans)) {
                    return intArrayOf()
                }
            }
            return ans.toIntArray()
        }

        fun dfs(
            currentCourse: Int,
            result: MutableList<MutableList<Int>>,
            visited: IntArray,
            ans: MutableSet<Int>
        ): Boolean {
            if (visited[currentCourse] == 1) {
                return true
            }
            if (visited[currentCourse] == 2) {
                ans.add(currentCourse)
                return false
            }
            visited[currentCourse] = 1
            for (count in 0..result[currentCourse].size - 1) {
                if (dfs(result[currentCourse][count], result, visited, ans)) {
                    return true
                }
            }
            visited[currentCourse] = 2
            ans.add(currentCourse)
            return false
        }
    }
}