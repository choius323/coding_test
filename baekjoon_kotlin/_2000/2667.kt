/*

2667번 - 단지번호붙이기
https://www.acmicpc.net/problem/2667

전체 배열을 확인하면서 1인 곳을 시작으로 BFS을 했다.
방문했던 곳은 1이 아닌 다른 값으로 바꿔주면 되고 그러면 중복 없이 탐색을 종료할 수 있다.

*/

package baekjoon_kotlin._2000

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val house = Array(n) { br.readLine().toList().map { it.digitToInt() }.toIntArray() }
    val estate = ArrayList<Int>()

    val dy = intArrayOf(-1, 1, 0, 0)
    val dx = intArrayOf(0, 0, -1, 1)
    val deque = ArrayDeque<IntArray>()

    for (y in 0 until n) for (x in 0 until n) {
        if (house[y][x] == 1) {
            // BFS 시작 부분
            estate.add(1)
            deque.add(intArrayOf(x, y))
            house[y][x] = estate.size + 1
            while (deque.isNotEmpty()) {
                val visit = deque.removeFirst()
                repeat(4) {
                    val newX = visit[0] + dx[it]
                    val newY = visit[1] + dy[it]
                    if (newX in 0 until n && newY in 0 until n && house[newY][newX] == 1) {
                        deque.add(intArrayOf(newX, newY))
                        house[newY][newX] = estate.size + 1
                        estate[estate.lastIndex] += 1
                    }
                }
            }
        }
    }

    println(estate.size)
    estate.sorted().forEach { println(it) }
}
/*
5
11001
10101
10001
10001
11111

2
1
14
 */