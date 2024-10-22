package questions

class Question_2115_Find_All_Possible_Recipes_from_Given_Supplies {

    companion object {

        fun runQuestion() {
//            Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
//            Output: ["bread","sandwich","burger"]
            val recipes = arrayOf("bread", "sandwich", "burger")
            val ingredients =
                listOf(listOf("yeast", "flour"), listOf("bread", "meat"), listOf("sandwich", "meat", "bread"))
            val supplies = arrayOf("yeast", "flour", "meat")
            val result = findAllRecipes(recipes, ingredients, supplies)
            println("Question 2115: $result")
        }

        fun findAllRecipes(
            recipes: Array<String>,
            ingredients: List<List<String>>,
            supplies: Array<String>
        ): List<String> {
            val result: MutableList<String> = mutableListOf()
            val allSupplies = supplies.toMutableList()
            val cooked = Array(recipes.size) { false }
            var containsAtLeastOne = true
            while (containsAtLeastOne) {
                containsAtLeastOne = false
                for (i in 0..ingredients.size - 1) {
                    if (cooked[i]) {
                        continue
                    }
                    var containsAll = true
                    for (j in 0..ingredients[i].size - 1) {
                        if (!allSupplies.contains(ingredients[i][j])) {
                            containsAll = false
                            break
                        }
                    }
                    if (containsAll) {
                        result.add(recipes[i])
                        allSupplies.add(recipes[i])
                        cooked[i] = true
                        containsAtLeastOne = true
                    }
                }
            }
            return result
        }
    }
}