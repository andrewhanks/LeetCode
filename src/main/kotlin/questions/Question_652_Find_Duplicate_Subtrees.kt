package questions

import models.TreeNode
import java.util.*

class Question_652_Find_Duplicate_Subtrees {

    companion object {

        fun runQuestion652() {
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(4)
            val treeNode5 = TreeNode(null)
            val treeNode6 = TreeNode(2)
            val treeNode7 = TreeNode(4)
            val treeNode8 = TreeNode(null)
            val treeNode9 = TreeNode(null)
            val treeNode10 = TreeNode(4)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNode4.left = treeNode8
            treeNode4.right = treeNode9
            treeNode6.left = treeNode10
            treeNodes = treeNode1
            val resultListNode = findDuplicateSubtrees(treeNodes)
            var result = "["
            resultListNode.forEachIndexed { index, treeNode ->
                result += "["
                result = Utils.printTreeNodeByLevelOrder(result, treeNode)
                result += "]"
                result += ","
            }
            result = result.removeSuffix(",")
            result += "]"
            println("Question 652: $result")
        }

        val mMap = HashMap<String, Int>()
        val mResult: MutableList<TreeNode?> = arrayListOf()

        fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
            postOrderCheck(root)
            return mResult
        }

        private fun postOrderCheck(root: TreeNode?): String {
            if (root?.`val` == null) {
                return "N"
            }
            val left = postOrderCheck(root.left)
            val right = postOrderCheck(root.right)
            val postOrder = left + " " + right + " " + root.`val`
            mMap[postOrder] = (mMap[postOrder] ?: 0) + 1
            if (2 == mMap[postOrder]) {
                mResult.add(root)
            }
            return postOrder
        }
    }
}