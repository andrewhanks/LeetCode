package questions

import models.TreeNode


class Question_669_Trim_a_Binary_Search_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//            Output: [3,2,null,1]
            val root: TreeNode
            val treeNode1 = TreeNode(3)
            val treeNode2 = TreeNode(0)
            val treeNode3 = TreeNode(4)
            val treeNode4 = TreeNode(2)
            val treeNode5 = TreeNode(1)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.right = treeNode4
            treeNode4.right = treeNode5
            root = treeNode1
            val low = 1
            val high = 3
            val treeNode = trimBST(root, low, high)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 669: $result")
        }

        fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
            if (root == null) {
                return null
            }
            root?.left = trimBST(root?.left, low, high)
            root?.right = trimBST(root?.right, low, high)
            if (root?.`val`!! < low) {
                return root?.right
            }
            if (root?.`val`!! > high) {
                return root?.left
            }
            return root
        }
    }
}