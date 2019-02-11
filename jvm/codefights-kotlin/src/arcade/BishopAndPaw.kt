package arcade

fun bishopAndPawn(bishop: String, pawn: String): Boolean {

    val verticalDist = Math.abs(bishop.get(0) - pawn.get(0)).toDouble()
    val horizontalDist = Math.abs(bishop.get(1) - pawn.get(1)).toDouble()

    return  verticalDist == horizontalDist

}

fun main(args: Array<String>) {
    println(bishopAndPawn("a1", "c3").toString() + " -> Should be true")
    println(bishopAndPawn("h1", "h3").toString() + " -> Should be false")
    println(bishopAndPawn("a5", "c3").toString() + " -> Should be true")
    println(bishopAndPawn("g1", "f3").toString() + " -> Should be false")
    println(bishopAndPawn("a1", "h8").toString() + " -> Should be true")
}