/*

4796번 - 캠핑
https://www.acmicpc.net/problem/4796

단순한 계산 문제이다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val sb = StringBuilder()
    repeat(9999) {
        val l = i()
        if (l == 0) return print(sb)
        val p = i()
        val v = i()
        sb.appendLine("Case ${it + 1}: ${v / p * l + minOf(v % p, l)}")
    }
}

/*

*/