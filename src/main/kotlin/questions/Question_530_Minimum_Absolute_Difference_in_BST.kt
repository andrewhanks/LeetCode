package questions

import models.TreeNode
import kotlin.math.min


class Question_530_Minimum_Absolute_Difference_in_BST {

    companion object {

        fun runQuestion() {
//            Input: root = [1,0,48,null,null,12,49]
//            Output: 1
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(0)
            val treeNode3 = TreeNode(48)
            val treeNode4 = TreeNode(null)
            val treeNode5 = TreeNode(null)
            val treeNode6 = TreeNode(12)
            val treeNode7 = TreeNode(49)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNodes = treeNode1
            val result = getMinimumDifference(treeNodes)
            println("Question 530: $result")
        }

        fun getMinimumDifference(root: TreeNode?): Int {
            val result: MutableList<Int> = mutableListOf()
            inorderTraversal(root, result)
            var min = 200000
            for (count in 1..result.size - 1) {
                min = min(min, result[count] - result[count - 1])
            }
            return min
        }

        fun inorderTraversal(root: TreeNode?, result: MutableList<Int>) {
            if (root?.left != null) {
                inorderTraversal(root?.left, result)
            }
            if (root?.`val` != null) {
                result.add(root?.`val`!!)
            }
            if (root?.right != null) {
                inorderTraversal(root?.right, result)
            }
        }
    }
}