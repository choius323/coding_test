/*

3003번 - 킹, 퀸, 룩, 비숍, 나이트, 폰
https://www.acmicpc.net/problem/3003

각 기물의 원래 개수에서 입력받은 숫자를 차례대로 빼서 출력한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken(); nval.toInt() }
    "112228".forEach { print("${it.digitToInt() - r()} ") }
}

/*

*/