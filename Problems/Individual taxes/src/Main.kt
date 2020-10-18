import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val n = scanner.nextInt()
    val incomes = (1..n).map { scanner.nextDouble() }
    val taxes = (1..n).map { scanner.nextDouble() }
    (1..n)
            .map {
                val i = it - 1
                incomes[i] * taxes[i] / 100 to it
            }
            .sortedByDescending { it.first }
            .let {
                val max = it.first().first
                it.filter { it.first == max }
                        .minBy { it.second }?.second
            }
            ?.let { println(it) }

}