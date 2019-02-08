package arcade

fun chessBoardCellColor(cell1: String, cell2: String): Boolean {
    return ((cell1[1].toInt() + cell1[0].toInt()) % 2) == ((cell2[1].toInt() + cell2[0].toInt()) % 2)
}

fun main(args: Array<String>) {
    println(chessBoardCellColor("A1", "C3").toString() + " ---> Should be true")
    println(chessBoardCellColor("A1", "H3").toString() + " ---> Should be false")
}
