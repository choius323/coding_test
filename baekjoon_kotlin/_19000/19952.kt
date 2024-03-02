package baekjoon_kotlin._19000

/*

19952번 - 인성 문제 있어??
https://www.acmicpc.net/problem/19952
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색

BFS로 목적지에 도착할 수 있는지 확인한다.
큐에 이동했을 때 남은 힘을 저장해서 추가로 이동할 수 있는지 확인한다.

힘은 이동할 때마다 1만 줄어들고, 더 높은 곳으로 이동해도 추가로 줄어들지 않는다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int, val f: Int)

    val r = { nextToken();nval.toInt() }
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    repeat(r()) { _ ->
        val h = r()
        val w = r()
        val o = r()
        val f = r()
        val start = Pos(r() - 1, r() - 1, f)
        val end = Pos(r() - 1, r() - 1, 0)
        val visited = Array(h) { IntArray(w) { -1 } }
        val obstacles = Array(h) { IntArray(w) }
        repeat(o) { _ ->
            val x = r() - 1
            val y = r() - 1
            obstacles[x][y] = r()
        }

        val deque = ArrayDeque<Pos>()
        deque += start
        visited[start.x][start.y] = start.f

        while (deque.isNotEmpty()) {
            val pos = deque.removeFirst()
            for (d in 0..3) {
                val nx = pos.x + dx[d]
                val ny = pos.y + dy[d]
                if (nx !in 0 until h || ny !in 0 until w) continue

                val nf = pos.f - 1
                if (nf <= visited[nx][ny] || nf < 0 || pos.f < obstacles[nx][ny] - obstacles[pos.x][pos.y]) continue

                visited[nx][ny] = nf
                deque += Pos(nx, ny, nf)
            }
            if (visited[end.x][end.y] >= 0) {
                println("잘했어!!")
                return@repeat
            }
        }
        println("인성 문제있어??")
    }
}