package arcade

fun digitDegree(n: Int): Int {

    if (n < 10) {
        return 0
    }
    val digitSum = n.toString()
            .map { el -> el.toString().toInt() }
            .toIntArray().sum()
    return digitDegree(digitSum) + 1

}

fun main(args: Array<String>) {

    println("5")
    println("5".toInt())
    println('5'.toInt())
    println('5'.toString().toInt())

    println(digitDegree(5).toString() + " -> Should be 0")
    println(digitDegree(100).toString() + " -> Should be 1")
    println(digitDegree(91).toString() + " -> Should be 2")
    println(digitDegree(99).toString() + " -> Should be 2")

}