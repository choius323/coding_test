package baekjoon_kotlin._7000

/*

7579번 - 앱
https://www.acmicpc.net/problem/7579
분류 : 다이나믹 프로그래밍, 배낭 문제

dp 배열에 비용 i를 소모할 때 얻을 수 있는 최대 메모리를 저장한다.
그 후 모든 앱을 확인하며 비용 별 최대 메모리를 갱신한다.
이후 dp 배열을 확인하며 얻는 메모리가 m을 넘게되는 최소 비용을 출력한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val arrays = Array(2) { IntArray(n) { r() } }
    val dp = IntArray(10101)
    var maxC = 0
    for (i in 0 until n) {
        val use = arrays[0][i]
        val cancel = arrays[1][i]
        for (c in maxC downTo 0) {
            dp[c + cancel] = maxOf(dp[c + cancel], dp[c] + use)
        }
        maxC += cancel
    }
    for (i in dp.indices) {
        if (dp[i] >= m) return print(i)
    }
}

/*

5 60
30 10 20 35 40
3 0 3 5 4

6



*/