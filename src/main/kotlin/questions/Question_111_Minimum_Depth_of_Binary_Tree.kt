package questions

import models.TreeNode
import java.util.*
import kotlin.math.min


class Question_111_Minimum_Depth_of_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [3,9,20,null,null,15,7]
//            Output: 2
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
            val result = minDepth(root)
            println("Question 111: $result")
        }

        fun minDepth(root: TreeNode?): Int {
            val result: Queue<TreeNode?> = LinkedList()
            result.add(root)
            var depth = 0
            if (root == null) {
                return 0
            }
            while (!result.isEmpty()) {
                depth++
                for (coutn in 0..result.size - 1) {
                    val node = result.remove()
                    if (node?.left == null && node?.right == null) {
                        return depth
                    }
                    if (node?.left != null) {
                        result.add(node?.left)
                    }
                    if (node?.right != null) {
                        result.add(node?.right)
                    }
                }
            }
            return depth
        }

        fun minDepthByRecursive(root: TreeNode?): Int {
            return count(root)
        }

        fun count(root: TreeNode?): Int {
            if (root == null) {
                return 0
            } else if (root?.left == null && root?.right == null) {
                return 1
            } else if (root?.left == null) {
                return count(root?.right) + 1
            } else if (root?.right == null) {
                return count(root?.left) + 1
            }
            return min(count(root?.left), count(root?.right)) + 1
        }
    }
}