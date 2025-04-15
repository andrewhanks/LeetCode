package questions

import models.TreeNode
import java.util.*


class Question_1145_Binary_Tree_Coloring_Game {

    companion object {

        fun runQuestion() {
//            Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
//            Output: true
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
            val root = treeNode1
            val n = 11
            val x = 3
            val result = btreeGameWinningMove(root, n, x)
            println("Question 1145: $result")
        }

        fun btreeGameWinningMove(root: TreeNode?, n: Int, x: Int): Boolean {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            val queue: Queue<TreeNode> = LinkedList()
            queue.add(root)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                if (node?.left != null) {
                    var list = map.getOrDefault(node?.`val`!!, mutableListOf())
                    list.add(node?.left?.`val`!!)
                    map[node?.`val`!!] = list
                    list = map.getOrDefault(node?.left?.`val`!!, mutableListOf())
                    list.add(node?.`val`!!)
                    map[node?.left?.`val`!!] = list
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    var list = map.getOrDefault(node?.`val`!!, mutableListOf())
                    list.add(node?.right?.`val`!!)
                    map[node?.`val`!!] = list
                    list = map.getOrDefault(node?.right?.`val`!!, mutableListOf())
                    list.add(node?.`val`!!)
                    map[node?.right?.`val`!!] = list
                    queue.add(node?.right)
                }
            }
            val xList = map[x]
            val priorityQueue: PriorityQueue<Int> = PriorityQueue { a, b ->
                b - a
            }
            val chosen: MutableList<Boolean> = MutableList(n + 1) { false }
            chosen[x] = true
            if (xList != null) {
                for (item in xList) {
                    val total = count(map, chosen, item)
                    // println("item = $item, total = $total")
                    priorityQueue.add(total)
                }
            }
            val max = priorityQueue.remove()
            // println("max = $max")
            var others = 0
            while (!priorityQueue.isEmpty()) {
                others += priorityQueue.remove()
                // println("others = $others")
            }
            if (max > others) {
                return true
            } else {
                return false
            }
        }

        fun count(map: MutableMap<Int, MutableList<Int>>, chosen: MutableList<Boolean>, item: Int): Int {
            val queue: Queue<Int> = LinkedList()
            var count = 1
            queue.add(item)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                chosen[node] = true
                val list = map[node]
                if (list != null) {
                    for (number in list) {
                        if (chosen[number]) {
                            continue
                        }
                        count++
                        queue.add(number)
                    }
                }
            }
            return count
        }
    }
}