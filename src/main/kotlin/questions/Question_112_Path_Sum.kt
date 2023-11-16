package questions

import models.TreeNode


class Question_112_Path_Sum {

    companion object {

        fun runQuestion() {
//            Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//            Output: true
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(5)
            val treeNode2 = TreeNode(4)
            val treeNode3 = TreeNode(8)
            val treeNode4 = TreeNode(11)
            val treeNode5 = TreeNode(null)
            val treeNode6 = TreeNode(13)
            val treeNode7 = TreeNode(4)
            val treeNode8 = TreeNode(7)
            val treeNode9 = TreeNode(2)
            val treeNode10 = TreeNode(null)
            val treeNode11 = TreeNode(null)
            val treeNode12 = TreeNode(null)
            val treeNode13 = TreeNode(1)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNode4.left = treeNode8
            treeNode4.right = treeNode9
            treeNode6.left = treeNode10
            treeNode6.right = treeNode11
            treeNode7.left = treeNode12
            treeNode7.right = treeNode13
            treeNodes = treeNode1
            val targetSum = 22
            val result = hasPathSum(treeNodes, targetSum)
            println("Question 112: $result")
        }

        fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
            if (root == null) {
                return false
            }
            return dp(root, targetSum)
        }

        fun dp(root: TreeNode?, targetSum: Int): Boolean {
            if (targetSum == root?.`val` && root?.left == null && root?.right == null) {
                return true
            }
            var left = false
            if (root?.left != null) {
                left = dp(root?.left, targetSum - root?.`val`!!)
            }
            var right = false
            if (root?.right != null) {
                right = dp(root?.right, targetSum - root?.`val`!!)
            }
            return left || right
        }
    }
}