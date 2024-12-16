package questions

import kotlin.math.abs
import kotlin.math.pow


class Question_1774_Closest_Dessert_Cost {

    companion object {

        fun runQuestion() {
//            Input: baseCosts = [2,3], toppingCosts = [4,5,100], target = 18
//            Output: 17
            val baseCosts = intArrayOf(2, 3)
            val toppingCosts = intArrayOf(4, 5, 100)
            val target = 18
            val result = closestCost(baseCosts, toppingCosts, target)
            println("Question 1774: $result")
        }

        fun closestCost(baseCosts: IntArray, toppingCosts: IntArray, target: Int): Int {
            val result: MutableList<Int> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            calculate(baseCosts, toppingCosts, target, 0, result, temp)
            return sum(baseCosts, toppingCosts, result)
        }

        fun calculate(
            baseCosts: IntArray,
            toppingCosts: IntArray,
            target: Int,
            index: Int,
            result: MutableList<Int>,
            temp: MutableList<Int>
        ) {
            if (index > toppingCosts.size) {
                // println("result = $result, temp = $temp")
                val tempSum = sum(baseCosts, toppingCosts, temp)
                val resultSum = sum(baseCosts, toppingCosts, result)
                // println("tempSum = $tempSum, resultSum = $resultSum")
                if (result.size == 0 || abs(target - tempSum) < abs(target - resultSum) ||
                    (abs(target - tempSum) == abs(target - resultSum) && tempSum < resultSum)
                ) {
                    result.clear()
                    for (count in 0..temp.size - 1) {
                        result.add(temp[count])
                    }
                }
                return
            }
            if (index == 0) {
                for (count in 0..baseCosts.size - 1) {
                    temp.add(count)
                    calculate(baseCosts, toppingCosts, target, index + 1, result, temp)
                    temp.removeAt(temp.size - 1)
                }
            } else {
                for (count in 0..2) {
                    temp.add(count)
                    calculate(baseCosts, toppingCosts, target, index + 1, result, temp)
                    temp.removeAt(temp.size - 1)
                }
            }
        }

        fun sum(baseCosts: IntArray, toppingCosts: IntArray, result: MutableList<Int>): Int {
            var ret = 0
            for (count in 0..result.size - 1) {
                if (count == 0) {
                    ret += (baseCosts[result[count]])
                } else {
                    ret += (toppingCosts[count - 1] * result[count])
                }
            }
            return ret
        }

        fun closestCostWithBitMask(baseCosts: IntArray, toppingCosts: IntArray, target: Int): Int {
            var ans = Int.MAX_VALUE
            for (i in 0..baseCosts.size - 1) {
                val till = (3f).pow(toppingCosts.size).toInt()
                for (count in 0..till) {
                    var current = baseCosts[i]
                    var temp = count
                    for (j in 0..toppingCosts.size - 1) {
                        if (temp % 3 == 1) {
                            current += toppingCosts[j]
                        } else if (temp % 3 == 2) {
                            current += toppingCosts[j] * 2
                        }
                        temp = temp / 3
                    }
                    // println("ans = $ans, current = $current, target = $target")
                    if (abs(ans - target) > abs(current - target)) {
                        ans = current
                    } else if (abs(ans - target) == abs(current - target) && current < ans) {
                        ans = current
                    }
                }
            }
            return ans
        }
    }
}