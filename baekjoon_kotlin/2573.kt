/*

2573번 - 빙산
https://www.acmicpc.net/problem/2573

매년 빙산의 높이를 갱신하며 덩어리가 여러개인지 확인한다.
높이를 갱신할 때 얼음을 저장하고, 덩어리를 확인할 때는 한 얼음에서 BFS로 탐색 하며 탐색한 얼음의 개수와 저장해둔 얼음의 개수를 비교해서 개수가 맞는지 비교한다.
빙산의 높이를 갱신할 때는 같은 위치의 얼음을 2번이상 동시에 갱신하지 않도록 주의한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int)

    val r = { nextToken();nval.toInt() }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val n = r()
    val m = r()
    val ice = hashSetOf<Pos>()
    var sea = Array(n) { y -> IntArray(m) { x -> r().also { ice += Pos(x, y) } } }
    var answer = 0
    while (true) {
        answer++
        // 빙산의 높이를 갱신
        val newSea = Array(n) { y -> IntArray(m) { x -> sea[y][x] } }
        for (y in 0 until n) for (x in 0 until m) {
            for (d in 0..3) {
                val nx = x + dx[d]
                val ny = y + dy[d]
                if (ny in 0 until n && nx in 0 until m && sea[ny][nx] == 0 && newSea[y][x] > 0) {
                    newSea[y][x]--
                }
            }
            if (newSea[y][x] == 0) {
                ice -= Pos(x, y)
            }
        }

        //bfs로 빙산 개수를 확인
        val visited = Array(n) { BooleanArray(m) }
        val queue = ArrayDeque<Pos>()
        ice.firstOrNull()?.let { start ->
            queue.add(start)
            visited[start.y][start.x] = true
        }
        var count = 1
        while (queue.isNotEmpty()) {
            val now = queue.removeFirst()
            for (d in 0..3) {
                val ny = now.y + dy[d]
                val nx = now.x + dx[d]
                if (ny in 0 until n && nx in 0 until m && visited[ny][nx].not() && newSea[ny][nx] > 0) {
                    queue.add(Pos(nx, ny))
                    visited[ny][nx] = true
                    count++
                }
            }
        }
        if (ice.isEmpty()) { // 남은 얼음이 없다면
            answer = 0
            break
        } else if (count != ice.size) { // 빙산 덩어리가 2개라면
            break
        }
        sea = newSea
    }
    print(answer)
}


/*

*/