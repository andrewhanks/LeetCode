package questions

import models.TreeNode


class Question_114_Flatten_Binary_Tree_to_Linked_List {

    companion object {

        fun runQuestion() {
//            Input: root = [1,2,5,3,4,null,6]
//            Output: [1,null,2,null,3,null,4,null,5,null,6]
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(5)
            val treeNode4 = TreeNode(3)
            val treeNode5 = TreeNode(4)
            val treeNode6 = TreeNode(null)
            val treeNode7 = TreeNode(6)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNodes = treeNode1
            flatten(treeNodes)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNodes)
            result += "]"
            println("Question 114: $result")
        }

        fun flatten(root: TreeNode?): Unit {
            val result: MutableList<TreeNode> = mutableListOf()
            preOrderTraversal(root, result)
            var currentNode: TreeNode? = null
            for (count in 0..result.size - 1) {
                if (count == 0) {
                    currentNode = result[count]
                } else {
                    currentNode?.right = result[count]
                    currentNode?.left = null
                    currentNode = currentNode?.right
                }
            }
        }

        fun preOrderTraversal(root: TreeNode?, result: MutableList<TreeNode>) {
            if (root == null) {
                return
            }
            result.add(root)
            preOrderTraversal(root?.left, result)
            preOrderTraversal(root?.right, result)
        }
    }
}