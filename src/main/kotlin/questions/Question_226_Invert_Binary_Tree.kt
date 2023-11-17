package questions

import models.TreeNode


class Question_226_Invert_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [4,2,7,1,3,6,9]
//            Output: [4,7,2,9,6,3,1]
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(4)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(7)
            val treeNode4 = TreeNode(1)
            val treeNode5 = TreeNode(3)
            val treeNode6 = TreeNode(6)
            val treeNode7 = TreeNode(9)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNodes = treeNode1
            val treeNode = invertTree(treeNodes)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 226: $result")
        }

        fun invertTree(root: TreeNode?): TreeNode? {
            invert(root)
            return root
        }

        fun invert(root: TreeNode?) {
            val tempNode = root?.left
            root?.left = root?.right
            root?.right = tempNode
            if (root?.left?.left != null || root?.left?.right != null) {
                invert(root?.left)
            }
            if (root?.right?.left != null || root?.right?.right != null) {
                invert(root?.right)
            }
        }
    }
}