package questions

import models.TreeNode
import java.util.*
import kotlin.math.max


class Question_2385_Amount_of_Time_for_Binary_Tree_to_Be_Infected {

    companion object {

        fun runQuestion() {
//            Input: root = [1,5,3,null,4,10,6,9,2], start = 3
//            Output: 4
            val root: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(5)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(4)
            val treeNode5 = TreeNode(10)
            val treeNode6 = TreeNode(6)
            val treeNode7 = TreeNode(9)
            val treeNode8 = TreeNode(2)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.right = treeNode4
            treeNode3.left = treeNode5
            treeNode3.right = treeNode6
            treeNode4.left = treeNode7
            treeNode4.right = treeNode8
            root = treeNode1
            val start = 4
            val result = amountOfTime(root, start)
            println("Question 2385: $result")
        }

        fun amountOfTime(root: TreeNode?, start: Int): Int {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            val nodeQueue: Queue<TreeNode> = LinkedList()
            var max = 0
            nodeQueue.add(root)
            while (!nodeQueue.isEmpty()) {
                val size = nodeQueue.size
                for (i in 0..size - 1) {
                    val node = nodeQueue.remove()
                    max = max(max, node?.`val`!!)
                    val nodeList = map.getOrDefault(node?.`val`!!, mutableListOf())
                    if (node?.left != null) {
                        nodeList.add(node?.left?.`val`!!)
                        map[node?.`val`!!] = nodeList
                        val list = map.getOrDefault(node?.left?.`val`!!, mutableListOf())
                        list.add(node?.`val`!!)
                        map[node?.left?.`val`!!] = list
                        nodeQueue.add(node?.left)
                    }
                    if (node?.right != null) {
                        nodeList.add(node?.right?.`val`!!)
                        map[node?.`val`!!] = nodeList
                        val list = map.getOrDefault(node?.right?.`val`!!, mutableListOf())
                        list.add(node?.`val`!!)
                        map[node?.right?.`val`!!] = list
                        nodeQueue.add(node?.right)
                    }
                }
            }
            // println("map = $map")
            var ans = 0
            val visited = Array(max + 1) { false }
            val queue: Queue<Int> = LinkedList()
            queue.add(start)
            while (!queue.isEmpty()) {
                ans++
                val size = queue.size
                for (i in 0..size - 1) {
                    val node = queue.remove()
                    visited[node] = true
                    val nextNode = map[node]
                    if (nextNode != null) {
                        for (item in nextNode) {
                            if (!visited[item]) {
                                queue.add(item)
                            }
                        }
                    }
                }
            }
            return ans - 1
        }
    }
}