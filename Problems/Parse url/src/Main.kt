import java.util.*

fun main() {
    // write your code here    
    val s = Scanner(System.`in`).nextLine()
    s.split('?')
            .lastOrNull()
            ?.split('&')
            ?.map {
                val pair = it.split('=')
                val key = pair.first()
                val value = if (pair.count() == 2) {
                    pair.last().takeIf { it.isNotEmpty() }
                } else {
                    null
                }
                key to value
            }
            ?.associate { it }
            ?.let { map ->
                for ((key, value) in map) {
                    println("$key : ${value ?: "not found"}")
                }
                map["pass"]?.let {
                    println("password : $it")
                }
            }
}