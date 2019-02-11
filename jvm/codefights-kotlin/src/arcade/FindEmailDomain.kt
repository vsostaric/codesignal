package arcade

fun findEmailDomain(address: String): String {
    return address.split('@').last()
}

fun main(args: Array<String>) {

    println(findEmailDomain("prettyandsimple@example.com") + " ---> Should be example.com")
    println(findEmailDomain("<>[]:,;@\\\"!#\$%&*+-/=?^_{}| ~.a\\\"@example.org") + " ---> Should be example.org")
    println(findEmailDomain("someaddress@yandex.ru") + " ---> Should be yandex.ru")
    println(findEmailDomain("\\\" \\\"@xample.org") + " ---> Should be xample.org")
}