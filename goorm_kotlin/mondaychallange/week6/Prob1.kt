package mondaychallange.week6

private val Char.digit get() = toInt() - '0'.toInt()

fun main() {
    repeat(5) { _ ->
        val k = readLine()!!
        var a = k.filterIndexed { index, _ -> index % 2 == 0 }.sumOf { it.digit }
        k.filterIndexed { index, _ -> index % 2 == 1 }.forEach { if (it != '0') a *= it.digit }
        println(a % 10)
    }
}