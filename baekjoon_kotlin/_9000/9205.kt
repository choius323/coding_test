package baekjoon_kotlin._9000

/*

9205번 - 맥주 마시면서 걸어가기
https://www.acmicpc.net/problem/9205
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색

시작 지점부터 도착할 수 있는 편의점이나 페스티벌을 확인하는 BFS를 사용한다.
각 지점은 배열이나 해시셋으로 저정한 뒤 탐색하며 각 지점에서 맥주 한 박스로 이동할 수 있는 최대 거리인 1000이 넘어가는지 확인한다.

*/

import kotlin.math.abs

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int)

    val r = { nextToken();nval.toInt() }
    repeat(r()) { _ ->
        val n = r()
        val start = Pos(r(), r())
        val conveniences = LinkedHashSet<Pos>(List(n) { Pos(r(), r()) })
        val end = Pos(r(), r())
        conveniences += end
        val queue = ArrayDeque<Pos>(listOf(start))
        while (queue.isNotEmpty()) {
            val pos = queue.removeFirst()
            for (conv in conveniences) {
                val dist = abs(pos.x - conv.x) + abs(pos.y - conv.y)
                if (dist > 1000) continue
                queue += conv
            }
            conveniences -= queue
            if (end !in conveniences) break
        }

        println(if (end !in conveniences) "happy" else "sad")
    }
}

/*

*/