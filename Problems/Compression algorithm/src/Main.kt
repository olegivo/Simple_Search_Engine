import java.util.*

fun main() {
    // write your code here    
    val s = Scanner(System.`in`).nextLine()
    if (s.isEmpty()) return

    val result = buildString {
        var prev = s.first()
        var count = 1
        for (c in s.drop(1)) {
            if (c == prev) {
                count++
            } else {
                append(prev)
                append(count)
                prev = c
                count = 1
            }
        }
        append(prev)
        append(count)
    }
    println(result)
}