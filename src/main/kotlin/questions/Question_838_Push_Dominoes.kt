package questions

import java.util.*
import kotlin.math.max

class Question_838_Push_Dominoes {

    companion object {

        fun runQuestion() {
//            Input: dominoes = ".L.R...LR..L.."
//            Output: "LL.RR.LLRRLL.."
            val dominoes = ".L.R...LR..L.."
            val result = pushDominoes(dominoes)
            println("Question 838: $result")
        }

        fun pushDominoes(dominoes: String): String {
            val queue: Queue<Char> = LinkedList()
            val result = StringBuilder()
            val temp: MutableList<Char> = mutableListOf()
            for (count in 0..dominoes.length - 1) {
                val item = dominoes[count]
                queue.add(item)
                if (item == 'L' || count == dominoes.length - 1) {
                    while (!queue.isEmpty()) {
                        temp.add(queue.remove())
                    }
                    var left = temp.lastIndexOf('R')
                    var right = temp.indexOf('L')
                    if (left == -1 && right != -1) {
                        var hasLeft = false
                        for (count in temp.size - 1 downTo 0) {
                            if (hasLeft) {
                                temp[count] = 'L'
                            }
                            if (temp[count] == 'L') {
                                hasLeft = true
                            }
                        }
                        appendToResult(result, temp)
                        continue
                    } else if (right == -1 && left != -1) {
                        var hasRight = false
                        for (count in 0..temp.size - 1) {
                            if (hasRight) {
                                temp[count] = 'R'
                            }
                            if (temp[count] == 'R') {
                                hasRight = true
                            }
                        }
                        appendToResult(result, temp)
                        continue
                    } else if (right == -1 && left == -1) {
                        appendToResult(result, temp)
                        continue
                    } else {
                        var firstLeft = temp.indexOf('R')
                        var lastRight = temp.lastIndexOf('L')
                        for (index in firstLeft..left) {
                            temp[index] = 'R'
                        }
                        for (index in right..lastRight) {
                            temp[index] = 'L'
                        }
                        while (left < right) {
                            temp[left] = 'R'
                            temp[right] = 'L'
                            left++
                            right--
                        }
                        appendToResult(result, temp)
                    }
                }
            }
            return result.toString()
        }

        fun appendToResult(result: StringBuilder, temp: MutableList<Char>) {
            for (item in temp) {
                result.append(item)
            }
            temp.clear()
        }

        fun pushDominoesWithScore(dominoes: String): String {
            val scores = IntArray(dominoes.length) { 0 }
            val n = dominoes.length
            var score = 0
            for (count in 0..n - 1) {
                if (dominoes[count] == 'R') {
                    score = n
                } else if (dominoes[count] == 'L') {
                    score = 0
                } else {
                    score = max(score - 1, 0)
                }
                scores[count] += score
            }
            score = 0
            for (count in n - 1 downTo 0) {
                if (dominoes[count] == 'L') {
                    score = n
                } else if (dominoes[count] == 'R') {
                    score = 0
                } else {
                    score = max(score - 1, 0)
                }
                scores[count] -= score
            }
            val result = StringBuilder()
            for (count in 0..n - 1) {
                if (scores[count] > 0) {
                    result.append('R')
                } else if (scores[count] < 0) {
                    result.append('L')
                } else {
                    result.append('.')
                }
            }
            return result.toString()
        }

        fun pushDominoesAnotherSolution(dominoes: String): String {
            val dom = dominoes.toCharArray()
            val queue: Queue<Int> = LinkedList()
            for (count in 0..dom.size - 1) {
                if (dom[count] == '.') {
                    continue
                }
                queue.add(count)
            }
            while (!queue.isEmpty()) {
                val index = queue.remove()
                val current = dom[index]
                if (current == 'R') {
                    if (index + 1 <= dom.size - 1 && dom[index + 1] == '.') {
                        if (index + 2 <= dom.size - 1 && dom[index + 2] == 'L') {
                            queue.remove()
                        } else {
                            dom[index + 1] = 'R'
                            queue.add(index + 1)
                        }
                    }
                } else {
                    if (index - 1 >= 0 && dom[index - 1] == '.') {
                        dom[index - 1] = 'L'
                        queue.add(index - 1)
                    }
                }
            }
            return String(dom)
        }
    }
}