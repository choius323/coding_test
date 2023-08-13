/*

4963번 - 섬의 개수
https://www.acmicpc.net/problem/4963

BFS를 활용해서 탐색을 진행하면 된다.
대각선 이동이 가능하고 visited배열을 따로 만들 필요가 없다는 것이 특징이다.

*/

package baekjoon_kotlin._4000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int)

    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val dx = intArrayOf(-1, 1, 0, 0, -1, 1, 1, -1)
    val dy = intArrayOf(0, 0, -1, 1, -1, -1, 1, 1)
    val queue = ArrayDeque<Pos>()
    val sb = StringBuilder()

    while (true) {
        val w = i()
        val h = i()
        if (w == 0 && h == 0) break
        val map = Array(h) { BooleanArray(w) { i() == 1 } }
        var count = 0
        for (y in 0 until h) for (x in 0 until w) {
            if (map[y][x]) {
                queue.add(Pos(x, y))
                map[y][x] = false
                count += 1
                while (queue.isNotEmpty()) {
                    val pos = queue.removeFirst()
                    repeat(8) {
                        val nx = pos.x + dx[it]
                        val ny = pos.y + dy[it]
                        if (nx in 0 until w && ny in 0 until h && map[ny][nx]) {
                            queue.add(Pos(nx, ny))
                            map[ny][nx] = false
                        }
                    }
                }
            }
        }
        sb.appendLine(count)
    }
    print(sb)
}

/*

*/