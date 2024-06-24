import models.*
import java.util.*

class Utils {

    companion object {

        fun parseOneDimensionalArray(input: String): List<String> {
            return input.replaceFirst("[", "")
                .replaceFirst("]", "")
                .replace(" ", "").split(",")
        }

        fun parseOneDimensionalStringArray(input: String): Array<String> {
            return input.replaceFirst("[", "")
                .replaceFirst("]", "")
                .replace(" ", "").replace("\"", "")
                .split(",").toTypedArray()
        }

        fun parseTwoDimensionalArray(input: String): List<String> {
            return input.replaceFirst("[[", "")
                .replaceFirst("]]", "")
                .replace(" ", "").split("],[")
        }

        fun parseToTreeNodeArray(stringList: List<String>): MutableList<TreeNode> {
            val treeNodeArray = MutableList(stringList.size) { TreeNode(null) }
            stringList.forEachIndexed { index, s ->
                val newTreeNode = TreeNode(s.toIntOrNull())
                treeNodeArray.add(newTreeNode)
            }
            return treeNodeArray
        }

        fun printTreeNodeByLevelOrder(result: String, treeNode: TreeNode?): String {
            if (null == treeNode) {
                return result
            }
            var tempResult = result
            val queue: Queue<TreeNode?> = LinkedList()
            queue.add(treeNode)

            while (!queue.isEmpty()) {
                val currentTreeNode = queue.poll()
                if (null != currentTreeNode) {
                    tempResult += currentTreeNode.`val`
                    tempResult += ","
                    println("tempResult = $tempResult")
                    if (null != currentTreeNode.left) {
                        queue.add(currentTreeNode.left)
                    }
                    if (null != currentTreeNode.right) {
                        queue.add(currentTreeNode.right)
                    }
                }
            }
            println("tempResult = $tempResult")
            tempResult = tempResult.removeSuffix(",")
            println("tempResult 2 = $tempResult")
            return tempResult
        }

        fun printTreeNodeByLevelOrder(result: String, node: Node?): String {
            if (null == node) {
                return result
            }
            var tempResult = result
            val queue: Queue<Node?> = LinkedList()
            queue.add(node)

            while (!queue.isEmpty()) {
                val currentNode = queue.poll()
                if (null != currentNode) {
                    tempResult += currentNode.`val`
                    tempResult += ","
                    if (currentNode.next == null) {
                        tempResult += "#"
                        tempResult += ","
                    }
                    if (null != currentNode.left) {
                        queue.add(currentNode.left)
                    }
                    if (null != currentNode.right) {
                        queue.add(currentNode.right)
                    }
                }
            }
            tempResult = tempResult.removeSuffix(",")
            return tempResult
        }

        fun printRandomNode(result: String, node: RandomNode?): String {
            if (null == node) {
                return result
            }
            var current = node
            var tempResult = result
            val randomList: MutableList<Int?> = mutableListOf()
            while (current != null) {
                var tempCurrent = node
                var count = 0
                if (current.random?.`val` == null) {
                    randomList.add(null)
                    current = current.next
                    continue
                }
                while (tempCurrent != null && current.random?.`val` != tempCurrent.`val`) {
                    count++
                    tempCurrent = tempCurrent.next
                }
                randomList.add(count)
                current = current.next
            }
            current = node
            var count = 0
            while (current != null) {
                tempResult += "["
                tempResult += current.`val`
                tempResult += ","
                tempResult += randomList[count]
                tempResult += "]"
                tempResult += ","
                current = current.next
                count++
            }
            tempResult = tempResult.removeSuffix(",")
            return tempResult
        }

        fun printGraphNode(result: String, node: GraphNode?): String {
            if (null == node) {
                return result
            }
            var current = node
            var tempResult = result
            val graphList: MutableList<GraphNode> = mutableListOf()
            val queue: Queue<GraphNode> = LinkedList()
            queue.add(current)
            while (!queue.isEmpty()) {
                val item = queue.remove()
                if (item != null && !graphList.contains(item)) {
                    graphList.add(item)
                    item.neighbors.forEach {
                        if (!graphList.contains(it)) {
                            queue.add(it)
                        }
                    }
                }
            }
            graphList.sortWith(Comparator { a, b ->
                a.`val` - b.`val`
            })
            graphList.forEach { graphNode ->
                tempResult += "["
                graphNode.neighbors.forEach { neighbor ->
                    tempResult += neighbor?.`val`
                    tempResult += ","
                }
                tempResult = tempResult.removeSuffix(",")
                tempResult += "]"
                tempResult += ","
            }
            tempResult = tempResult.removeSuffix(",")
            return tempResult
        }

        fun printListNode(listNode: ListNode?): String {
            var result = "["
            var current = listNode
            while (current != null) {
                result = result + current.`val` + ","
                current = current.next
            }
            result = result.removeSuffix(",")
            result += "]"
            return result
        }
    }
}