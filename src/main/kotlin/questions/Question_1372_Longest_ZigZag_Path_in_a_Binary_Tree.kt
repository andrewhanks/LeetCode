package questions

import models.TreeNode
import java.util.*
import kotlin.math.max


class Question_1372_Longest_ZigZag_Path_in_a_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
//            Output: 3
            val root: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(1)
            val treeNode3 = TreeNode(1)
            val treeNode4 = TreeNode(1)
            val treeNode5 = TreeNode(1)
            val treeNode6 = TreeNode(1)
            val treeNode7 = TreeNode(1)
            val treeNode8 = TreeNode(1)
            treeNode1.right = treeNode2
            treeNode2.left = treeNode3
            treeNode2.right = treeNode4
            treeNode4.left = treeNode5
            treeNode4.right = treeNode6
            treeNode5.right = treeNode7
            treeNode7.right = treeNode8
            root = treeNode1
            val result = longestZigZag(root)
            println("Question 1372: $result")
        }

        fun longestZigZag(root: TreeNode?): Int {
            val queue: Queue<TreeNode?> = LinkedList()
            queue.add(root)
            var ans = 0
            while (!queue.isEmpty()) {
                val node = queue.remove()
                ans = max(ans, calculate(node))
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
            }
            return ans
        }

        fun calculate(head: TreeNode?): Int {
            return max(cal(head, true), cal(head, false)) - 1
        }

        fun cal(head: TreeNode?, isRight: Boolean): Int {
            if (head == null) {
                return 0
            }
            if (isRight) {
                return cal(head?.right, false) + 1
            } else {
                return cal(head?.left, true) + 1
            }
        }

        fun longestZigZagByCalculateContinuously(root: TreeNode?): Int {
            return max(
                calculateByCalculateContinuously(root?.left, true, 1),
                calculateByCalculateContinuously(root?.right, false, 1)
            ) - 1
        }

        fun calculateByCalculateContinuously(head: TreeNode?, isRight: Boolean, level: Int): Int {
            if (head == null) {
                return level
            }
            var right = 0
            var left = 0
            if (isRight) {
                right = calculateByCalculateContinuously(head?.right, false, level + 1)
                left = calculateByCalculateContinuously(head?.left, true, 1)
            } else {
                left = calculateByCalculateContinuously(head?.left, true, level + 1)
                right = calculateByCalculateContinuously(head?.right, false, 1)
            }
            return max(right, left)
        }
    }
}