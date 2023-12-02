package baekjoon_kotlin._17000

/*

17836번 - 공주님을 구해라!
https://www.acmicpc.net/problem/17836
분류 :그래프 이론, 그래프 탐색, 너비 우선 탐색

BFS로 맵을 탐색하며 목적지를 시간 안에 도착할 수 있는지 확인한다.
칼에 도착한 뒤로는 벽을 지날 수 있기 때문에 칼에 도착하기 전과 후를 따로 처리해야 한다.
여기서는 visited를 2자리 bit로 나눠서 방문 처리를 했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int, val canBreak: Boolean, val time: Int) {
        val canBreakBit = 1 shl (if (canBreak) 1 else 0)
    }

    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val t = r()
    val map = Array(n) { IntArray(m) { r() } }
    val deque = ArrayDeque(listOf(Pos(0, 0, false, 0)))
    val visited = Array(n) { IntArray(m) } // 2자리 2진수 -> 칼O/칼X
    visited[0][0] = 1
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    while (deque.isNotEmpty()) {
        val now = deque.removeFirst()
        for (d in 0..3) {
            val nx = now.x + dx[d]
            val ny = now.y + dy[d]
            if (nx !in 0 until m || ny !in 0 until n) continue
            if (now.time == t || (now.canBreak.not() && map[ny][nx] == 1)) continue
            if (visited[ny][nx] and now.canBreakBit > 0) continue
            if (nx == m - 1 && ny == n - 1) return print(now.time + 1)
            visited[ny][nx] = visited[ny][nx] or now.canBreakBit
            deque.addLast(Pos(nx, ny, now.canBreak or (map[ny][nx] == 2), now.time + 1))
        }
    }
    print("Fail")
}

/*
6 6 9
0 0 0 0 1 1
0 0 0 0 0 2
1 1 1 0 1 0
0 0 0 0 0 0
0 1 1 1 1 1
0 0 0 0 0 0

Fail
 */