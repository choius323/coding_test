package baekjoon_kotlin._1000/*

1113번 - 수영장 만들기
https://www.acmicpc.net/problem/1113
분류 : 구현그래프 이론, 그래프 탐색, 시뮬레이션, 너비 우선 탐색

BFS로 물이 낮은 곳 부터 탐색하며 물을 채울 수 있는지 확인하며 채운 값을 더한다.
채울 수 있다면 BFS로 탐색했던 곳의 물 높이를 탐색하며 있었던 가장 높은 곳까지 채운다.
canFill 변수를 두고 탐색 중간에 바깥으로 나갔거나 더 낮은 물을 만났는지 확인하며 채울 수 있는지 저장한다.
더 낮은 높이의 물은 결국 바깥으로 흐르기 때문에 채울 수 없다.

*/

fun main() {
    data class Pos(val x: Int, val y: Int)

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val (n, m) = readln().split(" ").map(String::toInt)
    val pool = Array(n) { readln().toCharArray().map(Char::digitToInt).toIntArray() }
    val visited = Array(n) { BooleanArray(m) }
    var sum = 0
    for (h in 1..9) for (y in 0 until n) for (x in 0 until m) {
        if (pool[y][x] != h || visited[y][x]) continue
        val queue = mutableListOf(Pos(x, y))
        visited[y][x] = true
        var i = 0
        var min = 10
        var canFill = true //바깥으로 나가거나 더 낮은 물을 만나는지 확인
        while (i < queue.size) {
            val now = queue[i]
            for (d in 0..3) {
                val nx = now.x + dx[d]
                val ny = now.y + dy[d]
                if (nx !in 0 until m || ny !in 0 until n) {
                    canFill = false
                    continue
                }
                val height = pool[ny][nx]
                when (pool[y][x].compareTo(pool[ny][nx])) {
                    -1 -> min = minOf(min, height)
                    1 -> canFill = false
                    0 -> {
                        if (visited[ny][nx]) continue
                        queue.add(Pos(nx, ny))
                        visited[ny][nx] = true
                    }
                }
            }
            i++
        }
        if (canFill && min != 10) {
            sum += (min - pool[y][x]) * queue.size
            for (pos in queue) {
                pool[pos.y][pos.x] = min
                visited[pos.y][pos.x] = false
            }
        }
    }
    print(sum)
}

/*
9 8
99999999
98888889
98777789
98555589
98713789
98733789
98777789
98888889
99999999

9 13
1111111111111
1555555555551
1511111111151
1511199911151
1511192911151
1511199911151
1511111111151
1555555515551
1511111111151

*/