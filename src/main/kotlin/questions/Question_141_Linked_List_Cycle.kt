package questions

import models.ListNode

class Question_141_Linked_List_Cycle {

    companion object {

        fun runQuestion() {
//            Input: head = [3,2,0,-4], pos = 1
//            Output: true
            val listNode1 = ListNode(3)
            val listNode2 = ListNode(2)
            listNode1.next = listNode2
            val listNode3 = ListNode(0)
            listNode2.next = listNode3
            val listNode4 = ListNode(-4)
            listNode3.next = listNode4
            listNode4.next = listNode2
            val head = listNode1
            val result = hasCycle(head)
            println("Question 141: $result")
        }

        fun hasCycle(head: ListNode?): Boolean {
            val result: MutableList<ListNode?> = mutableListOf()
            var next: ListNode? = head?.next
            var nextNext: ListNode? = head?.next?.next
            while (next != nextNext) {
                next = next?.next
                println("next?.`val` = ${next?.`val`}")
                if (result.contains(next)) {
                    return false
                }
                if (next != null) {
                    result.add(next)
                }
                nextNext = nextNext?.next?.next
                println("nextNext?.`val` = ${nextNext?.`val`}")
                if (next == null || nextNext == null) {
                    return false
                } else if (next == nextNext) {
                    return true
                }
            }
            println("next?.`val` = ${next?.`val`}, nextNext?.`val` = ${nextNext?.`val`}")
            if (next == null || nextNext == null) {
                return false
            } else {
                return true
            }
        }
    }
}