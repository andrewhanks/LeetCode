package questions

import models.ListNode

class Question_142_Linked_List_Cycle_II {

    companion object {

        fun runQuestion() {
//            Input: head = [3,2,0,-4], pos = 1
//            Output: tail connects to node index 1
            val listNode1 = ListNode(3)
            val listNode2 = ListNode(2)
            listNode1.next = listNode2
            val listNode3 = ListNode(0)
            listNode2.next = listNode3
            val listNode4 = ListNode(-4)
            listNode3.next = listNode4
            listNode4.next = listNode2
            val head = listNode1
            val resultListNode = detectCycle(head)
            var tempResultCurrent: ListNode? = resultListNode
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
            println("Question 142: $result")
        }

        fun detectCycle(head: ListNode?): ListNode? {
            val visited: MutableList<ListNode?> = mutableListOf()
            var current = head
            while (current != null) {
                if (visited.contains(current)) {
                    return current
                }
                visited.add(current)
                current = current?.next
            }
            return null
        }


        // solution: https://ithelp.ithome.com.tw/articles/10223721
        fun detectCycleWithTwoPointers(head: ListNode?): ListNode? {
            var slow: ListNode? = head
            var fast: ListNode? = head

            while (fast?.next != null) {
                slow = slow?.next
                fast = fast.next?.next
                if (slow == fast) {
                    slow = head
                    while (slow != fast) {
                        slow = slow?.next
                        fast = fast?.next
                    }
                    return slow
                }
            }
            return null
        }
    }
}