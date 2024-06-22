package baekjoon_kotlin._22000

/*

22116번 - 창영이와 퇴근
https://www.acmicpc.net/problem/22116
분류 : 그래프 이론, 그래프 탐색, 이분 탐색, 데이크스트라, 최단 경로

각 칸에 이동하며 지나온 최대 경사를 비교하는 방식으로 그래프 탐색을 했다.
탐색은 최대 경사가 가장 낮게 나왔던 위치부터 탐색을 시작하는 우선순위 큐를 사용했다.

각 칸 사이의 높이를 간선으로 생각하고 (1,1)->(n,n)으로 연결된 그래프를 만드는 MST(크루스칼) 알고리즘을 사용해도 풀 수 있다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int, val minDiff: Int)

    val r = { nextToken();nval.toInt() }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val n = r()
    val heights = Array(n) { IntArray(n) { r() } }
    val minDiffs = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    minDiffs[0][0] = 0
    val pq = java.util.PriorityQueue<Pos>(compareBy(Pos::minDiff))
    pq += Pos(0, 0, 0)
    while (pq.isNotEmpty()) {
        val pos = pq.poll()
        if (minDiffs[pos.y][pos.x] < pos.minDiff) continue
        for (d in 0..3) {
            val nx = pos.x + dx[d]
            val ny = pos.y + dy[d]
            if (nx in 0 until n && ny in 0 until n) {
                val nDiff = maxOf(pos.minDiff, kotlin.math.abs(heights[pos.y][pos.x] - heights[ny][nx]))
                if (minDiffs[ny][nx] > nDiff) {
                    pq += Pos(nx, ny, nDiff)
                    minDiffs[ny][nx] = nDiff
                }
            }
        }
    }
    print(minDiffs[n - 1][n - 1])
}

/*

*/