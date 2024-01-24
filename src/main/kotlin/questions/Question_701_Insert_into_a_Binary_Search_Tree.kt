package questions

import models.TreeNode


class Question_701_Insert_into_a_Binary_Search_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [4,2,7,1,3], val = 5
//            Output: [4,2,7,1,3,5]
            val root: TreeNode
            val treeNode1 = TreeNode(4)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(7)
            val treeNode4 = TreeNode(1)
            val treeNode5 = TreeNode(3)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            root = treeNode1
            val `val` = 5
            val treeNode = insertIntoBST(root, `val`)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 701: $result")
        }

        fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
            if (root == null) {
                return TreeNode(`val`)
            }
            insert(root, `val`)
            return root
        }

        fun insert(root: TreeNode?, `val`: Int) {
            if (root != null) {
                if (`val` > root?.`val`!!) {
                    if (root?.right == null) {
                        root?.right = TreeNode(`val`)
                    } else {
                        insertIntoBST(root?.right, `val`)
                    }
                } else {
                    if (root?.left == null) {
                        root?.left = TreeNode(`val`)
                    } else {
                        insertIntoBST(root?.left, `val`)
                    }
                }
            }
        }
    }
}