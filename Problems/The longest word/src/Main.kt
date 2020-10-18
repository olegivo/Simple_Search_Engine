import java.util.*

fun main() {
    // write your code here    
    val s = Scanner(System.`in`).nextLine()
    s.split(' ')
            .maxBy { it.length }
            ?.let { println(it) }
}