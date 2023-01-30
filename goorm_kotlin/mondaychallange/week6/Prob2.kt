package mondaychallange.week6

/*

*/

import kotlin.math.pow

private val Char.digit get() = toInt() - '0'.toInt()

fun main() = System.`in`.bufferedReader().run {
    val alpha = ('a'..'z').toList()
    val n = readLine().toInt()
    val pass = readLine().chunked(2)
    val sb = StringBuilder()
    for (i in 0 until n / 2) {
        val index = (pass[i][0].toInt() - 'a'.toInt() + pass[i][1].digit.toDouble().pow(2).toInt()) % alpha.size
        sb.append(alpha[index])
    }
    print(sb)
}

/*

*/