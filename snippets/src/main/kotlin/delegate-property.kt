package delegateproperty

class User(
        private val firstName: String,
        private val lastName: String) {

        val fullName by lazy {
                println("Calculating name")
                "$firstName $lastName"
        }

}

fun main(args: Array<String>) {
        val user = User("Aleksey", "Zhidkov")
        println(user.fullName)
        println(user.fullName)
}