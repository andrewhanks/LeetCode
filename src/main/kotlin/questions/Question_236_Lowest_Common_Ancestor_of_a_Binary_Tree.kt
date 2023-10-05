package questions

import models.TreeNode
import java.util.*


class Question_236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//            Output: 5
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(3)
            val treeNode2 = TreeNode(5)
            val treeNode3 = TreeNode(1)
            val treeNode4 = TreeNode(6)
            val treeNode5 = TreeNode(2)
            val treeNode6 = TreeNode(0)
            val treeNode7 = TreeNode(8)
            val treeNode8 = TreeNode(7)
            val treeNode9 = TreeNode(4)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNode5.left = treeNode8
            treeNode5.right = treeNode9
            treeNodes = treeNode1
            val p = TreeNode(5)
            val q = TreeNode(4)
            val result = lowestCommonAncestor(treeNodes, p, q)
            println("Question 236: ${result?.`val`}")
        }

        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            val nodeList: MutableList<Int> = mutableListOf()
            generateInOrderList(root, nodeList)
            val queue: Queue<TreeNode?> = LinkedList()
            queue.add(root)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                var nodeIndex = nodeList.indexOf(node!!.`val`)
                val leftExists = checkExists(nodeList, 0, nodeIndex, p, q)
                val rightExists = checkExists(nodeList, nodeIndex, nodeList.size - 1, p, q)
                println("${node?.`val`}, $nodeIndex, $leftExists, $rightExists")
                if (leftExists && rightExists) {
                    return node
                }
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
            }
            return null
        }

        fun generateInOrderList(root: TreeNode?, nodeList: MutableList<Int>) {
            if (root?.left != null) {
                generateInOrderList(root?.left, nodeList)
            }
            nodeList.add(root!!.`val`!!)
            if (root?.right != null) {
                generateInOrderList(root?.right, nodeList)
            }
        }

        fun checkExists(nodeList: MutableList<Int>, start: Int, end: Int, p: TreeNode?, q: TreeNode?): Boolean {
            var isPExist = false
            var isQExist = false
            if (nodeList.slice(start..end).contains(p?.`val`)) {
                isPExist = true
            }
            if (nodeList.slice(start..end).contains(q?.`val`)) {
                isQExist = true
            }
            if (isPExist || isQExist) {
                return true
            }
            return false
        }
    }
}