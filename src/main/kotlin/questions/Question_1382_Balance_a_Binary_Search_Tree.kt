package questions

import models.TreeNode


class Question_1382_Balance_a_Binary_Search_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [1,null,2,null,3,null,4,null,null]
//            Output: [2,1,3,null,null,null,4]
            val root: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(4)
            treeNode1.right = treeNode2
            treeNode2.right = treeNode3
            treeNode3.right = treeNode4
            root = treeNode1
            val treeNode = balanceBST(root)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 1382: $result")
        }

        fun balanceBST(root: TreeNode?): TreeNode? {
            val inorder: MutableList<Int> = mutableListOf()
            inorder(root, inorder)
            return buildBst(inorder, 0, inorder.size - 1)
        }

        fun inorder(root: TreeNode?, inorder: MutableList<Int>) {
            if (root == null) {
                return
            }
            if (root?.left != null) {
                inorder(root?.left, inorder)
            }
            inorder.add(root?.`val`!!)
            if (root?.right != null) {
                inorder(root?.right, inorder)
            }
        }

        fun buildBst(inorder: MutableList<Int>, start: Int, end: Int): TreeNode? {
            // println("start = $start, end = $end")
            if (start > end) {
                return null
            }
            if (start == end) {
                return TreeNode(inorder[start])
            }
            val index = (start + end) / 2
            // println("index = $index, inorder[index] = ${inorder[index]}")
            val node = TreeNode(inorder[index])
            node?.left = buildBst(inorder, start, index - 1)
            node?.right = buildBst(inorder, index + 1, end)
            return node
        }

        fun balanceBSTWithNodeSaved(root: TreeNode?): TreeNode? {
            val inorder: MutableList<TreeNode> = mutableListOf()
            inorderWithNodeSaved(root, inorder)
            return buildBstWithNodeSaved(inorder, 0, inorder.size - 1)
        }

        fun inorderWithNodeSaved(root: TreeNode?, inorder: MutableList<TreeNode>) {
            if (root == null) {
                return
            }
            if (root?.left != null) {
                inorderWithNodeSaved(root?.left, inorder)
            }
            inorder.add(root)
            if (root?.right != null) {
                inorderWithNodeSaved(root?.right, inorder)
            }
        }

        fun buildBstWithNodeSaved(inorder: MutableList<TreeNode>, start: Int, end: Int): TreeNode? {
            // println("start = $start, end = $end")
            if (start > end) {
                return null
            }
            if (start == end) {
                inorder[start]?.left = null
                inorder[start]?.right = null
                return inorder[start]
            }
            val index = (start + end) / 2
            // println("index = $index, inorder[index]?.`val` = ${inorder[index]?.`val`}")
            inorder[index]?.left = buildBstWithNodeSaved(inorder, start, index - 1)
            inorder[index]?.right = buildBstWithNodeSaved(inorder, index + 1, end)
            return inorder[index]
        }
    }
}