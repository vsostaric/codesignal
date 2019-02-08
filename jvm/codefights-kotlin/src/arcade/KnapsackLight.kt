package arcade

class Item {
    var value: Int
    var weight: Int
    var factor: Float

    constructor(value: Int, weight: Int) {
        this.value = value
        this.weight = weight
        this.factor = value.toFloat() / weight.toFloat()
    }

}

fun knapsackLight(value1: Int, weight1: Int, value2: Int, weight2: Int, maxW: Int): Int {

    val items: MutableList<Item> = arrayListOf(
            Item(value1, weight1),
            Item(value2, weight2)
    )

    val sortedItems = items.sortedByDescending(Item::value)

    var space = maxW
    var carriedWeight = 0

    for (item: Item in sortedItems) {

        if (item.weight <= space) {
            carriedWeight += item.value
            space -= item.weight
        }

    }

    return carriedWeight
}

fun main(args: Array<String>) {

    println(knapsackLight(10, 5, 6, 4, 8).toString() + " --> Should be 10")
    println(knapsackLight(10, 5, 6, 4, 9).toString() + " --> Should be 16")
    println(knapsackLight(5, 3, 7, 4, 6).toString() + " --> Should be 7")
    println(knapsackLight(10, 2, 11, 3, 1).toString() + " --> Should be 0")

}
