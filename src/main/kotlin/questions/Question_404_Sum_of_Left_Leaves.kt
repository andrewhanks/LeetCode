package questions

import models.TreeNode
import java.util.*


class Question_404_Sum_of_Left_Leaves {

    companion object {

        fun runQuestion() {
//            Input: root = [3,9,20,null,null,15,7]
//            Output: 24
            val root: TreeNode
            val treeNode1 = TreeNode(3)
            val treeNode2 = TreeNode(9)
            val treeNode3 = TreeNode(20)
            val treeNode4 = TreeNode(15)
            val treeNode5 = TreeNode(7)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode3.left = treeNode4
            treeNode3.right = treeNode5
            root = treeNode1
            val result = sumOfLeftLeaves(root)
            println("Question 404: $result")
        }

        fun sumOfLeftLeaves(root: TreeNode?): Int {
            val queue: Queue<TreeNode?> = LinkedList()
            var count = 1
            var sum = 0
            queue.add(root)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                if (node == null) {
                    count++
                    continue
                }
                queue.add(node?.left)
                queue.add(node?.right)
                if (count % 2 == 0 && node?.left == null && node?.right == null) {
                    sum = sum + (node?.`val` ?: 0)
                }
                count++
            }
            return sum
        }
    }
}