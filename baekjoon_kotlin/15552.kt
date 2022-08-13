/*

15552번 - 빠른 A+B
https://www.acmicpc.net/problem/15552

입력은 System.`in`.bufferedReader()를 사용하고 출력은 System.out.bufferedReader()나 StringBuilder()를 사용한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val bw = System.out.bufferedWriter()
    repeat(r()) { bw.appendLine((r() + r()).toString()) }
    bw.flush()
}

/*

*/