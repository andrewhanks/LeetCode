package questions

import models.TreeNode
import java.util.*

class Question_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    companion object {

        fun runQuestion() {
//            Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//            Output: [3,9,20,null,null,15,7]
            val inorder = intArrayOf(9, 3, 15, 20, 7)
            val postorder = intArrayOf(9, 15, 7, 20, 3)
            var treeNode = buildTree(inorder, postorder)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 106: $result")
        }

        fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
            return build(inorder, postorder)
        }

        fun build(inorder: IntArray, postorder: IntArray): TreeNode? {
            if (inorder.size < 1) {
                return null
            }
            if (inorder.size == 1) {
                return TreeNode(inorder[0])
            }
            val value = postorder[postorder.size - 1];
            val newNode = TreeNode(value)
            val inorderIndex = inorder.indexOf(value)
            val leftInorder = inorder.slice(0..inorderIndex - 1)
            val leftPostorder = postorder.slice(0..inorderIndex - 1)
            newNode.left = build(leftInorder.toIntArray(), leftPostorder.toIntArray())
            val rightInorder = inorder.slice(inorderIndex + 1..inorder.size - 1)
            val rightPostorder = postorder.slice(inorderIndex..inorder.size - 2)
            newNode.right = build(rightInorder.toIntArray(), rightPostorder.toIntArray())
            return newNode
        }
    }
}