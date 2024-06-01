package baekjoon_kotlin._1000

/*

1245번 - 농장 관리
https://www.acmicpc.net/problem/1245
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

모든 칸에서 인접한 칸 모두를 확인하며 높이를 비교한다.
더 높은 봉우리가 있다면 봉우리가 아니고, 같은 높이가 있다면 큐에 넣어서 다음 탐색을 계속한다.
더 높은 봉우리를 찾았더라도, 탐색을 중간에 종료하지 않고 모두 탐색해서 같은 구간을 여러번 탐색하지 않도록 했다.

봉우리가 되는지 확인할 때 ㅁ처럼 둘러 쌓인 게 아닌, ㄷ처럼 서로 붙지 않아도 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int)

    val dx = intArrayOf(-1, 1, 0, 0, -1, 1, 1, -1)
    val dy = intArrayOf(0, 0, -1, 1, -1, -1, 1, 1)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val heights = Array(n) { IntArray(m) { r() } }
    val checked = Array(n) { BooleanArray(m) }
    var answer = 0

    fun checkPeak(startX: Int, startY: Int): Boolean {
        var isPeak = true
        val deque = ArrayDeque<Pos>()
        checked[startY][startX] = true
        deque += Pos(startX, startY)
        while (deque.isNotEmpty()) {
            val pos = deque.removeFirst()
            for (d in 0..7) {
                val nx = pos.x + dx[d]
                val ny = pos.y + dy[d]
                if (nx !in 0 until m || ny !in 0 until n) continue
                when (heights[ny][nx] compareTo heights[pos.y][pos.x]) {
                    1 -> isPeak = false
                    0 -> if (checked[ny][nx].not()) {
                        deque += Pos(nx, ny)
                        checked[ny][nx] = true
                    }
                }
            }
        }
        return isPeak
    }

    for (y in 0 until n) for (x in 0 until m) {
        if (checked[y][x].not() && checkPeak(x, y)) {
            answer++
        }
    }
    print(answer)
}

/*

*/