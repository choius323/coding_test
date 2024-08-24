package baekjoon_kotlin._16000

/*

16569번 - 화산쇄설류
https://www.acmicpc.net/problem/16569
분류 : 구현, 그래프 이론, 그래프 탐색, 너비 우선 탐색

매 시간 화산쇄설류로 뒤덮인 곳과 학자가 이동할 수 있는 곳을 계산한다.
덮이는 곳은 각 화산에서 델타 거리를 계산한 뒤 이동할 수 없는 곳으로 변경한다.
덮인 곳은 visited 배열의 값을 null로 변경해서 저장했다.
학자의 이동은 일반적인 BFS를 사용했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    open class Pos(open val x: Int, open val y: Int)
    data class Volcano(override val x: Int, override val y: Int, val time: Int) : Pos(x, y)

    val r = { nextToken();nval.toInt() }
    val m = r() // 행
    val n = r() // 열
    val v = r() // 화산 수
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val startPos = Pos(r() - 1, r() - 1)
    val heights = Array(m) { IntArray(n) { r() } }
    val visited = Array(m) { Array<Int?>(n) { Int.MAX_VALUE } }
    val volcanoes = Array(v) {
        Volcano(r() - 1, r() - 1, r()).apply {
            visited[x][y] = null
        }
    }
    val queue = ArrayDeque<Pos>(listOf(startPos))
    visited[startPos.x][startPos.y] = 0

    fun inRange(x: Int, y: Int) = x in 0 until m && y in 0 until n

    fun bomb(x: Int, y: Int) {
        if (inRange(x, y)) {
            visited[x][y] = null
        }
    }

    fun bomb(time: Int) {
        for (volcano in volcanoes) {
            val delta = time - volcano.time
            if (delta < 1) continue
            for (x in 0..delta) {
                val y = delta - x
                bomb(volcano.x + x, volcano.y + y)
                bomb(volcano.x + x, volcano.y - y)
                bomb(volcano.x - x, volcano.y + y)
                bomb(volcano.x - x, volcano.y - y)
            }
        }
    }

    var nowTime = 0
    var maxHeight = heights[startPos.x][startPos.y]
    var maxTime = 0
    while (queue.isNotEmpty()) {
        nowTime++
        bomb(nowTime)
        repeat(queue.size) {
            val pos = queue.removeFirst()
            for (d in 0..3) {
                val nx = pos.x + dx[d]
                val ny = pos.y + dy[d]
                if (inRange(nx, ny).not() || (visited[nx][ny] ?: 0) != Int.MAX_VALUE) continue
                visited[nx][ny] = nowTime
                queue += Pos(nx, ny)
                if (maxHeight < heights[nx][ny]) {
                    maxHeight = heights[nx][ny]
                    maxTime = nowTime
                }
            }
        }
    }
    print("$maxHeight $maxTime")
}

/*

*/