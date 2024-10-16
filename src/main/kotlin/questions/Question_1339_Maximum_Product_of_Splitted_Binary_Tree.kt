package questions

import models.TreeNode
import java.util.*
import kotlin.math.max

class Question_1339_Maximum_Product_of_Splitted_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [1,2,3,4,5,6]
//            Output: 110
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(4)
            val treeNode5 = TreeNode(5)
            val treeNode6 = TreeNode(6)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNodes = treeNode1
            val result = maxProduct(treeNodes)
            println("Question 1339: $result")
        }

        fun maxProduct(root: TreeNode?): Int {
            val mod = 1000000007
            val map: MutableMap<TreeNode, Long> = mutableMapOf()
            val queue: Queue<TreeNode> = LinkedList()
            var total = 0L
            var ans = 0L
            queue.add(root)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                val sum = calculateSum(node, map)
                if (total == 0L) {
                    total = sum
                } else {
                    ans = max(ans, (total - sum) * sum)
                }
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
            }
            return (ans % mod).toInt()
        }

        fun calculateSum(node: TreeNode?, map: MutableMap<TreeNode, Long>): Long {
            if (node == null) {
                return 0L
            }
            if (map[node!!] != null) {
                return map[node!!]!!
            }
            val leftSum = calculateSum(node?.left, map)
            val rightSum = calculateSum(node?.right, map)
            map.put(node!!, node?.`val`!! + leftSum + rightSum)
            return map[node!!]!!
        }
    }
}