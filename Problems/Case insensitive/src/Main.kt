import java.util.*

fun main() {
    // put your code here
    Scanner(System.`in`).let {
        println(it.nextLine().equals(it.nextLine(), ignoreCase = true))
    }
}