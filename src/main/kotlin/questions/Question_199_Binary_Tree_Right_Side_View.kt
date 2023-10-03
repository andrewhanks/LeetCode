package questions

import models.TreeNode
import java.util.*


class Question_199_Binary_Tree_Right_Side_View {

    companion object {

        fun runQuestion() {
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(5)
            val treeNode5 = TreeNode(4)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.right = treeNode4
            treeNode3.right = treeNode5
            treeNodes = treeNode1
            val result = rightSideView(treeNodes)
            println("Question 199: $result")
        }

        fun rightSideView(root: TreeNode?): List<Int> {
            val result: MutableList<Int> = mutableListOf()
            val nodes: Queue<TreeNode?> = LinkedList()
            nodes.add(root)
            while (!nodes.isEmpty()) {
                val rightMostCount = nodes.size - 1
                for (count in 0..nodes.size - 1) {
                    val currentNode = nodes.remove()
                    println("count = $count, rightMostCount = ${rightMostCount}, currentNode?.`val` = ${currentNode?.`val`}")
                    if (count == rightMostCount && currentNode?.`val` != null) {
                        result.add(currentNode.`val`!!)
                    }
                    if (currentNode?.left != null) {
                        nodes.add(currentNode?.left)
                    }
                    if (currentNode?.right != null) {
                        nodes.add(currentNode?.right)
                    }
                }
            }
            return result
        }
    }
}