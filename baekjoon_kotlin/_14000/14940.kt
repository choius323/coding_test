package baekjoon_kotlin._14000

/*

14940번 - 쉬운 최단거리
https://www.acmicpc.net/problem/14940
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색

한 지점 A에서 목표 지점까지의 거리는 목표 지점에서 A까지의 거리와 같다.
따라서 목표 지점에서 BFS를 시작해서 다른 모든 지점까지의 거리를 저장해둔 뒤 출력한다.
편의를 위해 빈 공간을 -1, 목표 지점을 0으로 바꾸고 시작했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val queue = ArrayDeque<Pos>()
    val map = Array(n) { y ->
        IntArray(m) { x ->
            when (r()) {
                0 -> 0
                1 -> -1
                else -> {
                    queue.add(Pos(x, y))
                    0
                }
            }
        }
    }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()
        for (d in 0..3) {
            val nx = x + dx[d]
            val ny = y + dy[d]
            if (nx in 0 until m && ny in 0 until n && map[ny][nx] == -1) {
                queue.add(Pos(nx, ny))
                map[ny][nx] = map[y][x] + 1
            }
        }
    }
    val sb = StringBuilder()
    for (y in 0 until n) {
        for (x in 0 until m) {
            sb.append("${map[y][x]} ")
        }
        sb.appendLine()
    }
    print(sb)
}

/*

*/