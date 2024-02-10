package baekjoon_kotlin._1000

/*

1261번 - 알고스팟
https://www.acmicpc.net/problem/1261
분류 : 그래프 이론, 그래프 탐색, 데이크스트라, 최단 경로, 0-1 너비 우선 탐색

BFS로 4방 탐색을 진행하며 목적지까지 이동하는 최단 경로를 탐색한다.
단, 벽을 개수 제한 없이 없앨 수 있고 최소 횟수를 찾아야 하기 때문에, 횟수의 오름차순을 기준으로 하는 우선순위 큐로 탐색 순서를 정한다.

*/

fun main() {
    data class Pos(val x: Int, val y: Int, val broke: Int)

    val (m, n) = readln().split(" ").map(String::toInt)
    val rooms = Array(n) { readln() } // 1-벽,0-빈방
    val minBroke = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    val pq = java.util.PriorityQueue<Pos> { p1, p2 -> p1.broke compareTo p2.broke }

    pq += Pos(0, 0, 0)
    minBroke[0][0] = 0
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)
    while (pq.isNotEmpty() && minBroke.last().last() == Int.MAX_VALUE) {
        val now = pq.remove()
        for (d in dx.indices) {
            val nx = now.x + dx[d]
            val ny = now.y + dy[d]
            if (nx !in 0 until m || ny !in 0 until n) continue
            val nBroke = now.broke + (if (rooms[ny][nx] == '1') 1 else 0)
            if (minBroke[ny][nx] <= nBroke) continue
            pq.add(Pos(nx, ny, nBroke))
            minBroke[ny][nx] = nBroke
        }
    }
    print(minBroke.last().last())
}