/*

25193번 - 곰곰이의 식단 관리
https://www.acmicpc.net/problem/25193

C가 연속으로 붙어있는 개수는 C가 아닌 문자들의 개수에 따라 바뀐다.

*/

package baekjoon_kotlin._25000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    nextToken()
    val n = nval.toInt()
    nextToken()
    println(n / (sval.count { it != 'C' } + 1))
}

/*

*/