package search

import java.util.*

fun main() {
    val source = scanner.nextLine().split(' ')
    val find = scanner.nextLine()
    println(find(source, find) ?: "Not found")
}

private fun find(source: List<String>, find: String?): Int? =
        source.indices
                .firstOrNull { source[it] == find }
                ?.let { it + 1 }

val scanner = Scanner(System.`in`)
