import kotlin.math.absoluteValue

fun main() {
    readInput("Day02")
        .count { line ->
            line.split(" ")
                .map(String::toInt)
                .isDampenedReportSafe()
        }.also(::println)
}

fun List<Int>.isDampenedReportSafe(): Boolean {
    if (isReportSafeNaturally()) return true
    if (size < 3) return false

    return indices.any { skipIndex ->
        filterIndexed { index, _ -> index != skipIndex }
            .isReportSafeNaturally()
    }
}

fun List<Int>.isReportSafeNaturally(): Boolean {
    if (size < 2) return false

    val firstDiff = this[1] - this[0]
    val shouldBeIncreasing = firstDiff > 0

    return firstDiff.absoluteValue in 1..3 &&
            windowed(2)
                .all { (prev, curr) ->
                    val diff = curr - prev
                    diff.absoluteValue in 1..3 &&
                            if (shouldBeIncreasing) diff > 0 else diff < 0
                }
}