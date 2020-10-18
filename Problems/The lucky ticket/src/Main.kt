import java.util.*

fun main() {
    // write your code here    
    val s = Scanner(System.`in`).nextLine()
    val map = s.toCharArray().map { it.toInt() }
    val n = s.length / 2
    val lucky = map.take(n).sum() == map.drop(n).take(n).sum()
    println(if (lucky) "Lucky" else "Regular")
}