package questions

import models.ListNode
import kotlin.math.min

class Question_2074_Reverse_Nodes_in_Even_Length_Groups {

    companion object {

        fun runQuestion() {
//            Input: head = [5,2,6,3,9,1,7,3,8,4]
//            Output: [5,6,2,3,9,1,4,8,3,7]
            val listNode1 = ListNode(5)
            val listNode2 = ListNode(2)
            listNode1.next = listNode2
            val listNode3 = ListNode(6)
            listNode2.next = listNode3
            val listNode4 = ListNode(3)
            listNode3.next = listNode4
            val listNode5 = ListNode(9)
            listNode4.next = listNode5
            val listNode6 = ListNode(1)
            listNode5.next = listNode6
            val listNode7 = ListNode(7)
            listNode6.next = listNode7
            val listNode8 = ListNode(3)
            listNode7.next = listNode8
            val listNode9 = ListNode(8)
            listNode8.next = listNode9
            val listNode10 = ListNode(4)
            listNode9.next = listNode10
            val head = listNode1
            val resultListNode = reverseEvenLengthGroups(head)
            var tempResultList: ListNode? = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList!!.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 2074: $result")
        }

        fun reverseEvenLengthGroups(head: ListNode?): ListNode? {
            val list: MutableList<ListNode> = mutableListOf()
            var current = head
            while (current != null) {
                list.add(current)
                current = current?.next
            }
            var count = 0
            var group = 2
            current = head
            while (count < list.size - 1) {
                val temp: MutableList<ListNode> = mutableListOf()
                val min = min(group, list.size - 1 - count)
                if (min % 2 == 0) {
                    for (i in count + min downTo count + 1) {
                        temp.add(list[i])
                    }
                } else {
                    for (i in count + 1..count + min) {
                        temp.add(list[i])
                    }
                }
                for (i in 0..temp.size - 1) {
                    current?.next = temp[i]
                    current = current?.next
                    count++
                }
                current?.next = null
                group++
            }
            return head
        }

        fun reverseEvenLengthGroupsByOnlyChangingValue(head: ListNode?): ListNode? {
            val list: MutableList<Int> = mutableListOf()
            var current = head
            while (current != null) {
                list.add(current?.`val`!!)
                current = current?.next
            }
            var count = 0
            var group = 2
            current = head
            while (count < list.size - 1) {
                val temp: MutableList<Int> = mutableListOf()
                val min = min(group, list.size - 1 - count)
                if (min % 2 == 0) {
                    for (i in count + min downTo count + 1) {
                        temp.add(list[i])
                    }
                } else {
                    for (i in count + 1..count + min) {
                        temp.add(list[i])
                    }
                }
                for (i in 0..temp.size - 1) {
                    current = current?.next
                    current?.`val` = temp[i]
                    count++
                }
                group++
            }
            return head
        }
    }
}