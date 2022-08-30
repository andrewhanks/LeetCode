package questions

import models.TreeNode


class Question_1110_Delete_Nodes_And_Return_Forest {

    companion object {

        fun runQuestion() {
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(4)
            val treeNode5 = TreeNode(5)
            val treeNode6 = TreeNode(6)
            val treeNode7 = TreeNode(7)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNodes = treeNode1
            val deleteArray = intArrayOf(3, 5)
            val resultList = delNodes(treeNodes, deleteArray)
            var result = "["
            resultList.forEachIndexed { index, node ->
                result += node!!.`val`
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 1110: $result")
        }

        fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
            val forest: MutableList<TreeNode?> = ArrayList()
            if (root == null) return forest
            val set: MutableSet<Int?> = HashSet()
            for (i in to_delete) {
                set.add(i)
            }
            deleteNodes(root, set, forest)
            if (!set.contains(root.`val`)) {
                forest.add(root)
            }
            return forest
        }

        private fun deleteNodes(node: TreeNode?, set: Set<Int?>, forest: MutableList<TreeNode?>): TreeNode? {
            if (node == null) return null
            node.left = deleteNodes(node.left, set, forest)
            node.right = deleteNodes(node.right, set, forest)
            if (set.contains(node.`val`)) {
                if (node.left != null) forest.add(node.left)
                if (node.right != null) forest.add(node.right)
                return null
            }
            return node
        }
    }
}