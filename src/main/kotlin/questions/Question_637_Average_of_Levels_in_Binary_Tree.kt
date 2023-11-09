package questions

import models.TreeNode
import java.util.*


class Question_637_Average_of_Levels_in_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [3,9,20,15,7]
//            Output: [3.00000,14.50000,11.00000]
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(3)
            val treeNode2 = TreeNode(9)
            val treeNode3 = TreeNode(20)
            val treeNode4 = TreeNode(15)
            val treeNode5 = TreeNode(7)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNodes = treeNode1
            val resultArray = averageOfLevels(treeNodes)
            var result = "["
            resultArray.forEachIndexed { index, i ->
                result += i
                if (index == resultArray.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 637: $result")
        }

        fun averageOfLevels(root: TreeNode?): DoubleArray {
            val result: MutableList<Double> = mutableListOf()
            val queue: Queue<TreeNode?> = LinkedList()
            queue.add(root)
            while (!queue.isEmpty()) {
                val size = queue.size
                var total = 0.0
                for (count in 0..size - 1) {
                    val node = queue.remove()
                    total += node?.`val`!!.toDouble()

                    if (node?.left != null) {
                        queue.add(node?.left)
                    }
                    if (node?.right != null) {
                        queue.add(node?.right)
                    }
                }
                result.add(total / size)
            }
            return result.toDoubleArray()
        }
    }
}