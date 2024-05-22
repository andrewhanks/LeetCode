package questions

import models.ListNode

class Question_234_Palindrome_Linked_List {

    companion object {

        fun runQuestion() {
//            Input: head = [1,2,2,1]
//            Output: true
            val listNode1 = ListNode(1)
            val listNode2 = ListNode(2)
            listNode1.next = listNode2
            val listNode3 = ListNode(2)
            listNode2.next = listNode3
            val listNode4 = ListNode(1)
            listNode3.next = listNode4
            val head = listNode1
            val result = isPalindrome(head)
            println("Question 234: $result")
        }

        fun isPalindrome(head: ListNode?): Boolean {
            val result: MutableList<ListNode> = mutableListOf()
            var current = head
            while (current != null) {
                result.add(current)
                current = current?.next
            }
            return check(result)
        }

        fun check(result: MutableList<ListNode>): Boolean {
            var i = 0
            var j = result.size - 1
            while (i < j) {
                if (result[i]?.`val` != result[j]?.`val`) {
                    return false
                }
                i++
                j--
            }
            return true
        }
    }
}