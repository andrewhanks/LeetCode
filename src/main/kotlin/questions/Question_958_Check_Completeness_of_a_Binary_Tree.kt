package questions

import models.TreeNode
import java.util.*
import kotlin.math.pow


class Question_958_Check_Completeness_of_a_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [1,2,3,4,5,6,7,8,9,10,11,12,13,null,null,15]
//            Output: false
            val root: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(4)
            val treeNode5 = TreeNode(5)
            val treeNode6 = TreeNode(6)
            val treeNode7 = TreeNode(7)
            val treeNode8 = TreeNode(8)
            val treeNode9 = TreeNode(9)
            val treeNode10 = TreeNode(10)
            val treeNode11 = TreeNode(11)
            val treeNode12 = TreeNode(12)
            val treeNode13 = TreeNode(13)
            val treeNode16 = TreeNode(15)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNode4.left = treeNode8
            treeNode4.right = treeNode9
            treeNode5.left = treeNode10
            treeNode5.right = treeNode11
            treeNode6.left = treeNode12
            treeNode6.right = treeNode13
            treeNode8.left = treeNode16
            root = treeNode1
            val result = isCompleteTree(root)
            println("Question 958: $result")
        }

        fun isCompleteTree(root: TreeNode?): Boolean {
            val queue: Queue<TreeNode?> = LinkedList()
            var level = 1
            var isNullExists = false
            queue.add(root)
            while (!queue.isEmpty()) {
                val size = queue.size
                var nullNumber = 0
                for (i in 0..size - 1) {
                    val node = queue.remove()
                    if (node == null) {
                        isNullExists = true
                    }
                    if (isNullExists && node != null) {
                        return false
                    }
                    queue.add(node?.left)
                    queue.add(node?.right)
                    if (node?.left == null) {
                        nullNumber++
                    }
                    if (node?.right == null) {
                        nullNumber++
                    }
                }
                if (nullNumber == 2f.pow(level).toInt()) {
                    break
                }
                level++
            }
            return true
        }
    }
}