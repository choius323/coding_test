/*

7576번 - 토마토
https://www.acmicpc.net/problem/7576
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색

BFS로 그래프를 탐색하며 토마토가 모두 익는 날짜를 계산했다.
처음에 전체 배열을 확인하며 익지 않은 토마토의 개수를 저장하고, 익은 토마토를 큐에 넣었다.
그 후에 BFS로 큐에 있는 곳을 탐색하며 익지 않은 토마토를 바꾸었다.
BFS를 돌 때 큐의 크기만큼만 돌면 날짜를 구하기 쉽다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int)

    val r = { nextToken();nval.toInt() }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val m = r()
    val n = r()
    var count = 0
    val queue = ArrayDeque<Pos>()
    val storage = Array(n) { y ->
        BooleanArray(m) { x ->
            when (r()) {
                -1 -> true
                1 -> queue.add(Pos(x, y))
                else -> {
                    count++
                    false
                }
            }
        }
    }
    var day = 0
    while (queue.isNotEmpty()) {
        if (count == 0) return print(day)
        repeat(queue.size) {
            val (x, y) = queue.removeFirst()
            for (d in 0..3) {
                val nx = x + dx[d]
                val ny = y + dy[d]
                if (nx !in 0 until m || ny !in 0 until n || storage[ny][nx]) continue
                storage[ny][nx] = true
                queue.add(Pos(nx, ny))
                count--
            }
        }
        day++
    }
    print(-1)
}

/*

*/