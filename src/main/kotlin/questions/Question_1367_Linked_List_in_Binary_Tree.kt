package questions

import models.ListNode
import models.TreeNode


class Question_1367_Linked_List_in_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
//            Output: true
            val listNode1 = ListNode(4)
            val listNode2 = ListNode(2)
            val listNode3 = ListNode(8)
            listNode1.next = listNode2
            listNode2.next = listNode3
            val head = listNode1
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(4)
            val treeNode3 = TreeNode(4)
            val treeNode4 = TreeNode(2)
            val treeNode5 = TreeNode(2)
            val treeNode6 = TreeNode(1)
            val treeNode7 = TreeNode(6)
            val treeNode8 = TreeNode(8)
            val treeNode9 = TreeNode(1)
            val treeNode10 = TreeNode(3)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.right = treeNode4
            treeNode3.left = treeNode5
            treeNode4.left = treeNode6
            treeNode5.left = treeNode7
            treeNode5.right = treeNode8
            treeNode8.left = treeNode9
            treeNode8.right = treeNode10
            val root = treeNode1
            val result = isSubPath(head, root)
            println("Question 1367: $result")
        }

        fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
            if (head == null) {
                return true
            }
            if (root == null) {
                return false
            }
            if (head?.`val` == root?.`val` && match(head, root)) {
                return true
            }
            return isSubPath(head, root?.left) || isSubPath(head, root?.right)
        }

        fun match(head: ListNode?, root: TreeNode?): Boolean {
            if (head == null) {
                return true
            }
            if (root == null) {
                return false
            }
            if (head?.`val` != root?.`val`) {
                return false
            }
            return match(head?.next, root?.left) || match(head?.next, root?.right)
        }
    }
}