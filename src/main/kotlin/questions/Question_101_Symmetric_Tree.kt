package questions

import models.TreeNode


class Question_101_Symmetric_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [1,2,2,3,4,4,3]
//            Output: true
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(2)
            val treeNode4 = TreeNode(3)
            val treeNode5 = TreeNode(4)
            val treeNode6 = TreeNode(4)
            val treeNode7 = TreeNode(3)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNodes = treeNode1
            val result = isSymmetric(treeNodes)
            println("Question 101: $result")
        }

        fun isSymmetric(root: TreeNode?): Boolean {
            return isSymmetric(root?.left, root?.right)
        }

        fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
            if (left == null && right == null) {
                return true
            }
            if (left == null || right == null) {
                return false
            }
            return left?.`val` == right?.`val` && isSymmetric(left?.left, right?.right) && isSymmetric(
                left?.right,
                right?.left
            )
        }
    }
}