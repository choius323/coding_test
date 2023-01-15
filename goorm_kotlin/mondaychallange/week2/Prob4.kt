package goorm_kotlin.mondaychallange.week2

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken(); nval.toInt() }
    val n = r()
    val k = r()
    var count = 0
    repeat(k) {
        count++
        count += checkSide(n, r()) + checkSide(n, r())
    }
    print(count)
}

fun checkSide(n: Int, p: Int) = (if (p - 1 > 0) 1 else 0) + (if (p + 1 <= n) 1 else 0)
