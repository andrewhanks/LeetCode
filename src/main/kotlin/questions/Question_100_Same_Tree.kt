package questions

import models.TreeNode


class Question_100_Same_Tree {

    companion object {

        fun runQuestion() {
//            Input: p = [1,2,3], q = [1,2,3]
//            Output: true
            val p: TreeNode
            val treeNodeP1 = TreeNode(1)
            val treeNodeP2 = TreeNode(2)
            val treeNodeP3 = TreeNode(3)
            treeNodeP1.left = treeNodeP2
            treeNodeP1.right = treeNodeP3
            p = treeNodeP1
            val q: TreeNode
            val treeNodeQ1 = TreeNode(1)
            val treeNodeQ2 = TreeNode(2)
            val treeNodeQ3 = TreeNode(3)
            treeNodeQ1.left = treeNodeQ2
            treeNodeQ1.right = treeNodeQ3
            q = treeNodeQ1
            val result = isSameTree(p, q)
            println("Question 100: $result")
        }

        fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
            if (p?.`val` != q?.`val`) {
                return false
            }
            var left = false
            if (p?.left != null && q?.left != null) {
                left = isSameTree(p?.left, q?.left)
            } else if (p?.left == null && q?.left == null) {
                left = true
            }
            var right = false
            if (p?.right != null && q?.right != null) {
                right = isSameTree(p?.right, q?.right)
            } else if (p?.right == null && q?.right == null) {
                right = true
            }
            return left && right
        }

        fun isSameTreeWebSolution(p: TreeNode?, q: TreeNode?): Boolean {
            // Base case: if both trees are null, they are identical
            if (p == null && q == null) {
                return true
            }
            // If only one tree is null or the values are different, they are not identical
            return if (p == null || q == null || p.`val` !== q.`val`) {
                false
            } else isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
            // Recursively check if the left and right subtrees are identical
        }
    }
}