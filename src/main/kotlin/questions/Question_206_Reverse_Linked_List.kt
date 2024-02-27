package questions

import models.ListNode

class Question_206_Reverse_Linked_List {

    companion object {

        fun runQuestion() {
//            Input: head = [1,2,3,4,5]
//            Output: [5,4,3,2,1]
            val listNode1 = ListNode(1)
            val listNode2 = ListNode(2)
            listNode1.next = listNode2
            val listNode3 = ListNode(3)
            listNode2.next = listNode3
            val listNode4 = ListNode(4)
            listNode3.next = listNode4
            val listNode5 = ListNode(5)
            listNode4.next = listNode5
            val head = listNode1
            val resultListNode = reverseList(head)
            var tempResultList: ListNode? = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList!!.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 206: $result")
        }

        fun reverseList(head: ListNode?): ListNode? {
            var current = head
            if (head == null) {
                return null
            }
            val list: MutableList<ListNode> = mutableListOf()
            while (current != null) {
                list.add(ListNode(current?.`val`!!))
                current = current?.next
            }
            for (count in 0..list.size - 2) {
                list[count + 1]?.next = list[count]
            }
            return list[list.size - 1]
        }
    }
}