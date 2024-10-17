package questions

import models.TreeNode
import java.util.*


class Question_987_Vertical_Order_Traversal_of_a_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [1,2,3,4,6,5,7]
//            Output: [[4],[2],[1,5,6],[3],[7]]
            val root: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(4)
            val treeNode5 = TreeNode(6)
            val treeNode6 = TreeNode(5)
            val treeNode7 = TreeNode(7)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            root = treeNode1
            val result = verticalTraversal(root)
            println("Question 987: $result")
        }

        fun verticalTraversal(root: TreeNode?): List<List<Int>> {
            val result: TreeMap<Int, MutableList<Int>> = TreeMap()
            val queue: Queue<Pair<TreeNode, IntArray>> = LinkedList()
            queue.add(Pair(root!!, intArrayOf(0, 0)))
            while (!queue.isEmpty()) {
                val size = queue.size
                val temp: MutableMap<Int, MutableList<Int>> = mutableMapOf()
                for (count in 0..size - 1) {
                    val map = queue.remove()
                    val node = map.first
                    val coordinate = map.second
                    if (temp[coordinate[1]] == null) {
                        temp.put(coordinate[1], mutableListOf(node?.`val`!!))
                    } else {
                        temp[coordinate[1]]!!.add(node?.`val`!!)
                    }
                    if (node?.left != null) {
                        queue.add(Pair(node?.left!!, intArrayOf(coordinate[0] + 1, coordinate[1] - 1)))
                    }
                    if (node?.right != null) {
                        queue.add(Pair(node?.right!!, intArrayOf(coordinate[0] + 1, coordinate[1] + 1)))
                    }
                }
                for ((key, value) in temp) {
                    value.sort()
                    for (item in value) {
                        if (result[key] == null) {
                            result.put(key, mutableListOf(item))
                        } else {
                            result[key]!!.add(item)
                        }
                    }
                }
            }
            val ans: MutableList<MutableList<Int>> = mutableListOf()
            for ((key, value) in result) {
                ans.add(value)
            }
            // println("ans = $ans")
            return ans.toList()
        }
    }
}