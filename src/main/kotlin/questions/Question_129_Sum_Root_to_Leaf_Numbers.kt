package questions

import models.TreeNode


class Question_129_Sum_Root_to_Leaf_Numbers {

    companion object {

        fun runQuestion() {
//            Input: root = [4,9,0,5,1]
//            Output: 1026
            val root: TreeNode
            val treeNode1 = TreeNode(4)
            val treeNode2 = TreeNode(9)
            val treeNode3 = TreeNode(0)
            val treeNode4 = TreeNode(5)
            val treeNode5 = TreeNode(1)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            root = treeNode1
            val result = sumNumbers(root)
            println("Question 129: $result")
        }

        fun sumNumbers(root: TreeNode?): Int {
            val result: MutableList<Int> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            dfs(root, result, temp)
            return result.sum()
        }

        fun dfs(root: TreeNode?, result: MutableList<Int>, temp: MutableList<Int>) {
            if (root == null) {
                return
            }
            temp.add(root?.`val`!!)
            if (root?.left != null) {
                dfs(root?.left, result, temp)
            }
            if (root?.right != null) {
                dfs(root?.right, result, temp)
            }
            if (root?.left == null && root?.right == null) {
                var tempSum = 0
                for (count in 0..temp.size - 1) {
                    tempSum = tempSum * 10 + temp[count]
                }
                result.add(tempSum)
            }
            temp.removeAt(temp.size - 1)
        }

        var sum = 0
        fun sumNumbersOldSolution(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            val result: MutableList<Int> = mutableListOf()
            preorder(root, result)
            return sum
        }

        fun preorder(root: TreeNode?, result: MutableList<Int>) {
            result.add(root?.`val`!!)
            if (root?.left != null) {
                preorder(root?.left, result)
            }
            if (root?.right != null) {
                preorder(root?.right, result)
            }
            if (root?.left == null && root?.right == null) {
                var pathNumber = 0
                for (count in result.size - 1 downTo 0) {
                    var tempNumber = result[count]
                    for (x in 1..result.size - 1 - count) {
                        tempNumber = tempNumber * 10
                    }
                    pathNumber += tempNumber
                }
                println("pathNumber = $pathNumber")
                sum += pathNumber
                if (!result.isEmpty()) {
                    result.removeAt(result.size - 1)
                }
            }
            if (root?.left != null || root?.right != null) {
                if (!result.isEmpty()) {
                    result.removeAt(result.size - 1)
                }
            }
        }
    }
}