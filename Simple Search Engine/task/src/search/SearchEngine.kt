package search

import java.io.File

class SearchEngine {
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

    fun findPersons() {
        println("Enter the number of search queries:")
        val q = scanner.nextLine().toInt()
        repeat(q) {
            findPerson()
        }
    }

    fun findPerson() {
        println("Enter a name or email to search all suitable people.")
        val query = scanner.nextLine()
        val searchResults = persons.filter { it.contains(query, ignoreCase = true) }
        if (searchResults.isEmpty()) {
            println("No matching people found.")
        } else {
            println("Found people:")
            searchResults.forEach {
                println(it)
            }
        }
    }

    fun listOfPeople() {
        println("=== List of people ===")
        persons.forEach {
            println(it)
        }
    }
}