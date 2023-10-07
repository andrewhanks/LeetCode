package questions

import models.TreeNode
import java.util.*


class Question_103_Binary_Tree_Zigzag_Level_Order_Traversal {

    companion object {

        fun runQuestion() {
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(3)
            val treeNode2 = TreeNode(9)
            val treeNode3 = TreeNode(20)
            val treeNode4 = TreeNode(15)
            val treeNode5 = TreeNode(7)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode3.left = treeNode4
            treeNode3.right = treeNode5
            treeNodes = treeNode1
            val resultList = zigzagLevelOrder(treeNodes)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            if (']' != result.last()) {
                result += "]"
            }
            println("Question 103: $result")
        }

        fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
            if (root == null) {
                return listOf()
            }
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val queue: Queue<TreeNode?> = LinkedList()
            queue.add(root)
            var level = 1
            while (!queue.isEmpty()) {
                val levelItem: MutableList<Int> = mutableListOf()
                val size = queue.size
                for (count in 0..size - 1) {
                    val item = queue.remove()
                    if (item != null) {
                        levelItem.add(item.`val`!!)
                    }
                    if (item?.left != null) {
                        queue.add(item?.left)
                    }
                    if (item?.right != null) {
                        queue.add(item?.right)
                    }
                }
                if (level % 2 == 1) {
                    result.add(levelItem)
                } else {
                    result.add(levelItem.reversed().toMutableList())
                }
                level++
            }
            return result
        }
    }
}