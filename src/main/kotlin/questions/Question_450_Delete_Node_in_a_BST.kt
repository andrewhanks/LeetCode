package questions

import models.TreeNode


class Question_450_Delete_Node_in_a_BST {

    companion object {

        fun runQuestion() {
//            Input: root = [5,3,6,2,4,null,7], key = 3
//            Output: [5,4,6,2,null,null,7]
            val root: TreeNode
            val treeNode1 = TreeNode(5)
            val treeNode2 = TreeNode(3)
            val treeNode3 = TreeNode(6)
            val treeNode4 = TreeNode(2)
            val treeNode5 = TreeNode(4)
            val treeNode6 = TreeNode(7)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.right = treeNode6
            root = treeNode1
            val `val` = 3
            val treeNode = deleteNode(root, `val`)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 450: $result")
        }

        fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
            if (root == null) {
                return null
            }
            if (root?.`val`!! > key) {
                root?.left = deleteNode(root?.left, key)
            } else if (root?.`val`!! < key) {
                root?.right = deleteNode(root?.right, key)
            } else {
                if (root?.left == null && root?.right == null) {
                    return null
                } else if (root?.left == null) {
                    return root?.right
                } else if (root?.right == null) {
                    return root?.left
                } else {
                    var replaceNode = findMinimalNeighbor(root?.right)
                    println(replaceNode?.`val`)
                    root?.`val` = replaceNode?.`val`
                    root?.right = deleteNode(root?.right, root?.`val`!!)
                }
            }
            return root
        }

        fun findMinimalNeighbor(node: TreeNode?): TreeNode? {
            var findNode = node
            while (findNode?.left != null) {
                findNode = findNode?.left
            }
            return findNode
        }
    }
}