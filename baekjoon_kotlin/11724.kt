/*

11724번 - 연결 요소의 개수
https://www.acmicpc.net/problem/11724

연결 요소는 그래프 상에서 정점들이 이어져 있을 때, 그 집합을 하나의 연결 요소라고 한다.
아무 간선이 없는 단일 정점도 연결 요소이다.
보통은 간선으로 이어진 경우만 생각해서 단일 정점의 경우를 고려하지 못했다.
정점을 2차원 배열로 그렸을 때, 해당 행이 모두 0이면 간선이 없는 정점이다.

*/

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var answer = 0
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(n) }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() - 1 }
        graph[a][b] = 1
        graph[b][a] = 1
    }

    val deque = ArrayDeque<Int>()
    var countZero = 0
    for (y in 0 until n) for (x in 0 until n) {
        if (graph[y][x] == 1) {
            deque.add(x)
            graph[y][x] = answer + 2
        } else if (graph[y][x] == 0) {
            countZero += 1
        }
        if (x == n - 1) {
            if (deque.isNotEmpty()) {
                while (deque.isNotEmpty()) {
                    val a = deque.removeFirst()
                    for (newX in 0 until n) {
                        if (graph[a][newX] == 1) {
                            graph[a][newX] = answer + 2
                            deque.add(newX)
                        }
                    }
                }
                answer += 1
            } else if (countZero == n) {
                answer += 1
            }
            countZero = 0
        }
    }
    println(answer)
}
/*
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3

1


6 5
1 2
2 5
5 1
3 4
4 6

2


8 2
1 2
3 4
6
 */