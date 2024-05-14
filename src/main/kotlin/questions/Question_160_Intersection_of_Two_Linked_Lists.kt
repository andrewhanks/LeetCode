package questions

import models.ListNode

class Question_160_Intersection_of_Two_Linked_Lists {

    companion object {

        fun runQuestion() {
//            Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
//            Output: Intersected at '8'
            val listA = ListNode()
            val listB = ListNode()
            val node8 = ListNode(8)
            val node4 = ListNode(4)
            val node5 = ListNode(5)
            listA.`val` = 4
            listA.next = ListNode(1)
            listA.next!!.next = node8
            listA.next!!.next!!.next = node4
            listA.next!!.next!!.next!!.next = node5
            listB.`val` = 5
            listB.next = ListNode(6)
            listB.next!!.next = ListNode(1)
            listB.next!!.next!!.next = node8
            listB.next!!.next!!.next!!.next = node4
            listB.next!!.next!!.next!!.next!!.next = node5
            val resultListNode = getIntersectionNode(listA, listB)
            var tempResultList = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 160: $result")
        }

        fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
            val result: MutableSet<ListNode> = mutableSetOf()
            var tempA = headA
            while (tempA != null) {
                result.add(tempA)
                tempA = tempA?.next
            }
            var tempB = headB
            while (tempB != null) {
                if (result.contains(tempB)) {
                    return tempB
                }
                tempB = tempB?.next
            }
            return null
        }

        fun getIntersectionNodeSlow(headA: ListNode?, headB: ListNode?): ListNode? {
            var tempA = headA
            while (tempA != null) {
                var tempB = headB
                while (tempB != null) {
                    if (tempA == tempB) {
                        return tempA
                    }
                    tempB = tempB?.next
                }
                tempA = tempA?.next
            }
            return null
        }
    }
}