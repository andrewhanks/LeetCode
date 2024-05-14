package questions

import models.ListNode

class Question_21_Merge_Two_Sorted_Lists {

    companion object {

        fun runQuestion() {
//            Input: list1 = [1,2,4], list2 = [1,3,4]
//            Output: [1,1,2,3,4,4]
            val listNode1 = ListNode()
            val listNode2 = ListNode()
            listNode1.`val` = 1
            listNode1.next = ListNode(2)
            listNode1.next!!.next = ListNode(4)
            listNode2.`val` = 1
            listNode2.next = ListNode(3)
            listNode2.next!!.next = ListNode(4)
            val resultListNode = mergeTwoLists(listNode1, listNode2)
            var tempResultList = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 21: $result")
        }

        fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
            if(list1==null || list2==null) {
                if(list1==null) {
                    return list2
                }else if(list2==null) {
                    return list1
                }else {
                    return null
                }
            }
            var list1Curr = list1
            var list2Curr = list2
            var newHead:ListNode? = null
            var newCurr:ListNode? = null
            while(list1Curr!=null || list2Curr!=null) {
                if(list1Curr!=null && list2Curr!=null) {
                    println("list1Curr.`val` = ${list1Curr.`val`}, list2Curr.`val` = ${list2Curr.`val`}")
                    if(list1Curr.`val`<=list2Curr.`val`) {
                        if(newHead==null) {
                            newHead = list1Curr
                            newCurr = newHead
                        }else {
                            newCurr?.next = list1Curr
                            newCurr = newCurr?.next
                        }
                        list1Curr = list1Curr?.next
                    }else {
                        if(newHead==null) {
                            newHead = list2Curr
                            newCurr = newHead
                        }else {
                            newCurr?.next = list2Curr
                            newCurr = newCurr?.next
                        }
                        list2Curr = list2Curr?.next
                    }
                }else if(list1Curr==null) {
                    println("list2Curr.`val` = ${list2Curr?.`val`}")
                    newCurr?.next = list2Curr
                    newCurr = newCurr?.next
                    list2Curr = list2Curr?.next
                }else if(list2Curr==null) {
                    println("list1Curr.`val` = ${list1Curr?.`val`}")
                    newCurr?.next = list1Curr
                    newCurr = newCurr?.next
                    list1Curr = list1Curr?.next
                }
            }
            return newHead
        }
    }
}