package questions

import kotlin.math.pow

class Question_1079_Letter_Tile_Possibilities {

    companion object {

        fun runQuestion() {
//            Input: tiles = "AAB"
//            Output: 8
            val s = "AAB"
            val result = numTilePossibilities(s)
            println("Question 1079: $result")
        }

        fun numTilePossibilities(tiles: String): Int {
            val set: MutableSet<String> = mutableSetOf()
            val max = (2.0).pow(tiles.length) - 1
            var ans = 0
            for (i in 1..max.toInt()) {
                var selector = Integer.toBinaryString(i)
                while (selector.length < tiles.length) {
                    selector = "0" + selector
                }
                // println("selector = $selector")
                var picked = ""
                for (j in 0..selector.length - 1) {
                    if (selector[j] == '1') {
                        picked += tiles[j]
                    }
                }
                picked = String(picked.toCharArray().sorted().toCharArray())
                if (!set.contains(picked)) {
                    set.add(picked)
                    val list = IntArray(26) { 0 }
                    for (k in 0..picked.length - 1) {
                        list[picked[k] - 'A']++
                    }
                    var times = calculate(picked.length)
                    for (k in 0..25) {
                        if (list[k] == 0) {
                            continue
                        }
                        times /= calculate(list[k])
                    }
                    // println("picked = $picked, times = $times")
                    ans += times
                }
            }
            return ans
        }

        fun calculate(number: Int): Int {
            var ret = 1
            for (i in 1..number) {
                ret *= i
            }
            return ret
        }

        fun numTilePossibilitiesFaster(tiles: String): Int {
            val list = IntArray(26) { 0 }
            for (i in 0..tiles.length - 1) {
                list[tiles[i] - 'A']++
            }
            return dfs(list)
        }

        fun dfs(list: IntArray): Int {
            var ans = 0
            for (i in 0..list.size - 1) {
                if (list[i] == 0) {
                    continue
                }
                ans++
                list[i]--
                ans += dfs(list)
                list[i]++
            }
            return ans
        }
    }
}