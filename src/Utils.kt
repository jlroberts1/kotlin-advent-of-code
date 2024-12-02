import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readText().trim().lines()

/**
 * Reads an input file and returns a pair of List<Int> from the columns of text
 */
fun readColumnPairsFromFile(filename: String) =
    Path("src/${filename}.txt")
        .readText()
        .trim()
        .lineSequence()
        .map(::getIntPairFromLine)
        .unzip()

/**
 * Converts a line to a pair of Int
 */
fun getIntPairFromLine(line: String): Pair<Int, Int> {
    val (first, second) = line.split("\\s+".toRegex())
    return first.toInt() to second.toInt()
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
