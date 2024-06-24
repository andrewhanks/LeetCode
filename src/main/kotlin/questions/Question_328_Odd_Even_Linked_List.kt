package questions

import Utils.Companion.printListNode
import models.ListNode

class Question_328_Odd_Even_Linked_List {

    companion object {

        fun runQuestion() {
//            Input: head = [1,2,3,4,5]
//            Output: [1,3,5,2,4]
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
            val resultList = oddEvenList(head)
            val result = printListNode(resultList)
            println("Question 328: $result")
        }

        fun oddEvenList(head: ListNode?): ListNode? {
            var evenFirstNode: ListNode? = null
            var currentOdd = head
            var currentEven: ListNode? = null
            while (currentOdd != null) {
                val firstNode = currentOdd?.next
                val secondNode = currentOdd?.next?.next
                // println("firstNode = ${firstNode?.`val`}, secondNode = ${secondNode?.`val`}")
                if (evenFirstNode == null) {
                    evenFirstNode = firstNode
                    // println("evenFirstNode = ${evenFirstNode?.`val`}")
                    currentEven = evenFirstNode
                    currentEven?.next = null
                } else if (firstNode != null) {
                    currentEven?.next = firstNode
                    currentEven = firstNode
                    currentEven?.next = null
                }
                if (firstNode == null) {
                    currentOdd?.next = evenFirstNode
                    // println("currentOdd = ${currentOdd?.`val`}, evenfirstnode = ${evenFirstNode?.`val`}")
                    break
                } else if (secondNode == null) {
                    currentOdd?.next = evenFirstNode
                    // println("currentOdd = ${currentOdd?.`val`}, evenfirstnode = ${evenFirstNode?.`val`}")
                    break
                } else {
                    currentOdd?.next = secondNode
                    currentOdd = secondNode
                }
            }
            return head
        }
    }
}