import java.util.*

fun main() {
    // write your code here    
    val scanner = Scanner(System.`in`)
    val s = scanner.nextLine()
    val separatorPos = s.lastIndexOf(' ')
    val n = s.substring(separatorPos + 1).toInt()
    s.substring(0, separatorPos)
            .let {
                if (n < it.length) {
                    it.substring(n) + it.substring(0, n)
                } else {
                    it
                }
            }
            .let { println(it) }
}