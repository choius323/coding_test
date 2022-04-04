/*

1260번 - DFS와 BFS
https://www.acmicpc.net/problem/1260

전에 python으로 풀다가 틀렸던 문제를 다시 kotlin에서 풀었다.
graph는 Hash 대신 배열을 n*n으로 만들어서 사용해도 된다.
foreach와 repeat을 사용하면 불필요한 코드를 많이 줄일 수 있다.

*/

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

val graph = HashMap<Int, IntArray>()
private val sb = StringBuilder()
val visited = HashMap<Int, Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a] = if (a in graph.keys) graph[a]!!.plus(intArrayOf(b)) else intArrayOf(b)
        graph[b] = if (b in graph.keys) graph[b]!!.plus(intArrayOf(a)) else intArrayOf(a)
    }
    graph.forEach { it.value.sort() }
    if (v in graph.keys) {
        basicDfs(v)

        sb.append("\n")

        visited.clear()
        basicBfs(v)
    } else {
        sb.append("$v\n$v")
    }
    println(sb)
}

fun basicDfs(nextVisit: Int) {
    visited[nextVisit] = 0
    sb.append("$nextVisit ")
    if (visited.size == graph.keys.size) {
        return
    } else {
        graph[nextVisit]!!.forEach {
            if (it !in visited.keys) {
                basicDfs(it)
            }
        }
    }
}

fun basicBfs(v: Int) {
    val queue = ArrayDeque<Int>()
    queue.add(v)
    visited[v] = 0
    sb.append("$v ")
    while (visited.size < graph.keys.size) {
        graph[queue.removeFirst()]!!.forEach {
            if (it !in visited.keys) {
                visited[it] = 0
                sb.append("$it ")
                queue.add(it)
            }
        }
    }
}