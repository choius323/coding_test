package baekjoon_kotlin._22000

/*

22352번 - 항체 인식
https://www.acmicpc.net/problem/22352
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

원본 데이터와 백신 이후 데이터를 비교해서 값이 다른 곳을 기준으로 탐색하며 붙어있는 지점을 모두 찾는다.
모두 탐색한 뒤 탐색 되지 않았지만 값이 다른 곳이 있는지에 따라 답을 출력한다.
백신을 놓았을 때 값이 바뀌지 않을 수 있으므로 처음부터 값이 같다면 바로 종료한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val before = Array(n) { IntArray(m) { r() } }
    val after = Array(n) { IntArray(m) { r() } }
    val queue = ArrayDeque<Pos>()

    var targetNum = 0
    var startNum = 0
    for (y in 0 until n) {
        for (x in 0 until m) {
            if (before[y][x] != after[y][x]) {
                startNum = before[y][x]
                targetNum = after[y][x]
                queue += Pos(x, y)
                before[y][x] = targetNum
                break
            }
        }
        if (targetNum != 0) break
    }
    if (targetNum == 0) return print("YES")

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    while (queue.isNotEmpty()) {
        val pos = queue.removeFirst()
        for (d in 0..3) {
            val nx = pos.x + dx[d]
            val ny = pos.y + dy[d]
            if (nx !in 0 until m || ny !in 0 until n || before[ny][nx] != startNum) continue
            queue += Pos(nx, ny)
            before[ny][nx] = targetNum
        }
    }

    for (y in 0 until n) for (x in 0 until m) {
        if (before[y][x] != after[y][x]) {
            return print("NO")
        }
    }
    print("YES")
}

/*
1 1
1
2
*/