package questions

import Utils
import models.TreeNode

class Question_889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {

    companion object {

        fun runQuestion() {
//            Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//            Output: [1,2,3,4,5,6,7]
            val inorder = intArrayOf(1, 2, 4, 5, 3, 6, 7)
            val postorder = intArrayOf(4, 5, 2, 6, 7, 3, 1)
            var treeNode = constructFromPrePost(inorder, postorder)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 889: $result")
        }

        fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
            return construct(preorder, postorder, 0, preorder.size - 1, 0, postorder.size - 1)
        }

        fun construct(
            preorder: IntArray,
            postorder: IntArray,
            preStart: Int,
            preEnd: Int,
            postStart: Int,
            postEnd: Int
        ): TreeNode? {
            if (preStart > preEnd) {
                return null
            }
            val root = TreeNode(preorder[preStart])
            if (preStart == preEnd) {
                return root
            }
            val index = postorder.indexOf(preorder[preStart + 1])
            val size = index - postStart + 1
            root.left = construct(preorder, postorder, preStart + 1, preStart + size, postStart, postStart + size - 1)
            root.right = construct(preorder, postorder, preStart + size + 1, preEnd, postStart + size, postEnd)
            return root
        }
    }
}