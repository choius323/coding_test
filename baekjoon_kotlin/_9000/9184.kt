package baekjoon_kotlin._9000

/*

9184번 - 신나는 함수 실행
https://www.acmicpc.net/problem/9184
분류 : 다이나믹 프로그래밍, 재귀

a, b, c 중 하나라도 0 이하이거나 21 이상일 때를 제외하고 값을 기억해둔 후, 다음에 다시 사용할 수 있도록 한다.
매번 계산하게 되면 시간이 굉장히 오래걸리기 때문에 DP를 활용해야 한다.
계산한 결과는 항상 0보다 크기 때문에 배열의 값이 0일 때는 계산하지 않았다고 판단했다.

*/

/*
fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val dp = Array(21) { Array(21) { IntArray(21) } }
    fun w(a: Int, b: Int, c: Int): Int {
        return if (a <= 0 || b <= 0 || c <= 0) 1
        else if (a > 20 || b > 20 || c > 20) w(20, 20, 20)
        else if (dp[a][b][c] != 0) dp[a][b][c]
        else {
            dp[a][b][c] = if (b in (a + 1) until c) {
                w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
            } else w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
            dp[a][b][c]
        }
    }

    val sb = StringBuilder()
    while (true) {
        val a = r()
        val b = r()
        val c = r()
        if (a == -1 && b == -1 && c == -1) break
        sb.append("w($a, $b, $c) = ${w(a, b, c)}\n")
    }
    print(sb)
}
*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val dp = Array(21) { Array(21) { IntArray(21) } }

    fun Int.range() = minOf(maxOf(this, 0), 20)
    operator fun Array<Array<IntArray>>.get(a: Int, b: Int, c: Int) = this[a.range()][b.range()][c.range()]
    operator fun Array<Array<IntArray>>.set(a: Int, b: Int, c: Int, d: Int) {
        this[a.range()][b.range()][c.range()] = d
    }

    fun w(a: Int, b: Int, c: Int): Int = when {
        a <= 0 || b <= 0 || c <= 0 -> 1
        a > 20 || b > 20 || c > 20 -> w(20, 20, 20)
        dp[a, b, c] != 0 -> dp[a, b, c]
        a < b && b < c -> (w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)).also { dp[a, b, c] = it }
        else -> (w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1))
            .also { dp[a, b, c] = it }
    }

    val sb = StringBuilder()
    while (true) {
        val a = r()
        val b = r()
        val c = r()
        if (a == -1 && b == -1 && c == -1) break
        sb.appendLine("w($a, $b, $c) = ${w(a, b, c)}")
    }
    print(sb)
}
/*

*/