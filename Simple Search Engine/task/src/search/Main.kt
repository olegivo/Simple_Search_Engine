package search

import java.util.*

fun main(args: Array<String>) {
    val data = "--data"
    val commands = arrayOf(data)
    val paramByCommand = args.mapIndexed { index, s -> index to s }
            .filter { commands.contains(it.second) }
            .associate { it.second to args[it.first + 1] }

    val searchEngine = SearchEngine()
    paramByCommand[data]?.let {
        searchEngine.readFile(it)
    } ?: run{
        searchEngine.inputPeoples()
    }
    searchEngine.buildIndex()

    while (scanner.hasNextLine()) {
        println("""
=== Menu ===
1. Search information.
2. Print all data.
0. Exit.""")
        when (scanner.nextLine().toInt()) {
            1 -> searchEngine.findPerson()
            2 -> searchEngine.listOfPeople()
            0 -> break
            else -> println("Incorrect option! Try again.")
        }
    }
}

val scanner = Scanner(System.`in`)
