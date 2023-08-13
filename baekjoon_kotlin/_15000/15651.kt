package baekjoon_kotlin._15000
/*

15651번 - N과 M (3)
https://www.acmicpc.net/problem/15651

재귀 함수로 1~n까지 m번 출력하면 된다.

*/

fun main() = System.`in`.bufferedReader().run {
    val sb = StringBuilder()
    val (n, m) = readLine().split(" ").map { it.toInt() }
    fun recur(s: String) {
        if (s.length == m * 2) sb.appendLine(s)
        else repeat(n){recur(s+"${it+1} ")}
    }
    recur("")
    print(sb)
}

/*

*/