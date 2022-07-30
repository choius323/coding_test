/*

1926번 - 그림
https://www.acmicpc.net/problem/1926

그래프를 모두 탐색하며 1인 곳에서 dfs나 bfs를 사용해서 그림의 크기를 구한다.
그림을 탐색하며 찾은 1은 모두 0으로 바꿔서 중복으로 체크하지 않게 한다.
bfs가 dfs에 비해 메모리도 적게 사용하고 속도도 훨씬 빨랐다.
대신 코드 길이는 dfs가 300자 정도 적었다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int)

    val i = { nextToken(); nval.toInt() }

    val n = i()
    val m = i()
    val picture = List(n) { IntArray(m) { i() } }

    val queue = ArrayDeque<Pos>()
    var count = 0
    var max = 0
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    fun bfs(x: Int, y: Int): Int {
        picture[y][x] = 0
        queue.add(Pos(x, y))
        var size = 1
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val q = queue.removeFirst()
                for (d in 0..3) {
                    val nx = q.x + dx[d]
                    val ny = q.y + dy[d]
                    if (nx in 0 until m && ny in 0 until n && picture[ny][nx] == 1) {
                        queue.add(Pos(nx, ny))
                        picture[ny][nx] = 0
                        size++
                    }
                }
            }
        }
        return size
    }

    fun dfs(x: Int, y: Int): Int {
        var size = 0
        if (x in 0 until m && y in 0 until n && picture[y][x] == 1) {
            size++
            picture[y][x] = 0
            for (d in 0..3)
                size += dfs(x + dx[d], y + dy[d])
        }
        return size
    }

    for (y in 0 until n) for (x in 0 until m) {
        if (picture[y][x] == 1) {
            count++
            max = maxOf(dfs(x, y), max)
        }
    }
    println("$count\n$max")
}

/*

*/