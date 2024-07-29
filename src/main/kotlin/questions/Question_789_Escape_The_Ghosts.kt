package questions

import kotlin.math.abs


class Question_789_Escape_The_Ghosts {

    companion object {

        fun runQuestion() {
//            Input: ghosts = [[1,0],[0,3]], target = [0,1]
//            Output: true
            val ghosts = arrayOf(intArrayOf(1, 0), intArrayOf(0, 3))
            val target = intArrayOf(0, 1)
            val result = escapeGhosts(ghosts, target)
            println("Question 789: $result")
        }

        fun escapeGhosts(ghosts: Array<IntArray>, target: IntArray): Boolean {
            val distance = abs(target[0]) + abs(target[1])
            for (count in 0..ghosts.size - 1) {
                val tempDis = abs(ghosts[count][0] - target[0]) + abs(ghosts[count][1] - target[1])
                if (tempDis <= distance) {
                    return false
                }
            }
            return true
        }
    }
}