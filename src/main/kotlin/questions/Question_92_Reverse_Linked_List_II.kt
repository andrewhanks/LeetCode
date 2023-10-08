package questions

import models.ListNode

class Question_92_Reverse_Linked_List_II {

    companion object {

        fun runQuestion() {
//            Input: head = [1,2,3,4,5], left = 2, right = 4
//            Output: [1,4,3,2,5]
            val listNode1 = ListNode(1)
            val listNode2 = ListNode(2)
            listNode1.next = listNode2
            val listNode3 = ListNode(3)
            listNode2.next = listNode3
            val listNode4 = ListNode(4)
            listNode3.next = listNode4
            val listNode5 = ListNode(5)
            listNode4.next = listNode5
            val left = 2
            val right = 4
            val resultListNode = reverseBetween(listNode1, left, right)
            var tempResultList: ListNode? = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList!!.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 92: $result")
        }

        fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
            if (head?.next == null) {
                return head
            }
            val result: MutableList<ListNode?> = mutableListOf()
            var current = head
            while (current != null) {
                result.add(current)
                current = current.next
            }
            val reversedResult = result.slice(left - 1..right - 1).reversed()
            for (count in 1..reversedResult.size - 1) {
                reversedResult[count - 1]?.next = reversedResult[count]
            }
            reversedResult[reversedResult.size - 1]?.next = null
            for (count in 0..result.size - 1) {
                if (count == left - 1 && count >= 1) {
                    result[count - 1]?.next = reversedResult[count - (left - 1)]
                } else if (count == right) {
                    reversedResult[reversedResult.size - 1]?.next = result[count]
                }
            }
            if (left - 1 == 0) {
                return reversedResult[0]
            } else {
                return result[0]
            }
        }
    }
}