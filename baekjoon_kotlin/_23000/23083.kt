package baekjoon_kotlin._23000

/*

23083번 - 꿀벌 승연이
https://www.acmicpc.net/problem/23083
분류 : 다이나믹 프로그래밍

경로 개수를 저장하는 dp를 만들어서 순서대로 탐색하며 개수를 더해준다.
벌집이 6각형 격자로 이루어져서 대각선 이동 시 주의해야 하며, dp 배열을 문제와 다르게 0,0부터 시작했기 때문에 주의해야 한다.

*/

private typealias Pos = Pair<Int, Int>

private val Pos.x get() = first
private val Pos.y get() = second
private operator fun Array<IntArray>.get(pos: Pos) = this[pos.x][pos.y]
private operator fun Array<IntArray>.set(pos: Pos, value: Int) {
    this[pos.x][pos.y] = value
}

private const val DIV = 1e9.toInt() + 7

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val isBlank = buildSet {
        repeat(r()) {
            add(r() - 1 to r() - 1)
        }
    }

    val dp = Array(n) { IntArray(m) }
    dp[0][0] = 1

    fun Pos.getNext(d: Int): Pos =
        when (d) {
            0 -> (if (y % 2 == 0) x - 1 else x) to y + 1
            1 -> (if (y % 2 != 0) x + 1 else x) to y + 1
            2 -> x + 1 to y
            else -> error(this)
        }

    for (y in 0 until m) for (x in 0 until n) {
        val pos = x to y
        if (pos in isBlank) continue
        for (d in 0..2) {
            val next = pos.getNext(d)
            if (next.x !in 0 until n || next.y !in 0 until m || next in isBlank) continue
            dp[next] = (dp[next] + dp[pos]) % DIV
        }
    }
    print(dp.last().last())
}

/*

*/