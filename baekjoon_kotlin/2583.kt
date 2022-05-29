/*

2583번 - 영역 구하기
https://www.acmicpc.net/problem/2583

종이를 2차원 Boolean 배열로 선언한 뒤 직사각형 부분을 True로 바꾼다.
그 후 BFS로 False인 부분을 체크하며 크키를 구하고 확인한 곳은 True로 바꾼다.
마지막으로 구한 크기를 정렬한 뒤 출력한다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    data class Pos(val x: Int, val y: Int)

    val m = i()
    val n = i()
    val paper = Array(m) { BooleanArray(n) }
    repeat(i()) {
        val x1 = i()
        val y1 = i()
        val x2 = i()
        val y2 = i()
        for (x in x1 until x2) for (y in y1 until y2)
            paper[y][x] = true
    }

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun bfs(sx: Int, sy: Int): Int {
        var size = 1
        val queue = ArrayDeque<Pos>()
        paper[sy][sx] = true
        queue.add(Pos(sx, sy))
        while (queue.isNotEmpty()) {
            val (x, y) = queue.removeFirst()
            for (di in 0..3) {
                val nx = x + dx[di]
                val ny = y + dy[di]
                if (nx in 0 until n && ny in 0 until m && !paper[ny][nx]) {
                    paper[ny][nx] = true
                    size += 1
                    queue.add(Pos(nx, ny))
                }
            }
        }
        return size
    }

    val answer = ArrayList<Int>()
    for (x in 0 until n) for (y in 0 until m) {
        if (!paper[y][x]) answer.add(bfs(x, y))
    }

    val sb = StringBuilder()
    sb.appendLine(answer.size)
    answer.sorted().forEach() { sb.append("$it ") }
    print(sb)
}

/*

*/