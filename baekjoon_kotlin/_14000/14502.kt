package baekjoon_kotlin._14000

/*

14502번 - 연구소
https://www.acmicpc.net/problem/14502
분류 : 구현, 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 너비 우선 탐색

n, m이 8이하이기 때문에 조합을 사용해 모든 경우의 수를 확인해도 시간 초과가 발생하지 않는다.
벽을 3개 세울 수 있는 모든 조합을 모두 구하고, 각각의 경우에 바이러스가 얼마나 퍼졌는지 DFS로 확인했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val room = Array(n) { IntArray(m) { r() } }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    var answer = 0

    fun dfs(temp: Array<IntArray>, x: Int, y: Int) {
        for (d in 0..3) {
            val nx = x + dx[d]
            val ny = y + dy[d]
            if (nx in 0 until m && ny in 0 until n && temp[ny][nx] == 0) {
                temp[ny][nx] = 2
                dfs(temp, nx, ny)
            }
        }
    }

    fun countSafe() {
        val temp = room.map { it.copyOf() }.toTypedArray()
        for (y in 0 until n) for (x in 0 until m) {
            if (temp[y][x] == 2) {
                dfs(temp, x, y)
            }
        }
        answer = maxOf(answer, temp.sumOf { row -> row.count { it == 0 } })
    }

    fun combi(count: Int, startX: Int, startY: Int) {
        if (count == 3) return countSafe()
        for (y in startY until n) for (x in 0 until m) {
            if ((startY == y && startX > x) || room[y][x] != 0) continue
            room[y][x] = 1
            combi(count + 1, x + 1, y)
            room[y][x] = 0
        }
    }
    combi(0, 0, 0)
    print(answer)
}

/*

*/