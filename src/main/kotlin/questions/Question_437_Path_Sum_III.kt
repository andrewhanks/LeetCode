package questions

import models.TreeNode


class Question_437_Path_Sum_III {

    companion object {

        fun runQuestion() {
//            Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//            Output: 3
            val root: TreeNode
            val targetSum = 8
            val treeNode1 = TreeNode(10)
            val treeNode2 = TreeNode(5)
            val treeNode3 = TreeNode(-3)
            val treeNode4 = TreeNode(3)
            val treeNode5 = TreeNode(2)
            val treeNode6 = TreeNode(11)
            val treeNode7 = TreeNode(3)
            val treeNode8 = TreeNode(-2)
            val treeNode9 = TreeNode(1)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.right = treeNode6
            treeNode4.left = treeNode7
            treeNode4.right = treeNode8
            treeNode5.right = treeNode9
            root = treeNode1
            val result = pathSum(root, targetSum)
            println("Question 437: $result")
        }

        fun pathSum(root: TreeNode?, targetSum: Int): Int {
            if (root == null) {
                return 0
            }
            var count = calculate(root, targetSum, 0, 0L)
            count += pathSum(root?.left, targetSum)
            count += pathSum(root?.right, targetSum)
            return count
        }

        fun calculate(root: TreeNode?, targetSum: Int, count: Int, sum: Long): Int {
            if (root == null) {
                return count
            }
            var tempSum = sum + root?.`val`!!
            var tempCount = count
            if (tempSum == targetSum.toLong()) {
                tempCount++
            }
            tempCount = calculate(root?.left, targetSum, tempCount, tempSum)
            tempCount = calculate(root?.right, targetSum, tempCount, tempSum)
            return tempCount
        }
    }
}