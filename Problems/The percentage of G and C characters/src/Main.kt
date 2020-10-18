import java.util.*

fun main() {
    // write your code here
    val s = Scanner(System.`in`).nextLine()
    val count = s
            .toCharArray()
            .count { it.toLowerCase() == 'g' || it.toLowerCase() == 'c' }
    println(count.toDouble() / s.length.toDouble() * 100)
}