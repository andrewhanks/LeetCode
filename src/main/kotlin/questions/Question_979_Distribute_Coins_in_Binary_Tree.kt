package questions

import models.TreeNode
import java.util.*
import kotlin.math.abs
import kotlin.math.max


class Question_979_Distribute_Coins_in_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [0,3,0]
//            Output: 3
            val root: TreeNode
            val treeNode1 = TreeNode(0)
            val treeNode2 = TreeNode(3)
            val treeNode3 = TreeNode(0)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            root = treeNode1
            val result = distributeCoins(root)
            println("Question 979: $result")
        }

        fun distributeCoins(root: TreeNode?): Int {
            val queue: Queue<TreeNode> = LinkedList()
            var ans = 0
            queue.add(root)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                if (node?.left != null) {
                    ans += calculate(node?.left)
                    // println("node?.left ans = $ans")
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    ans += calculate(node?.right)
                    // println("node?.right ans = $ans")
                    queue.add(node?.right)
                }
            }
            return ans
        }

        fun calculate(root: TreeNode?): Int {
            val queue: Queue<TreeNode> = LinkedList()
            var nodeNumber = 0
            var nodeValue = 0
            queue.add(root)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                nodeNumber++
                nodeValue += node?.`val`!!
                // println("nodeNumber = $nodeNumber, nodeValue = $nodeValue")
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
            }
            return abs(nodeNumber - nodeValue)
        }
    }
}