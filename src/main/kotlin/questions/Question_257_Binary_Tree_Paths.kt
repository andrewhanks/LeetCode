package questions

import models.TreeNode


class Question_257_Binary_Tree_Paths {

    companion object {

        fun runQuestion() {
//            Input: root = [1,2,3,null,5]
//            Output: ["1->2->5","1->3"]
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(5)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.right = treeNode4
            treeNodes = treeNode1
            val root = treeNodes
            val result = binaryTreePaths(root)
            println("Question 257: $result")
        }

        fun binaryTreePaths(root: TreeNode?): List<String> {
            val result: MutableList<String> = mutableListOf()
            preorder(root, result, "")
            return result.toList()
        }

        fun preorder(root: TreeNode?, result: MutableList<String>, path: String) {
            if (root == null) {
                return
            }
            var temp = path + root?.`val`!!.toString()
            if (root?.left == null && root?.right == null) {
                result.add(temp)
            } else {
                temp += "->"
                preorder(root?.left, result, temp)
                preorder(root?.right, result, temp)
            }
        }
    }
}