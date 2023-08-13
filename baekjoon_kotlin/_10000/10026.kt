/*

10026번 - 적록색약
https://www.acmicpc.net/problem/10026

BFS나 DFS를 활용해서 탐색을 2번 하면 되며 여기선 DFS를 사용했다.
원본 데이터를 두고 visited를 2개 만들었지만, 입력받은 데이터를 깊은 복사를 통해 한개 더 만들어서 탐색해도 가능하다.

*/

package baekjoon_kotlin._10000

fun main() = (System.`in`.bufferedReader()).run {
    val n = readLine().toInt()
    val picture = Array(n) { readLine().toCharArray() }
    val no = Array(n) { BooleanArray(n) }
    val yes = Array(n) { BooleanArray(n) }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun Array<BooleanArray>.dfs(c: Char, x: Int, y: Int, type: Char) {
        repeat(4) {
            val nx = x + dx[it]
            val ny = y + dy[it]
            if (nx in 0 until n && ny in 0 until n && !this[ny][nx]) {
                if (picture[ny][nx] == c) {
                    this[ny][nx] = true
                    this.dfs(c, nx, ny, type)
                } else if (type == 'Y' && ((c == 'R' && picture[ny][nx] == 'G') ||
                            (c == 'G' && picture[ny][nx] == 'R'))
                ) {
                    this[ny][nx] = true
                    this.dfs(c, nx, ny, type)
                }
            }
        }
    }

    var countNo = 0
    var countYes = 0
    for (y in 0 until n) for (x in 0 until n) {
        if (!no[y][x]) {
            countNo += 1
            no.dfs(picture[y][x], x, y, 'N')
        }
        if (!yes[y][x]) {
            countYes += 1
            yes.dfs(picture[y][x], x, y, 'Y')
        }
    }

    print("$countNo $countYes")
}

/*

*/