import java.util.*

fun main() {
    // write your code here    
    val scanner = Scanner(System.`in`)
    val s = scanner.nextLine()
    println(s.length == 1 ||
            (1 until s.length).all { s[it].toInt() - 1 == s[it - 1].toInt() }
    )
}