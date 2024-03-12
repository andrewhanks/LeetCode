package questions

import models.TreeNode
import java.util.*


class Question_513_Find_Bottom_Left_Tree_Value {

    companion object {

        fun runQuestion() {
//            Input: root = [1,2,3,4,null,5,6,null,null,7]
//            Output: 7
            val root: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(4)
            val treeNode5 = TreeNode(5)
            val treeNode6 = TreeNode(6)
            val treeNode7 = TreeNode(7)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode3.left = treeNode5
            treeNode3.right = treeNode6
            treeNode5.right = treeNode7
            root = treeNode1
            val result = findBottomLeftValue(root)
            println("Question 513: $result")
        }

        fun findBottomLeftValue(root: TreeNode?): Int {
            val queue: Queue<TreeNode?> = LinkedList()
            queue.add(root)
            var value = 0
            while (!queue.isEmpty()) {
                for (count in 0..queue.size - 1) {
                    val node = queue.remove()
                    if (count == 0) {
                        value = node?.`val`!!
                    }
                    if (node?.left != null) {
                        queue.add(node?.left)
                    }
                    if (node?.right != null) {
                        queue.add(node?.right)
                    }
                }
            }
            return value
        }
    }
}