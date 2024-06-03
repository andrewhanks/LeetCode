package questions

import models.GraphNode
import java.util.*

class Question_133_Clone_Graph {

    companion object {

        fun runQuestion() {
//            Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
//            Output: [[2,4],[1,3],[2,4],[1,3]]
            val graphNode1 = GraphNode(1)
            val graphNode2 = GraphNode(2)
            val graphNode3 = GraphNode(3)
            val graphNode4 = GraphNode(4)
            graphNode1.neighbors.add(graphNode2)
            graphNode1.neighbors.add(graphNode4)
            graphNode2.neighbors.add(graphNode1)
            graphNode2.neighbors.add(graphNode3)
            graphNode3.neighbors.add(graphNode2)
            graphNode3.neighbors.add(graphNode4)
            graphNode4.neighbors.add(graphNode1)
            graphNode4.neighbors.add(graphNode3)
            val graphNodes = graphNode1
            val node = cloneGraph(graphNodes)
            var result = "["
            result = Utils.printGraphNode(result, node)
            result += "]"
            println("Question 133: $result")
        }

        fun cloneGraph(node: GraphNode?): GraphNode? {
            if (node == null) {
                return null
            }
            val result: Array<GraphNode?> = Array(100) { null }
            val queue: Queue<GraphNode> = LinkedList()
            queue.add(node)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                val currentValue = node?.`val`!!
                if (result[currentValue - 1] == null) {
                    result[currentValue - 1] = GraphNode(currentValue)
                }
                val temp: MutableList<GraphNode> = mutableListOf()
                for (count in 0..node?.neighbors?.size!! - 1) {
                    val value = node?.neighbors!![count]?.`val`!!
                    if (node?.neighbors!![count] != null) {
                        if (result[value - 1] == null) {
                            queue.add(node?.neighbors!![count])
                            result[value - 1] = GraphNode(value)
                        }
                        temp.add(result[value - 1]!!)
                    }
                }
                result[currentValue - 1]?.neighbors?.addAll(temp)
            }
            return result[0]
        }

        fun cloneGraphOldSolution(node: GraphNode?): GraphNode? {
            if (node == null) {
                return null
            }
            val copiedNodes: MutableList<GraphNode?> = mutableListOf()
            val copiedNumber: MutableList<Int> = mutableListOf()
            bfs(node, copiedNodes, copiedNumber)
            return copiedNodes[0]
        }

        fun bfs(node: GraphNode?, copiedNodes: MutableList<GraphNode?>, copiedNumber: MutableList<Int>) {
            var current = node
            var newNode: GraphNode? = null
            if (current != null && !copiedNumber.contains(current.`val`!!)) {
                newNode = GraphNode(current.`val`!!)
                copiedNodes.add(newNode)
                copiedNumber.add(current.`val`!!)
            } else {
                return
            }
            val copiedNeighbors: MutableList<GraphNode?> = mutableListOf()
            current.neighbors.forEach {
                bfs(it, copiedNodes, copiedNumber)
                if (it != null && copiedNumber.contains(it.`val`!!)) {
                    val index = copiedNumber.indexOf(it.`val`!!)
                    copiedNeighbors.add(copiedNodes[index])
                }
            }
            if (newNode != null) {
                newNode.neighbors.addAll(copiedNeighbors)
            }
        }
    }
}