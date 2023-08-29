package baekjoon_kotlin._15000

/*

15683번 - 감시
https://www.acmicpc.net/problem/15683

다양한 예외 상황을 염두하고 시뮬레이션을 구현해야 한다.
n과 m이 작고 cctv 개수도 적기 때문에 모든 상황을 직접 확인하며 개수를 계산했다.
rooms에는 벽, CCTV, 빈 공간을 먼저 저장한 뒤 CCTV의 감시 지역을 확인할 때마다 -1을 해준다.
CCTV는 모든 조합을 확인하며 종류에 따라 방향을 전환한 뒤 감시 지역을 확인한다.
조합을 완성하면 미리 계산해 둔 빈 공간과 CCTV가 감시하게 된 지역을 사용해 사각지대를 계산한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val rooms = Array(n) { IntArray(m) { r() } }
    val countBlank = rooms.sumOf { ints -> ints.count { it == 0 } }
    val countCCTV = rooms.sumOf { ints -> ints.count { it in 1..5 } }
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    // 직선 방향으로 감시할 수 있는 모든 곳을 확인
    fun change(x: Int, y: Int, d: Int, change: Int): Int {
        var count = 0
        var nx = x + dx[d]
        var ny = y + dy[d]
        while (nx in 0 until m && ny in 0 until n && rooms[ny][nx] != 6) {
            if (rooms[ny][nx] !in 1..5) {
                if (rooms[ny][nx] == 0) count++
                rooms[ny][nx] += change
            }
            nx += dx[d]
            ny += dy[d]
        }
        return count
    }

    // CCTV 종류에 따라 4방향 중 일부를 지정하여 확인
    fun see(x: Int, y: Int, d: Int, type: Int, change: Int): Int {
        var count = 0
        val range = when (type) {
            1 -> 0..0
            2 -> 0..2 step 2
            3 -> 0..1
            4 -> 0..2
            5 -> 0..3
            else -> throw Exception("CCTV type error")
        }
        for (i in range) count += change(x, y, (d + i) % 4, change)
        return count
    }

    var answer = n * m
    fun combi(x: Int, y: Int, count: Int, checkedCCTV: Int) {
        if (checkedCCTV == countCCTV) {
            answer = minOf(answer, countBlank - count)
            return
        }
        for (ny in y until n) for (nx in 0 until m) {
            if (nx in 0..x && ny == y) continue
            if (rooms[ny][nx] in 1..5) {
                repeat(4) {
                    val countChanged = see(nx, ny, it, rooms[ny][nx], -1)
                    combi(nx, ny, count + countChanged, checkedCCTV + 1)
                    see(nx, ny, it, rooms[ny][nx], 1)
                }
            }
        }
    }

    combi(-1, 0, 0, 0)
    print(answer)
}


/*

*/