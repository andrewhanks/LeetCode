package questions

import models.TreeNode


class Question_113_Path_Sum_II {

    companion object {

        fun runQuestion() {
//            Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//            Output: [[5,4,11,2],[5,8,4,5]]
            val root: TreeNode
            val treeNode1 = TreeNode(5)
            val treeNode2 = TreeNode(4)
            val treeNode3 = TreeNode(8)
            val treeNode4 = TreeNode(11)
            val treeNode5 = TreeNode(13)
            val treeNode6 = TreeNode(4)
            val treeNode7 = TreeNode(7)
            val treeNode8 = TreeNode(2)
            val treeNode9 = TreeNode(5)
            val treeNode10 = TreeNode(1)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode3.left = treeNode5
            treeNode3.right = treeNode6
            treeNode4.left = treeNode7
            treeNode4.right = treeNode8
            treeNode6.left = treeNode9
            treeNode6.right = treeNode10
            root = treeNode1
            val targetSum = 22
            val result = pathSum(root, targetSum)
            println("Question 113: $result")
        }

        fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            dfs(root, targetSum, result, temp)
            return result
        }

        fun dfs(root: TreeNode?, targetSum: Int, result: MutableList<MutableList<Int>>, temp: MutableList<Int>) {
            if (root == null) {
                return
            }
            temp.add(root?.`val`!!)
            // println("temp = ${temp}")
            if (temp.sum() == targetSum && root?.left == null && root?.right == null) {
                result.add(temp.toMutableList())
            }
            if (root?.left != null) {
                dfs(root?.left, targetSum, result, temp)
            }
            if (root?.right != null) {
                dfs(root?.right, targetSum, result, temp)
            }
            temp.removeAt(temp.size - 1)
        }
    }
}