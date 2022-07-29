import models.TreeNode
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
    }
}