package questions

import models.TreeNode
import java.util.*

class Question_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    companion object {

        fun runQuestion() {
//            Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//            Output: [3,9,20,null,null,15,7]
            val preorder = intArrayOf(3, 9, 20, 15, 7)
            val inorder = intArrayOf(9, 3, 15, 20, 7)
            var treeNode = buildTree(preorder, inorder)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 105: $result")
        }

        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            if (preorder.size == 0) {
                return null
            }
            val root = TreeNode(preorder[0])
            val middle = inorder.indexOf(preorder[0])
            val leftPreorder = preorder.slice(1..middle)
            val leftInorder = inorder.slice(0..middle - 1)
            root.left = buildTree(leftPreorder.toIntArray(), leftInorder.toIntArray())
            val rightPreorder = preorder.slice(middle + 1..preorder.size - 1)
            val rightInorder = inorder.slice(middle + 1..inorder.size - 1)
            root.right = buildTree(rightPreorder.toIntArray(), rightInorder.toIntArray())
            return root
        }
    }
}