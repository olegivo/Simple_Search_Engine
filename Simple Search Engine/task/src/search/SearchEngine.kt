package search

class SearchEngine {
    private lateinit var lines: List<String>

    fun inputPeoples() {
        println("Enter the number of people:")
        val n = scanner.nextLine().toInt()
        println("Enter all people:")
        lines = (1..n).map { scanner.nextLine() }
    }

    fun search() {
        println("Enter the number of search queries:")
        val q = scanner.nextLine().toInt()
        repeat(q) {
            searchItem()
        }
    }

    private fun searchItem() {
        println("Enter data to search people:")
        val query = scanner.nextLine()
        val searchResults = lines.filter { it.contains(query, ignoreCase = true) }
        if (searchResults.isEmpty()) {
            println("No matching people found.")
        } else {
            println("Found people:")
            searchResults.forEach {
                println(it)
            }
        }
    }
}