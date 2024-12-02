import kotlin.math.abs

fun main() {
    val (list1, list2) = readColumnPairsFromFile("Day01")
    println(getSimilarityScore(list1, list2))
    println(calculateDifferences(list1, list2))
}

fun getSimilarityScore(list1: List<Int>, list2: List<Int>) =
    list1.sumOf { num ->
        list2.count { it == num } * num
    }

fun calculateDifferences(list1: List<Int>, list2: List<Int>) =
    list1.sorted()
        .zip(list2.sorted())
        .sumOf { (a, b) -> abs(a - b) }