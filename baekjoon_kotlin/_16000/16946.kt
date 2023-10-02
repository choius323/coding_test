package baekjoon_kotlin._16000

/*

16946번 - 벽 부수고 이동하기 4
https://www.acmicpc.net/problem/16946
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

우선 모든 빈 공간에 이동할 수 있는 공간의 개수를 저장한다.
연결된 빈 공간에 같은 인덱스를 부여하고, 리스트의 해당 인덱스에 공간의 개수를 저장한다.
그 후에 모든 벽을 확인하며 벽과 4방향에 이동할 수 있는 공간을 찾아서 더한 뒤 출력한다.
벽 주위의 빈칸을 확인할 때는 중복되는 인덱스를 제거한 뒤 개수를 저장해둔 리스트에서 인덱스로 값을 찾는다.

*/

fun main() {
    data class Pos(val x: Int, val y: Int)

    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln() }
    val countIndex = Array(n) { IntArray(m) { -1 } }
    val counts = mutableListOf<Int>()
    val queue = ArrayDeque<Pos>()
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    for (y in 0 until n) for (x in 0 until m) {
        if (map[y][x] == '1' || countIndex[y][x] >= 0) continue
        queue.add(Pos(x, y))
        countIndex[y][x] = counts.size
        var count = 1
        while (queue.isNotEmpty()) {
            val now = queue.removeFirst()
            for (d in 0..3) {
                val nx = now.x + dx[d]
                val ny = now.y + dy[d]
                if (nx !in 0 until m || ny !in 0 until n || map[ny][nx] == '1' || countIndex[ny][nx] >= 0) continue
                queue.add(Pos(nx, ny))
                countIndex[ny][nx] = counts.size
                count++
            }
        }
        counts.add(count % 10)
    }

    val sb = StringBuilder()
    for (y in 0 until n) {
        for (x in 0 until m) {
            sb.append(
                if (map[y][x] == '0') {
                    0
                } else {
                    val indices = mutableListOf<Int>()
                    for (d in 0..3) {
                        val nx = x + dx[d]
                        val ny = y + dy[d]
                        if (nx !in 0 until m || ny !in 0 until n || map[ny][nx] == '1') continue
                        indices += countIndex[ny][nx]
                    }
                    (indices.distinct().sumOf { counts[it] } + 1) % 10
                }
            )
        }
        sb.appendLine()
    }
    print(sb)
}

/*

*/