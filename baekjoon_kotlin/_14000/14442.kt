package baekjoon_kotlin._14000

/*

14442번 - 벽 부수고 이동하기 2
https://www.acmicpc.net/problem/14442
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색

visited를 Int 배열로 생성하고 해당 칸에 이동할 때 부쉈던 벽의 수를 저장한다.
그리고 BFS로 탐색하며 이동하려는 곳이 더 많이 부순 상태로 이동했다면 이동하며 부순 횟수를 저장한다.

*/

fun main() = System.`in`.bufferedReader().run {
    data class Pos(val x: Int, val y: Int, val breakCount: Int)
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine() }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val visited = Array(n) { IntArray(m) { k + 1 } } // 부순 횟수
    val deque = ArrayDeque<Pos>()
    deque += Pos(0, 0, 0)
    visited[0][0] = 0

    var count = 0
    while (deque.isNotEmpty()) {
        count++
        repeat(deque.size) {
            val pos = deque.removeFirst()
            if (pos.x == m - 1 && pos.y == n - 1) {
                print(count)
                return@run
            }
            for (d in 0..3) {
                val nx = pos.x + dx[d]
                val ny = pos.y + dy[d]
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue
                val nk = pos.breakCount + (if (map[ny][nx] == '0') 0 else 1)
                if (nk <= k && visited[ny][nx] > nk) {
                    visited[ny][nx] = nk
                    deque.add(Pos(nx, ny, nk))
                }
            }
        }
    }
    print(-1)
}
