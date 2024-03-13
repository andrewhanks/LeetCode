package questions

import models.TreeNode


class Question_617_Merge_Two_Binary_Trees {

    companion object {

        fun runQuestion() {
//            Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//            Output: [3,4,5,5,4,null,7]
            val root1: TreeNode
            val treeNode11 = TreeNode(1)
            val treeNode12 = TreeNode(3)
            val treeNode13 = TreeNode(2)
            val treeNode14 = TreeNode(5)
            treeNode11.left = treeNode12
            treeNode11.right = treeNode13
            treeNode12.left = treeNode14
            root1 = treeNode11
            val root2: TreeNode
            val treeNode21 = TreeNode(2)
            val treeNode22 = TreeNode(1)
            val treeNode23 = TreeNode(3)
            val treeNode24 = TreeNode(4)
            val treeNode25 = TreeNode(7)
            treeNode21.left = treeNode22
            treeNode21.right = treeNode23
            treeNode22.right = treeNode24
            treeNode23.right = treeNode25
            root2 = treeNode21
            val treeNode = mergeTrees(root1, root2)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 617: $result")
        }

        fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
            return merge(root1, root2)
        }

        fun merge(root1: TreeNode?, root2: TreeNode?): TreeNode? {
            if (root1 == null && root2 == null) {
                return null
            }
            val root1Value = root1?.`val` ?: 0
            val root2Value = root2?.`val` ?: 0
            val node = TreeNode(root1Value + root2Value)
            if (root1?.left != null || root2?.left != null) {
                node?.left = merge(root1?.left, root2?.left)
            }
            if (root1?.right != null || root2?.right != null) {
                node?.right = merge(root1?.right, root2?.right)
            }
            return node
        }
    }
}