/*

2468번 - 안전 영역
https://www.acmicpc.net/problem/2468

비의 양(1~100)에 따라 완전 탐색을 하며 지역의 개수를 찾으면 된다.
지역의 높이를 Set에 저장했다가 그 값의 경우만 탐색해도 되지만 숫자가 작아서 그럴 필요는 없다.

*/

package baekjoon_kotlin._2000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val range = 0 until n
    val array = Array(n) { IntArray(n) { i() } }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val visited = Array(n) { BooleanArray(n) }
    fun dfs(h: Int, x: Int, y: Int) {
        visited[y][x] = true
        for (di in 0..3) {
            val nx = x + dx[di]
            val ny = y + dy[di]
            if (nx in range && ny in range && !visited[ny][nx] && array[ny][nx] > h)
                dfs(h, nx, ny)
        }
    }

    var answer = 1
    for (r in 1..100) {
        visited.forEach { it.fill(false) }
        var count = 0
        for (y in range) for (x in range) {
            if (array[y][x] > r && !visited[y][x]) {
                dfs(r, x, y)
                count += 1
            }
        }
        answer = maxOf(count, answer)
    }
    print(answer)
}

/*

*/