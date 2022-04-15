/*

16236번 - 아기 상어
https://www.acmicpc.net/problem/16236

우선 상어가 먹이를 찾는 방법은 BFS를 이용했다.
상어는 같은 거리일 때 위, 왼쪽이 우선이 되지만 그렇다고 해서 방향우선으로 탐색 후 바로 종료하면 안 된다.
그렇게 되면 좌 2번이 우상 1번씩 이동한 것 보다 먼저 탐색하게 돼서 원하는 값이 나오지 않는다.

이번 처럼 같은 형태의 데이터를 많이 사용하게 될 때는 클래스를 만들어서 저장하는 것도 좋은 방법이다.

*/

package baekjoon_kotlin

import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun input(): Int {
        nextToken(); return nval.toInt()
    }

    val n = input()
    val sea = Array(n) { IntArray(n) }
    var shark = 0 to 0
    var sharkSize = 2
    var eatCount = 0
    for (y in 0 until n) for (x in 0 until n) {
        val num = input()
        if (num == 9) shark = x to y
        else sea[y][x] = num
    }

    // 상, 좌, 우, 하
    val dx = intArrayOf(0, -1, 1, 0)
    val dy = intArrayOf(-1, 0, 0, 1)
    val queue = ArrayDeque<Pair<Int, Int>>()

    fun eatFish() {
        while (queue.isNotEmpty()) {
            val (x, y) = queue.removeFirst()
            if (sea[y][x] in 1 until sharkSize && (y < shark.second || (y == shark.second && x < shark.first))) {
                shark = x to y
            }
        }
        sea[shark.second][shark.first] = 0
        eatCount += 1
        if (eatCount == sharkSize) {
            sharkSize += 1
            eatCount = 0
        }
    }

    fun findFish(): Int {
        var sec = 0
        val visited = Array(n) { BooleanArray(n) }
        val nextQueue = ArrayDeque<Pair<Int, Int>>()
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val (x, y) = queue.removeFirst()
                if (sea[y][x] in 1 until sharkSize) {
                    shark = x to y
                    eatFish()
                    return sec
                }
                for (dir in 0..3) {
                    val nx = x + dx[dir]
                    val ny = y + dy[dir]
                    if (nx in 0 until n && ny in 0 until n
                        && sea[ny][nx] <= sharkSize && !visited[ny][nx]
                    ) {
                        nextQueue.add(nx to ny)
                        visited[ny][nx] = true
                    }
                }
            }
            sec += 1
            queue.addAll(nextQueue)
            nextQueue.clear()
        }
        return 0
    }


    var sec = 0
    do {
        queue.add(shark)
        val returnValue = findFish()
        sec += returnValue
    } while (returnValue != 0)
    print(sec)
}
/*
6
5 4 3 2 3 4
4 3 2 3 4 5
3 2 9 5 6 6
2 1 2 3 4 5
3 2 1 6 5 4
6 6 6 6 6 6

60

6
1 2 1 1 1 1
1 3 6 2 2 3
1 2 5 2 2 3
3 3 2 4 6 3
0 0 0 0 0 6
0 0 0 1 1 9
*/