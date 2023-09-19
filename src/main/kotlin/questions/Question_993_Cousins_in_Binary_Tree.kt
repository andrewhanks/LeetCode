package questions

import models.TreeNode
import kotlin.math.pow

class Question_993_Cousins_in_Binary_Tree {

    companion object {

        fun runQuestion() {
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(null)
            val treeNode5 = TreeNode(4)
            val treeNode6 = TreeNode(null)
            val treeNode7 = TreeNode(5)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNodes = treeNode1
            val a = 5
            val b = 4
            val result = isCousins(treeNodes, a, b)
            println("Question 993: $result")
        }

        var xParent: TreeNode? = null
        var xDepth = 0
        var yParent: TreeNode? = null
        var yDepth = 0

        fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
            traversalTree(root, x, y, 0, null)
            return xParent != yParent && xDepth == yDepth
        }

        private fun traversalTree(root: TreeNode?, x: Int, y: Int, depth: Int, parent: TreeNode?) {
            if (root?.`val` == x) {
                xParent = parent
                xDepth = depth
            } else if (root?.`val` == y) {
                yParent = parent
                yDepth = depth
            }
            if (root?.left != null) {
                traversalTree(root.left, x, y, depth + 1, root)
            }
            if (root?.right != null) {
                traversalTree(root.right, x, y, depth + 1, root)
            }
        }
    }
}