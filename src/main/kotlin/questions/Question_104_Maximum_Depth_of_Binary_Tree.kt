package questions

import models.TreeNode
import java.util.*
import kotlin.math.max

class Question_104_Maximum_Depth_of_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [3,9,20,null,null,15,7]
//            Output: 3
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(3)
            val treeNode2 = TreeNode(9)
            val treeNode3 = TreeNode(20)
            val treeNode4 = TreeNode(null)
            val treeNode5 = TreeNode(null)
            val treeNode6 = TreeNode(15)
            val treeNode7 = TreeNode(7)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNodes = treeNode1
            val result = maxDepth(treeNodes)
            println("Question 104: $result")
        }

        fun maxDepthRecursive(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            return max(maxDepth(root?.left), maxDepth(root?.right)) + 1
        }

        fun maxDepth(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            val result: Queue<TreeNode?> = LinkedList()
            var level = 0
            result.add(root)
            while (!result.isEmpty()) {
                val size = result.size
                level++
                for (count in 0..size - 1) {
                    val node = result.remove()
                    if (node?.left != null) {
                        result.add(node?.left)
                    }
                    if (node?.right != null) {
                        result.add(node?.right)
                    }
                }
            }
            return level
        }
    }
}