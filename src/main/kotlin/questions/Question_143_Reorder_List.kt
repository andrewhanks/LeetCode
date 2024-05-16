package questions

import models.ListNode

class Question_143_Reorder_List {

    companion object {

        fun runQuestion() {
//            Input: head = [1,2,3,4,5]
//            Output: [1,5,2,4,3]
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
            reorderList(head)
            var tempResultCurrent: ListNode? = head
            var visited: MutableList<ListNode?> = mutableListOf()
            var result = "[" + tempResultCurrent?.`val`
            visited.add(tempResultCurrent)
            tempResultCurrent = tempResultCurrent?.next
            while (null != tempResultCurrent) {
                if (visited.contains(tempResultCurrent)) {
                    break
                }
                visited.add(tempResultCurrent)
                result = result + "," + tempResultCurrent.`val`
                tempResultCurrent = tempResultCurrent.next
            }
            result += "]"
            println("Question 143: $result")
        }

        fun reorderList(head: ListNode?): Unit {
            val temp: MutableList<ListNode?> = mutableListOf()
            var current = head
            while (current != null) {
                temp.add(current)
                current = current?.next
            }
            current = head
            var start = 0
            var end = temp.size - 1
            while (start <= end) {
                if (start == end) {
                    current?.next = temp[start]
                    current = current?.next
                } else {
                    current?.next = temp[start]
                    current = current?.next
                    current?.next = temp[end]
                    current = current?.next
                }
                start++
                end--
            }
            current?.next = null
        }
    }
}