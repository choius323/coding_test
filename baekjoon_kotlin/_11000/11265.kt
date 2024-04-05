package baekjoon_kotlin._11000

/*

11265번 - 끝나지 않는 파티
https://www.acmicpc.net/problem/11265
분류 : 그래프 이론, 최단 경로, 플로이드–워셜

각 지점끼리 이동하는 데 걸리는 최소 시간을 모두 구한 뒤, 질문마다 답을 바로 한다.
이동 시간과 질문 시간이 같으면 파티를 즐길 수 없다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val times = Array(n) { LongArray(n) { r().toLong() } }
    for (b in 0 until n) for (a in 0 until n) for (c in 0 until n) {
        times[a][c] = minOf(times[a][c], times[a][b] + times[b][c])
    }
    repeat(m) {
        println(
            if (times[r() - 1][r() - 1] <= r()) {
                "Enjoy other party"
            } else {
                "Stay here"
            }
        )
    }
}

/*

*/