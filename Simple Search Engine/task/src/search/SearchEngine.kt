package search

import java.io.File

class SearchEngine {
    private lateinit var invertedIndex: Map<String, List<Int>>
    private lateinit var persons: List<String>

    fun inputPeoples() {
        println("Enter the number of people:")
        val n = scanner.nextLine().toInt()
        println("Enter all people:")
        persons = (1..n).map { scanner.nextLine() }
    }

    fun readFile(fileName: String) {
        persons = File(fileName).readLines()
    }

    fun findPerson() {
        println("Select a matching strategy: ALL, ANY, NONE")
        val strategy = Strategy.get(scanner.nextLine())

        println("Enter a name or email to search all suitable people.")
        val query = scanner.nextLine()
        val queryWords = query.toLowerCase().split(' ')
        val searchResults = queryWords.mapNotNull { queryWord -> invertedIndex[queryWord] }
                .let { results ->
                    when (strategy) {
                        Strategy.ALL -> intersection(results).toList()
                        Strategy.ANY -> union(results)
                        Strategy.NONE -> (persons.indices.toSet() - union(results)).toList()
                        else -> {
                            TODO("unknown strategy")
                        }
                    }
                }
        if (searchResults.isEmpty()) {
            println("No matching people found.")
        } else {
            println("Found people:")
            searchResults.map { persons[it] }.forEach {
                println(it)
            }
        }
    }

    private fun union(results: List<List<Int>>) = results.flatten().distinct()

    private fun intersection(results: List<List<Int>>): Set<Int> {
        val sets = results.map { it.toSet() }
        return sets.drop(1).fold(sets.firstOrNull() ?: emptySet()) { acc, set -> set.intersect(acc) }
    }

    fun listOfPeople() {
        println("=== List of people ===")
        persons.forEach {
            println(it)
        }
    }

    fun buildIndex() {
        val words = persons.asSequence().flatMap { it.split(' ') }.map { it.toLowerCase() }.distinct()
        invertedIndex = words.associateWith { word ->
            persons.mapIndexedNotNull { index, person ->
                if (person.contains(word, ignoreCase = true)) index else null
            }
        }
    }

    enum class Strategy(val value: String) {
        ALL("all"),
        ANY("any"),
        NONE("none"),
        NULL("?");

        companion object {
            fun get(value: String?) =
                    values()
                            .firstOrNull { it.value.equals(value, ignoreCase = true) }
                            ?: NULL

        }
    }
}