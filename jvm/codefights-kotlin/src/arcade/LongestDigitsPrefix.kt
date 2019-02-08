package arcade

fun longestDigitsPrefix(inputString: String): String {

    var prefix = ""
    for (character: Char in inputString) {

        val charString = character.toString()
        charString.toIntOrNull() ?: return prefix
        prefix += charString
    }

    return prefix
}

fun main(args: Array<String>) {
    println(longestDigitsPrefix("123aa1") + " -> Should be 123")
    println(longestDigitsPrefix("0123456789") + " -> Should be 0123456789")
    println(longestDigitsPrefix("  3) always check for whitespaces") + " -> Should be ")
    println(longestDigitsPrefix("12abc34") + " -> Should be 12")
}
