package questions

import models.TreeNode
import java.util.*


class Question_230_Kth_Smallest_Element_in_a_BST {

    companion object {

        fun runQuestion() {
//            Input: root = [5,3,6,2,4,null,null,1], k = 3
//            Output: 3
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(5)
            val treeNode2 = TreeNode(3)
            val treeNode3 = TreeNode(6)
            val treeNode4 = TreeNode(2)
            val treeNode5 = TreeNode(4)
            val treeNode6 = TreeNode(1)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode4.left = treeNode6
            treeNodes = treeNode1
            val k = 3
            val result = kthSmallest(treeNodes, k)
            println("Question 236: $result")
        }

        fun kthSmallest(root: TreeNode?, k: Int): Int {
            val result: MutableList<Int> = mutableListOf()
            inorder(root, result)
            result.forEachIndexed { index, value ->
                if (index + 1 == k) {
                    return value
                }
            }
            return -1
        }

        fun inorder(root: TreeNode?, result: MutableList<Int>) {
            if (root == null) {
                return
            }
            inorder(root.left, result)
            result.add(root.`val`!!)
            inorder(root.right, result)
        }
    }
}