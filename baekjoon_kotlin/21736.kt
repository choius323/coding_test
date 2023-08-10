/*

21736번 - 헌내기는 친구가 필요해
https://www.acmicpc.net/problem/21736
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

평범한 그래프 탐색 문제이며 BFS 탐색을 통해 도연이를 시작으로 만날 수 있는 사람의 수를 셌다.

*/

fun main() = System.`in`.bufferedReader().run {
    data class Pos(val x: Int, val y: Int)

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val queue = ArrayDeque<Pos>()
    val map = Array(n) { readLine().toCharArray() }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    for (y in 0 until n) for (x in 0 until m) if (map[y][x] == 'I') {
        queue.add(Pos(x, y))
        map[y][x] = 'X'
    }
    var count = 0
    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()
        for (d in 0..3) {
            val nx = x + dx[d]
            val ny = y + dy[d]
            if (nx in 0 until m && ny in 0 until n && (map[ny][nx] == 'O' || map[ny][nx] == 'P')) {
                queue.add(Pos(nx, ny))
                if (map[ny][nx] == 'P') count++
                map[ny][nx] = 'X'
            }
        }
    }
    print(count.takeIf { it > 0 } ?: "TT")
}


/*

*/