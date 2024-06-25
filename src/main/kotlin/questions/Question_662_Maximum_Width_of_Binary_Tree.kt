package questions

import models.TreeNode
import java.util.*
import kotlin.math.max
import kotlin.math.min


class Question_662_Maximum_Width_of_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [1,3,2,5,3,null,9]
//            Output: 4
            val root: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(3)
            val treeNode3 = TreeNode(2)
            val treeNode4 = TreeNode(5)
            val treeNode5 = TreeNode(3)
            val treeNode6 = TreeNode(9)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.right = treeNode6
            root = treeNode1
            val result = widthOfBinaryTree(root)
            println("Question 662: $result")
        }

        fun widthOfBinaryTree(root: TreeNode?): Int {
            val queue: Queue<TreeNode?> = LinkedList()
            val order: Queue<Long> = LinkedList()
            var width = 0L
            queue.add(root)
            order.add(1)
            while (!queue.isEmpty()) {
                var left = Long.MAX_VALUE
                var right = Long.MIN_VALUE
                val size = queue.size
                for (count in 0..size - 1) {
                    val node = queue.remove()
                    val number = order.remove()
                    left = min(left, number)
                    right = max(right, number)
                    if (node?.left != null) {
                        queue.add(node?.left)
                        order.add(number * 2 - 1)
                    }
                    if (node?.right != null) {
                        queue.add(node?.right)
                        order.add(number * 2)
                    }
                }
                width = max(width, right - left + 1)
            }
            return width.toInt()
        }
    }
}