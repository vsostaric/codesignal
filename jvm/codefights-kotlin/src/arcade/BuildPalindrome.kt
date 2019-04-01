package arcade

fun buildPalindrome(st: String): String {

    val central = getCentralPalindrome(st)

    if (st.equals(central)) {
        return st
    }

    var result = st;
    for (i in 0..(st.length - central.length - 1)) {
        result += st[st.length - central.length - i - 1]
    }

    return result
}

fun getCentralPalindrome(st: String): String {

    for (i in 0..st.length - 1) {
        if (isPalindrom(st.substring(i))) {
            return st.substring(i)
        }
    }

    return st
}

fun isPalindrom(st: String): Boolean {
    var i = 0
    while (i < st.length / 2) {
        val left = st.get(i)
        val right = st.get(st.length - i - 1)
        if (!left.equals(right)) {
            return false
        }
        i++
    }

    return true
}

fun main(args: Array<String>) {

    println("Testing isPalindrom")
    println(isPalindrom("abba").toString() + " -> Should be true")
    println(isPalindrom("abcba").toString() + " -> Should be true")

    println("Testing buildPalindrome")
    println(buildPalindrome("abcdc") + " -> Should be abcdcba")
    println(buildPalindrome("ababab") + " -> Should be abababa")
    println(buildPalindrome("abba") + " -> Should be abba")
    println(buildPalindrome("abaa") + " -> Should be abaaba")
    println(buildPalindrome("aaaaba") + " -> Should be aaaabaaaa")
    println(buildPalindrome("abc") + " -> Should be abcba")
    println(buildPalindrome("kebab") + " -> Should be kebabek")
    println(buildPalindrome("abccba") + " -> Should be abccba")
    println(buildPalindrome("abcabc") + " -> Should be abcabcbacba")
    println(buildPalindrome("cbdbedffcg") + " -> Should be cbdbedffcgcffdebdbc")
    println(buildPalindrome("euotmn") + " -> Should be euotmnmtoue")
}