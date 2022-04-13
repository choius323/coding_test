/*

7569번 - 토마토
https://www.acmicpc.net/problem/7569

전에 풀었던 토마토(7576번)의 3차원 버전이다.
처음에 1인 위치를 큐에 넣고 시작해야 BFS이지만 1인 값을 찾을 때 BFS를 시작하게 되면서 DFS+BFS의 형태가 됐다.
그래서 다시 전체탐색을 하면서 최대값을 찾는 불필요한 작업이 생겼고, 결과적으로 시간이 많이 소요됐다.

처음에 0과 1을 확인하며 큐에 넣는 과정을 거치는 방법으로 바꿨더니 시간이 거의 반으로 줄었다.

*/

package baekjoon_kotlin

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n, h) = readLine().split(" ").map { it.toInt() }  // 가로, 세로, 높이
    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    var countZero = 0
    var day = 0
    val tomato = Array(h) { Array(n) { IntArray(m) } }

    for (z in 0 until h) for (y in 0 until n) {
        val arr = readLine().split(" ").map { it.toInt() }
        for (x in 0 until m) {
            tomato[z][y][x] = arr[x]
            if (arr[x] == 1) queue.add(Triple(x, y, z))
            else if (arr[x] == 0) countZero += 1
        }
    }

    // 동, 서, 남, 북, 위층, 아래층
    val dx = intArrayOf(1, -1, 0, 0, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1, 0, 0)
    val dz = intArrayOf(0, 0, 0, 0, 1, -1)

    while (queue.isNotEmpty()) {
        val (qx, qy, qz) = queue.removeFirst()
        for (i in 0..5) {
            val x2 = qx + dx[i]
            val y2 = qy + dy[i]
            val z2 = qz + dz[i]
            if (x2 in 0 until m && y2 in 0 until n && z2 in 0 until h
                && tomato[z2][y2][x2] == 0
            ) {
                if (tomato[z2][y2][x2] == 0) countZero -= 1
                tomato[z2][y2][x2] = tomato[qz][qy][qx] + 1
                queue.add(Triple(x2, y2, z2))
                day = tomato[z2][y2][x2] - 1
            }
        }
//        println(tomato.contentDeepToString())
    }

    print(if (countZero == 0) day else -1)
}

/*
3 3 2
1 0 1
0 0 0
1 0 0
0 0 0
0 0 0
0 0 0

3


5 5 2
1 -1 1 -1 1
0 0 -1 -1 1
0 -1 -1 1 0
0 -1 0 0 1
0 0 1 -1 1
1 -1 -1 -1 -1
0 -1 0 1 1
0 1 0 0 -1
-1 -1 -1 -1 -1
-1 0 0 1 -1

3
 */