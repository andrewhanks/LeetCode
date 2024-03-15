package questions

import models.TreeNode
import java.util.*


class Question_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//            Output: 6
            val root: TreeNode
            val treeNode1 = TreeNode(6)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(8)
            val treeNode4 = TreeNode(0)
            val treeNode5 = TreeNode(4)
            val treeNode6 = TreeNode(7)
            val treeNode7 = TreeNode(9)
            val treeNode8 = TreeNode(3)
            val treeNode9 = TreeNode(5)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNode5.left = treeNode8
            treeNode5.right = treeNode9
            root = treeNode1
            val p = treeNode2
            val q = treeNode3
            val result = lowestCommonAncestor(root, p, q)
            println("Question 235: ${result?.`val`}")
        }

        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            if (root == null || root == p || root == q) {
                return root
            }
            val left = lowestCommonAncestor(root?.left, p, q)
            val right = lowestCommonAncestor(root?.right, p, q)
            // nodes are both in right tree
            if (left == null) {
                return right
            }
            // nodes are both in left tree
            if (right == null) {
                return left
            }
            // one node in left tree and the other node in right tree
            return root
        }

        fun lowestCommonAncestorSlow(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            val queue: Queue<TreeNode?> = LinkedList()
            var result: TreeNode? = null
            queue.add(root)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                // println("node?.`val` = ${node?.`val`}, p?.`val` = ${p?.`val`}, q?.`val` = ${q?.`val`}")
                if (node?.`val` != p?.`val` && node?.`val` != q?.`val`) {
                    val leftExistence = checkExistence(node?.left, p, q)
                    val rightExistence = checkExistence(node?.right, p, q)
                    if (leftExistence && rightExistence) {
                        result = node
                    }
                } else if (node?.`val` == p?.`val` || node?.`val` == q?.`val`) {
                    val leftExistence = checkExistence(node?.left, p, q)
                    val rightExistence = checkExistence(node?.right, p, q)
                    if (leftExistence || rightExistence) {
                        result = node
                    }
                }
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
            }
            return result
        }

        fun checkExistence(root: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {
            if (root == null) {
                return false
            }
            if (root?.`val` == p?.`val` || root?.`val` == q?.`val`) {
                return true
            }
            return checkExistence(root?.left, p, q) || checkExistence(root?.right, p, q)
        }
    }
}