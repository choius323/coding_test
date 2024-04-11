package baekjoon_kotlin._20000

/*

20165번 - 인내의 도미노 장인 호석
https://www.acmicpc.net/problem/20165
분류 : 구현, 시뮬레이션

각 칸의 도미노 높이와 현재 상태를 저장하는 배열을 만든다.
그 후 공격과 수비를 번갈아가며 수행한다.
공격할 때는 넘어지는 도미노를 모두 큐에 넣으며 길이가 닿는 곳 큐에 다시 넣는다.
큐에서 뺄 때는 중복이 생기지 않도록 도미노의 상태에 따라 분기 처리를 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int)

    operator fun Array<IntArray>.get(pos: Pos) = getOrNull(pos.x)?.getOrNull(pos.y) ?: -1
    operator fun Array<BooleanArray>.get(pos: Pos) = getOrNull(pos.x)?.getOrNull(pos.y) ?: false
    operator fun Array<BooleanArray>.set(pos: Pos, value: Boolean) = getOrNull(pos.x)?.set(pos.y, value)

    val i = { nextToken();nval.toInt() }
    val c = { nextToken();sval.first() }

    val n = i()
    val m = i()
    val r = i()

    val heights = Array(n) { IntArray(m) { i() } }
    val states = Array(n) { BooleanArray(m) { true } }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val dChars = "NSWE"
    val queue = ArrayDeque<Pos>()
    var score = 0

    repeat(r) { _ ->
        queue += Pos(i() - 1, i() - 1)
        val d = dChars.indexOf(c())
        while (queue.isNotEmpty()) {
            val pos = queue.removeFirst()
            if (states[pos].not()) continue
            score += 1
            states[pos] = false
            for (dist in 1 until heights[pos]) {
                queue += Pos(pos.x + dx[d] * dist, pos.y + dy[d] * dist)
            }
        }
        states[i() - 1][i() - 1] = true
    }

    println(score)
    print(states.joinToString("\n") { it.joinToString(" ") { bool -> if (bool) "S" else "F" } })
}

/*

*/