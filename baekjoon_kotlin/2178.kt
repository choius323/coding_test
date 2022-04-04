/*

2178번 - 미로 탐색
https://www.acmicpc.net/problem/2178

bfs를 활용해서 풀었다. dfs로도 될것 같지만 해보진 않았다.
처음 풀이는 굉장히 많은 메모리를 사용하면서 시간도 오래 걸려서 다른 풀이를 참조했다.
상하좌우의 delta값을 미리 배열에 저장해 두면 훨씬 간다하다는 것을 알았다.
또한, 이미 지나친 곳의 값을 1씩 증가시키면서 중복 탐색도 제거하고 거리도 알 수 있다.
추가로 for 대신 repeat을 사용하려고 했는데 repeat에는 continue와 break가 없어서 for문을 사용했다.

*/

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }  // n : 세로, m : 가로
    val maze = Array(n) { br.readLine().toList().map { it.digitToInt() }.toIntArray() }

    val queue = ArrayDeque<IntArray>()
    queue.add(intArrayOf(0, 0))

//    상하좌우
    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)

    while (!queue.isEmpty() && maze[n - 1][m - 1] == 1) {
        val visit = queue.removeFirst() // [x, y]
        for (i in 0..3) {
            val nx = visit[0] + dx[i]
            val ny = visit[1] + dy[i]

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue
            } else if (maze[ny][nx] != 1) {
                continue
            } else {
                maze[ny][nx] = maze[visit[1]][visit[0]] + 1
                queue.add(intArrayOf(nx, ny))
            }
        }
    }
    println(maze[n - 1][m - 1])

//    val visited = ArrayList<List<Int>>()
//    val queue = ArrayDeque<List<Int>>()
//    val countQueue = ArrayDeque<Int>()
//    var count = 1
//    var visit = listOf(0, 0)
//    visited.add(visit)  // [x, y]
//
//    while (visit != listOf(m - 1, n - 1)) {
//        val nextVisit = ArrayList<List<Int>>()
//        if (visit[0] > 0 && maze[visit[1]][visit[0] - 1] == '1') nextVisit.add(listOf(visit[0] - 1, visit[1])) // left
//        if (visit[0] < m - 1 && maze[visit[1]][visit[0] + 1] == '1') nextVisit.add(listOf(visit[0] + 1, visit[1])) // right
//        if (visit[1] > 0 && maze[visit[1] - 1][visit[0]] == '1') nextVisit.add(listOf(visit[0], visit[1] - 1))  // top
//        if (visit[1] < n - 1 && maze[visit[1] + 1][visit[0]] == '1') nextVisit.add(listOf(visit[0], visit[1] + 1))  //bottom
//        for (nv in nextVisit) {
//            if (nv !in visited && nv !in queue) {
//                queue.add(nv)
//                countQueue.add(count + 1)
//                visited.add(nv)
//            }
//        }
//        visit = queue.removeFirst()
//        count = countQueue.removeFirst()
//    }
//
//    println(count)
}

/*
4 6
101111
101010
101011
111011

15


2 1
1
1

2
 */