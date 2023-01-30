package mondaychallange.week6

private val Char.digit get() = toInt() - '0'.toInt()

fun main() = System.`in`.bufferedReader().run {
    val lower = ('a'..'z').toList()
    val upper = ('A'..'Z').toList()
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val input = readLine().toCharArray()
        val (type, token) = readLine().split(" ", limit = 2)
        token.forEachIndexed { index, c ->
            if (c.isLetter().not()) sb.append(c)
            else {
                val shift = token[index % token.length].toInt() % lower.size

            }
        }
        sb.appendLine()
    }
}