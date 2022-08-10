/*

2480번 - 주사위 세개
https://www.acmicpc.net/problem/2480

3가지 조건을 구분하고 출력한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val a = r()
    val b = r()
    val c = r()
    print(
        when {
            a == b && b == c -> 10000 + a * 1000
            a != b && b != c && a != c -> maxOf(a, b, c) * 100
            else -> 1000 + 100 * if (a == b) a else if (b == c) b else a
        }
    )
}

/*

*/