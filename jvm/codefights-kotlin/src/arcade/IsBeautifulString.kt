package arcade

fun isBeautifulString(inputString: String): Boolean {
    var characterCounts = (97..122)
            .map { el -> el.toChar() }
            .map { el -> inputString.filter { char -> char == el }.count() }

    for (i in 1..characterCounts.size-1) {
        if (characterCounts[i] > characterCounts[i - 1]) {
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    println(isBeautifulString("bbbaacdafe").toString() + " -> Should be true")
    println(isBeautifulString("aabbb").toString() + " -> Should be false")
    println(isBeautifulString("bbc").toString() + " -> Should be false")
    println(isBeautifulString("bbbaa").toString() + " -> Should be false")
    println(isBeautifulString("abcdefghijklmnopqrstuvwxyz").toString() + " -> Should be true")
}