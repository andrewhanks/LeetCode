package questions

import java.util.*


class Question_433_Minimum_Genetic_Mutation {

    companion object {

        fun runQuestion() {
//            Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
//            Output: 2
            val startGene = "AACCGGTT"
            val endGene = "AAACGGTA"
            val bank = arrayOf("AACCGGTA", "AACCGCTA", "AAACGGTA")
            val result = minMutation(startGene, endGene, bank)
            println("Question 433: $result")
        }

        fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
            val geneQueue: Queue<String> = LinkedList()
            val usedGene = Array(bank.size) { false }
            geneQueue.add(startGene)
            var result = 0
            while (!geneQueue.isEmpty()) {
                result++
                val size = geneQueue.size
                for (count in 1..size) {
                    val currentGene = geneQueue.remove()
                    for (bankCount in 0..bank.size - 1) {
                        if (usedGene[bankCount] == true) {
                            continue
                        }
                        if (checkDiff(currentGene, bank[bankCount])) {
                            if (endGene == bank[bankCount]) {
                                return result
                            }
                            usedGene[bankCount] = true
                            geneQueue.add(bank[bankCount])
                        }
                    }
                }
            }
            return -1
        }

        fun checkDiff(original: String, target: String): Boolean {
            var count = 0
            original.forEachIndexed { index, value ->
                if (original[index] != target[index]) {
                    count++
                }
            }
            println("$original, $target, $count")
            if (count == 1) {
                return true
            }
            return false
        }
    }
}