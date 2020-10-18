import java.util.*

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val s = scanner.nextLine()
    (0..s.length / 2).all {
        s[it] == s[s.length - 1 - it]
    }.let { println(if (it) "yes" else "no") }
}