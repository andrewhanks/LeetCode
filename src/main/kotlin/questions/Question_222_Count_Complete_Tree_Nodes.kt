package questions

import models.TreeNode
import java.util.*


class Question_222_Count_Complete_Tree_Nodes {

    companion object {

        fun runQuestion() {
//            Input: root = [1,2,3,4,5,6]
//            Output: 6
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(4)
            val treeNode5 = TreeNode(5)
            val treeNode6 = TreeNode(6)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNodes = treeNode1
            val result = countNodes(treeNodes)
            println("Question 222: $result")
        }

        fun countNodes(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            var count = 0
            val queue: Queue<TreeNode?> = LinkedList()
            queue.add(root)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                count++
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
            }
            return count
        }

        fun countNodesPreOrder(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            val result: MutableList<Int> = mutableListOf()
            preOrder(root, result)
            return result.size
        }

        fun preOrder(root: TreeNode?, result: MutableList<Int>) {
            result.add(root?.`val`!!)
            if (root?.left != null) {
                preOrder(root?.left, result)
            }
            if (root?.right != null) {
                preOrder(root?.right, result)
            }
        }
    }
}