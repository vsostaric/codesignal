package arcade

fun longestWord(text: String): String {

    return text.split(Regex("[^a-zA-Z]"))
            .maxBy { word -> word.length }
            .toString()

}

fun main(args: Array<String>) {
    println(longestWord("Ready, steady, go!") + " ---> Should be steady")
    println(longestWord(" Ready, steady, go!") + " ---> Should be steady")
    println(longestWord("Ready[[[, steady, go!") + " ---> Should be steady")
    println(longestWord("ABCd") + " ---> Should be ABCd")
    println(longestWord("To be or not to be") + " ---> Should be not")
    println(longestWord("You are the best!!!!!!!!!!!! CodeFighter ever!") + " ---> Should be CodeFighter")
    println(longestWord("") + " ---> Should be ")
    println(longestWord("A!! AA[]z") + " ---> Should be AA")
    println(longestWord("ab-CDE-fg_hi") + " ---> Should be CDE")

}
