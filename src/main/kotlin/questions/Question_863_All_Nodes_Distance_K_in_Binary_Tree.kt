package questions

import models.TreeNode
import java.util.*
import kotlin.math.min


class Question_863_All_Nodes_Distance_K_in_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//            Output: [7,4,1]
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(3)
            val treeNode2 = TreeNode(5)
            val treeNode3 = TreeNode(1)
            val treeNode4 = TreeNode(6)
            val treeNode5 = TreeNode(2)
            val treeNode6 = TreeNode(0)
            val treeNode7 = TreeNode(8)
            val treeNode8 = TreeNode(7)
            val treeNode9 = TreeNode(4)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNode5.left = treeNode8
            treeNode5.right = treeNode9
            treeNodes = treeNode1
            val target = treeNode2
            val k = 2
            val result = distanceK(treeNodes, target, k)
            println("Question 863: $result")
        }

        fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
            val stored: MutableList<IntArray> = mutableListOf()
            val queue: Queue<TreeNode?> = LinkedList()
            var n = 0
            queue.add(root)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                n++
                if (node?.left != null) {
                    addEdge(node, node?.left, stored)
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    addEdge(node, node?.right, stored)
                    queue.add(node?.right)
                }
            }
            if (n < k) {
                return listOf()
            }
            // stored.forEach{
            //     println(it.contentToString())
            // }
            var result = IntArray(n) { Int.MAX_VALUE }
            result[target?.`val`!!] = 0
            for (count in 1..k) {
                val temp = result.toMutableList()
                for (item in stored) {
                    if (result[item[0]] != Int.MAX_VALUE) {
                        temp[item[1]] = min(temp[item[1]], result[item[0]] + item[2])
                    }
                }
                result = temp.toIntArray()
                // println(result.contentToString())
            }
            val ans: MutableList<Int> = mutableListOf()
            for (count in 0..result.size - 1) {
                if (result[count] == k) {
                    ans.add(count)
                }
            }
            return ans
        }

        fun addEdge(node: TreeNode?, nextNode: TreeNode?, stored: MutableList<IntArray>) {
            val edge = intArrayOf(node?.`val`!!, nextNode?.`val`!!, 1)
            val edgeReversed = intArrayOf(nextNode?.`val`!!, node?.`val`!!, 1)
            stored.add(edge)
            stored.add(edgeReversed)
        }
    }
}