package questions

import models.ListNode

class Question_203_Remove_Linked_List_Elements {

    companion object {

        fun runQuestion() {
//            Input: head = [1,2,6,3,4,5,6], val = 6
//            Output: [1,2,3,4,5]
            val listNode1 = ListNode(1)
            val listNode2 = ListNode(2)
            listNode1.next = listNode2
            val listNode3 = ListNode(6)
            listNode2.next = listNode3
            val listNode4 = ListNode(3)
            listNode3.next = listNode4
            val listNode5 = ListNode(4)
            listNode4.next = listNode5
            val listNode6 = ListNode(5)
            listNode5.next = listNode6
            val listNode7 = ListNode(6)
            listNode6.next = listNode7
            val head = listNode1
            val `val` = 6
            val resultListNode = removeElements(head, `val`)
            var tempResultList: ListNode? = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList!!.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 203: $result")
        }

        fun removeElements(head: ListNode?, `val`: Int): ListNode? {
            var previous: ListNode? = null
            var current = head
            var newHead = head
            while (current != null) {
                val next = current?.next
                if (current?.`val` == `val`) {
                    if (previous != null) {
                        previous?.next = next
                    } else {
                        newHead = next
                        current = null
                    }
                } else {
                    previous = current
                }
                current = next
            }
            return newHead
        }

        fun removeElementsWithList(head: ListNode?, `val`: Int): ListNode? {
            if (head == null) {
                return null
            }
            val result: MutableList<ListNode?> = mutableListOf()
            var current = head
            while (current != null) {
                result.add(ListNode(current?.`val`!!))
                current = current?.next
            }
            var newHead = result[0]
            var count = 0
            while (count <= result.size - 1) {
                if (result[count]?.`val` != `val`) {
                    if (count > 0) {
                        result[count - 1]?.next = result[count]
                    }
                    count++
                } else {
                    result.removeAt(count)
                    if (count == 0) {
                        if (result.size == 0) {
                            return null
                        }
                        newHead = result[0]
                    }
                }
            }
            return newHead
        }
    }
}