package questions

import models.TreeNode


class Question_98_Validate_Binary_Search_Tree {

    companion object {

        fun runQuestion() {
            // [5,1,4,null,null,3,6]
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(5)
            val treeNode2 = TreeNode(1)
            val treeNode3 = TreeNode(4)
            val treeNode4 = TreeNode(null)
            val treeNode5 = TreeNode(null)
            val treeNode6 = TreeNode(3)
            val treeNode7 = TreeNode(6)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNodes = treeNode1
            val result = isValidBST(treeNodes)
            println("Question 98: $result")
        }

        val resultArray: MutableList<Int> = mutableListOf()

        fun isValidBST(root: TreeNode?): Boolean {
            return isValid(root, null, null)
        }

        fun isValid(root: TreeNode?, min: Int?, max: Int?): Boolean {
            if (root?.`val` == null) {
                return true
            }
            if ((min != null && root.`val`!! <= min) || (max != null && root.`val`!! >= max)) {
                return false
            }
            return isValid(root.left, min, root.`val`) && isValid(root.right, root.`val`, max)
        }

        fun isValidBSTSlow(root: TreeNode?): Boolean {
            printFullBst(root)
            var isAscendingTree = true
            resultArray.sorted().forEachIndexed { index, i ->
                if (index == resultArray.size - 1) {
                    return@forEachIndexed
                }
                if (resultArray.sorted()[index] == resultArray.sorted()[index + 1]) {
                    isAscendingTree = false
                }
            }
            if (resultArray.sorted() == resultArray && isAscendingTree) {
                return true
            }
            return false
        }

        fun printFullBst(root: TreeNode?) {
            if (root?.`val` == null) {
                return
            }
            printFullBst(root?.left)
            resultArray.add(root.`val`!!)
            printFullBst(root?.right)
        }
    }
}