package questions

import models.TreeNode
import kotlin.math.min


class Question_2096_Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another {

    companion object {

        fun runQuestion() {
//            Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
//            Output: "UURL"
            val treeNode1 = TreeNode(5)
            val treeNode2 = TreeNode(1)
            val treeNode3 = TreeNode(2)
            val treeNode4 = TreeNode(3)
            val treeNode5 = TreeNode(null)
            val treeNode6 = TreeNode(6)
            val treeNode7 = TreeNode(4)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            val root = treeNode1
            val startValue = 3
            val destValue = 6
            val result = getDirections(root, startValue, destValue)
            println("Question 2096: $result")
        }

        fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
            val pathToStart = StringBuilder()
            val pathToDest = StringBuilder()
            dfs(root, startValue, pathToStart)
            dfs(root, destValue, pathToDest)
            // println("pathToStart = ${pathToStart}, pathToDest = ${pathToDest}")
            var k = 0
            val min = min(pathToStart.length, pathToDest.length)
            for (i in 0..min - 1) {
                if (pathToStart[i] == pathToDest[i]) {
                    k++
                } else {
                    break
                }
            }
            return pathToStart.substring(k).replace("R", "U").replace("L", "U") + pathToDest.substring(k)
        }

        fun dfs(root: TreeNode?, value: Int, path: StringBuilder): Boolean {
            if (root == null) {
                return false
            }
            if (root?.`val` == value) {
                return true
            }
            path.append("L")
            if (dfs(root?.left, value, path)) {
                return true
            }
            path.deleteAt(path.length - 1)
            path.append("R")
            if (dfs(root?.right, value, path)) {
                return true
            }
            path.deleteAt(path.length - 1)
            return false
        }
    }
}