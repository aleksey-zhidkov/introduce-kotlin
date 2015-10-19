package delegateclass

private class LyingList<T>(l: List<T>) : List<T> by l {

    override fun contains(o: Any?): Boolean = true

}

fun main(args: Array<String>) {
    val ll = LyingList(listOf(1, 2, 3))
    ll.forEach { println(it) }
    println(ll.isEmpty())
    println(ll.contains(4))
}
