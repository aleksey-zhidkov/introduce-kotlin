package extensionmethod

operator fun String.not(): Pair<String, String> {
    val proc = Runtime.getRuntime().exec(this)
    proc.waitFor()
    return Pair(proc.inputStream.bufferedReader().readText(),
          proc.errorStream.bufferedReader().readText())
}

fun main(args: Array<String>) {
    val (stdout, stderr) = !"ls /"
    println(stdout)
}