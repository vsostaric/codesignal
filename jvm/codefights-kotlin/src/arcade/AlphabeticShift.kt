package arcade

fun alphabeticShift(inputString: String): String {
    return inputString
            .map { character -> character.toInt() }
            .map { asciiCode ->
                if (asciiCode != 122) (asciiCode + 1) else 97
            }
            .map { asciiCode -> asciiCode.toChar() }.joinToString("")

}


fun main(args: Array<String>) {
    println(alphabeticShift("crazy") + " ---> Should be dsbaz")
    println(alphabeticShift("z") + " ---> Should be a")
}