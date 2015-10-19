package smartcasts

fun parseNum(something: Any): Double = when (something) {
    is Double -> something
    is String -> something.toDouble()
    is Char ->
        if (something in '0'..'9') (something.toInt() - '0'.toInt()).toDouble()
        else Double.NaN
    else -> Double.NaN
}

fun main(args: Array<String>) {
    println(parseNum('5'))
    println(parseNum('r'))
    println(10.0)
    println("343.44")
    println(10)
}