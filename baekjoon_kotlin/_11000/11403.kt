/*

11403번 - 경로 찾기
https://www.acmicpc.net/problem/11403

플로이드 와샬 알고리즘을 사용하면 된다.
보통은 거리를 확인하지만 이 문제에서는 연결 여부만 확인하면 되기 때문에 [a][b]와 [b][a]가 1인지만 확인하면 된다.

*/

package baekjoon_kotlin._11000

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    for (b in 0 until n) {
        for (a in 0 until n) {
            for (c in 0 until n) {
                graph[a][c] = if (graph[a][b]==1 && graph[b][c] == 1) 1 else graph[a][c]
            }
        }
    }
    graph.forEach { sb.appendLine(it.joinToString(" ")) }
    print(sb)
}

//import kotlin.math.min

//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val sb = StringBuilder()
//
//    val n = br.readLine().toInt()
//    val graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
//    graph.forEachIndexed { index, it ->
//        it.forEachIndexed { index2, it2 ->
//            if (it2 == 0) it[index2] = 1_00_00_00_0
//        }
//    }
//    println(graph.contentDeepToString())
//    for (b in 0 until n) {
//        for (a in 0 until n) {
//            for (c in 0 until n) {
//                graph[a][c] = min(graph[a][c], graph[a][b] + graph[b][c])
//            }
//        }
//    }
//    println(graph.contentDeepToString())
//}