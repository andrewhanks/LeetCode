package questions

import models.TreeNode


class Question_538_Convert_BST_to_Greater_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//            Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
            val root: TreeNode
            val treeNode1 = TreeNode(4)
            val treeNode2 = TreeNode(1)
            val treeNode3 = TreeNode(6)
            val treeNode4 = TreeNode(0)
            val treeNode5 = TreeNode(2)
            val treeNode6 = TreeNode(5)
            val treeNode7 = TreeNode(7)
            val treeNode8 = TreeNode(3)
            val treeNode9 = TreeNode(8)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNode5.right = treeNode8
            treeNode7.right = treeNode9
            root = treeNode1
            val treeNode = convertBST(root)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 538: $result")
        }

        fun convertBST(root: TreeNode?): TreeNode? {
            if (root == null) {
                return null
            }
            val result: MutableList<Int> = mutableListOf()
            inorder(root, result)
            addValue(root, result)
            return root
        }

        fun inorder(root: TreeNode?, result: MutableList<Int>) {
            if (root?.left != null) {
                inorder(root?.left, result)
            }
            result.add(root?.`val`!!)
            if (root?.right != null) {
                inorder(root?.right, result)
            }
        }

        fun addValue(root: TreeNode?, result: MutableList<Int>) {
            val startIndex = result.indexOf(root?.`val`!!)
            var sum = 0
            for (count in startIndex + 1..result.size - 1) {
                sum += result[count]
            }
            sum += root?.`val`!!
            root?.`val` = sum
            if (root?.left != null) {
                addValue(root?.left, result)
            }
            if (root?.right != null) {
                addValue(root?.right, result)
            }
        }

        var sum = 0
        fun convertBSTByReverseInorderTraversal(root: TreeNode?): TreeNode? {
            if (root == null) {
                return null
            }
            reversedInorder(root)
            return root
        }

        fun reversedInorder(root: TreeNode?) {
            if (root?.right != null) {
                reversedInorder(root?.right)
            }
            root?.`val` = root?.`val`!! + sum
            sum = root?.`val`!!
            if (root?.left != null) {
                reversedInorder(root?.left)
            }
        }
    }
}