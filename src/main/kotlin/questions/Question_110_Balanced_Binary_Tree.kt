package questions

import models.TreeNode
import java.util.*
import kotlin.math.abs
import kotlin.math.max


class Question_110_Balanced_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [3,9,20,null,null,15,7]
//            Output: true
            val root: TreeNode
            val treeNode1 = TreeNode(3)
            val treeNode2 = TreeNode(9)
            val treeNode3 = TreeNode(20)
            val treeNode4 = TreeNode(15)
            val treeNode5 = TreeNode(7)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode3.left = treeNode4
            treeNode3.right = treeNode5
            root = treeNode1
            val result = isBalanced(root)
            println("Question 110: $result")
        }

        fun isBalanced(root: TreeNode?): Boolean {
            if (root == null) {
                return true
            }
            val queue: Queue<TreeNode?> = LinkedList()
            queue.add(root)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                val leftHeight = count(node?.left)
                val rightHeight = count(node?.right)
                println("leftHeight = $leftHeight, rightHeight = $rightHeight")
                if (abs(leftHeight - rightHeight) > 1) {
                    return false
                }
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
            }
            return true
        }

        fun count(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            var height = 0
            val queue: Queue<TreeNode?> = LinkedList()
            queue.add(root)
            while (!queue.isEmpty()) {
                height++
                for (count in 0..queue.size - 1) {
                    val node = queue.remove()
                    if (node?.left != null) {
                        queue.add(node?.left)
                    }
                    if (node?.right != null) {
                        queue.add(node?.right)
                    }
                }
            }
            return height
        }

        fun isBalancedByOnlyRecursive(root: TreeNode?): Boolean {
            val height = countByOnlyRecursive(root)
            if (height == -1) {
                return false
            } else {
                return true
            }
        }

        fun countByOnlyRecursive(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            val leftHeight = count(root?.left)
            val rightHeight = count(root?.right)
            if (leftHeight == -1 || rightHeight == -1) {
                return -1
            }
            if (abs(leftHeight - rightHeight) > 1) {
                return -1
            }
            return max(leftHeight, rightHeight) + 1
        }
    }
}