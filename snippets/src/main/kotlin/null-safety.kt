package nullsafety

fun main(args: Array<String>) {
    var notNullable = "notNull"
    // notNullable = null // Compilation error
    notNullable.substring(0)

    var nullable = if (Math.random() < 0.5) null else "notNull"
    // nullable.substring(0) // Compilation error
    if (nullable != null) {
        nullable.substring(0)
    }

    val len = nullable?.length // Contains len or null
    val lenOrNull = len ?: 0 // Contains len or 0, so not nullable

    nullable!!.substring(0) // Throw me NPE please
    if (nullable == null) {
        return
    }
}