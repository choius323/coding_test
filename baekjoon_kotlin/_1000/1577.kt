package baekjoon_kotlin._1000

/*

1577번 - 도로의 개수
https://www.acmicpc.net/problem/1577
분류 : 다이나믹 프로그래밍

dp로 x,y가 증가하는 방향으로 확인하며 도로를 따라서 이동하는 경우의 수를 저장한다.

한 칸에서 가로, 세로 도로 모두 공사 중일 때 값을 저장하며 이전 데이터가 지워지지 않도록 주의하자.
data class의 copy, var 등 사용

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Work(var col: Boolean = false, var row: Boolean = false) // 공사 중

    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val dp = Array(m + 1) { LongArray(n + 1) }
    dp[0][0] = 1
    val works = Array(m + 1) { Array(n + 1) { Work() } }
    repeat(r()) { _ ->
        val (a, b, c, d) = List(4) { r() }
        if (kotlin.math.abs(a - c) == 1) {
            works[b][minOf(a, c)].row = true
        } else {
            works[minOf(b, d)][a].col = true
        }
    }
    for (y in 0..m) for (x in 0..n) {
        if (y != m && works[y][x].col.not()) {
            dp[y + 1][x] += dp[y][x]
        }
        if (x != n && works[y][x].row.not()) {
            dp[y][x + 1] += dp[y][x]
        }
    }
    print(dp.last().last())
}