package questions

import java.util.*

class Question_870_Advantage_Shuffle {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//            Output: [24,32,8,12]
            val nums1 = intArrayOf(12, 24, 8, 32)
            val nums2 = intArrayOf(13, 25, 32, 11)
            val result = advantageCount(nums1, nums2)
            println("Question 870: ${result.contentToString()}")
        }

        fun advantageCount(nums1: IntArray, nums2: IntArray): IntArray {
            val nums1Sorted = nums1.sortedDescending()
            val nums2IndexSorted = MutableList(nums2.size) { 0 }
            for (count in 0..nums2IndexSorted.size - 1) {
                nums2IndexSorted[count] = count
            }
            nums2IndexSorted.sortWith(Comparator { a, b ->
                nums2[b] - nums2[a]
            })
            val stack: Stack<Int> = Stack()
            var index1 = 0
            var index2 = 0
            val result = IntArray(nums1.size) { -1 }
            while (index1 <= nums1Sorted.size - 1 && index2 <= nums2IndexSorted.size - 1) {
                if (!stack.isEmpty() && nums1Sorted[index1] > nums2[stack.peek()]) {
                    result[stack.removeLast()] = nums1Sorted[index1]
                    if (index1 < nums1Sorted.size - 1) {
                        index1++
                    }
                } else {
                    stack.add(nums2IndexSorted[index2])
                    index2++
                }
            }
            while (!stack.isEmpty()) {
                result[stack.removeLast()] = nums1Sorted[index1]
                index1++
            }
            return result
        }

        fun advantageCountWithTreeMap(nums1: IntArray, nums2: IntArray): IntArray {
            val map: TreeMap<Int, Int> = TreeMap()
            for (count in 0..nums1.size - 1) {
                map[nums1[count]] = map.getOrDefault(nums1[count], 0) + 1
            }
            val result = IntArray(nums2.size) { -1 }
            for (count in 0..nums2.size - 1) {
                var key = map.higherKey(nums2[count])
                if (key != null) {
                    result[count] = key
                    decreaseKey(map, key)
                } else {
                    val firstKey = map.firstKey()
                    result[count] = firstKey
                    decreaseKey(map, firstKey)
                }
            }
            return result
        }

        fun decreaseKey(map: TreeMap<Int, Int>, key: Int) {
            map[key] = map[key]!! - 1
            if (map[key]!! == 0) {
                map.remove(key)
            }
        }

        fun advantageCountSlowSolution(nums1: IntArray, nums2: IntArray): IntArray {
            // 0: index, 1: value
            val nums2PQ: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                b[1] - a[1]
            }
            nums2.forEachIndexed { index, value ->
                nums2PQ.add(intArrayOf(index, value))
            }
            val nums1SortedDescending = nums1.sortedDescending().toMutableList()
            val result = IntArray(nums1.size)
            for (i in 0..nums2.size - 1) {
                val tempNum2 = nums2PQ.remove()
                if (tempNum2[1] >= nums1SortedDescending[0]) {
                    result[tempNum2[0]] = nums1SortedDescending.removeAt(nums1SortedDescending.size - 1)
                } else {
                    result[tempNum2[0]] = nums1SortedDescending.removeAt(0)
                }
            }
            return result
        }
    }
}