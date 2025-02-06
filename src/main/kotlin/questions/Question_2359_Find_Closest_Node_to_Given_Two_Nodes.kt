package questions

import java.util.*
import kotlin.math.max
import kotlin.math.min


class Question_2359_Find_Closest_Node_to_Given_Two_Nodes {

    companion object {

        fun runQuestion() {
//            Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
//            Output: 2
            val edges = intArrayOf(2, 2, 3, -1)
            val node1 = 0
            val node2 = 1
            val result = closestMeetingNode(edges, node1, node2)
            println("Question 2359: $result")
        }

        fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
            if (node1 == node2) {
                return node1
            }
            val set1: MutableSet<Int> = mutableSetOf()
            val set2: MutableSet<Int> = mutableSetOf()
            val queue1: Queue<Int> = LinkedList()
            val queue2: Queue<Int> = LinkedList()
            queue1.add(node1)
            queue2.add(node2)
            var ans = Int.MAX_VALUE
            while (!queue1.isEmpty() || !queue2.isEmpty()) {
                // println("============================")
                var match = false
                if (!queue1.isEmpty()) {
                    val node1Now = queue1.remove()
                    set1.add(node1Now)
                    if (set2.contains(node1Now)) {
                        ans = node1Now
                        match = true
                    } else if (edges[node1Now] != -1 && !set1.contains(edges[node1Now])) {
                        queue1.add(edges[node1Now])
                    }
                }
                if (!queue2.isEmpty()) {
                    val node2Now = queue2.remove()
                    set2.add(node2Now)
                    if (set1.contains(node2Now)) {
                        if (node2Now < ans) {
                            ans = node2Now
                        }
                        match = true
                    } else if (edges[node2Now] != -1 && !set2.contains(edges[node2Now])) {
                        queue2.add(edges[node2Now])
                    }
                }
                // println("set1 = $set1, set2 = $set2")
                if (match) {
                    break
                }
            }
            if (ans == Int.MAX_VALUE) {
                return -1
            }
            return ans
        }

        fun closestMeetingNodeAccordingToQuestionMeaning(edges: IntArray, node1: Int, node2: Int): Int {
            val node1ReachList = IntArray(edges.size) { -1 }
            val node2ReachList = IntArray(edges.size) { -1 }
            var now = node1
            var stepsNow = 0
            node1ReachList[node1] = 0
            while (edges[now] != -1 && node1ReachList[edges[now]] == -1) {
                stepsNow++
                node1ReachList[edges[now]] = stepsNow
                now = edges[now]
            }
            // println("node1ReachList = ${node1ReachList.contentToString()}")
            now = node2
            stepsNow = 0
            node2ReachList[node2] = 0
            while (edges[now] != -1 && node2ReachList[edges[now]] == -1) {
                stepsNow++
                node2ReachList[edges[now]] = stepsNow
                now = edges[now]
            }
            // println("node2ReachList = ${node2ReachList.contentToString()}")
            var ans = -1
            var globalMax = Int.MAX_VALUE
            for (i in 0..node1ReachList.size - 1) {
                if (node1ReachList[i] == -1 || node2ReachList[i] == -1) {
                    continue
                }
                val max = max(node1ReachList[i], node2ReachList[i])
                if (max < globalMax) {
                    globalMax = max
                    ans = i
                } else if (max == globalMax) {
                    ans = min(ans, i)
                }
            }
            return ans
        }
    }
}