package baekjoon_kotlin._15000

/*

15558번 - 점프 게임
https://www.acmicpc.net/problem/15558
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색

BFS로 이동하며 n 이상의 위치에 도달할 수 있는지 확인한다.
줄 2개로 이동할 수 있기 때문에, 방문 처리와 이동에 주의해야 한다.

*/

fun main() {
    data class Move(val num: Int, val line: Int, val time: Int)
    val (n, k) = readln().split(" ").map { it.toInt() }
    val lines = Array(2) { readln() }
    val visited = Array(2) { BooleanArray(n) }
    val deque = ArrayDeque<Move>()
    deque += Move(0, 0, 0)
    visited[0][0] = true

    fun visit(move: Move): Boolean {
        if (move.num >= n) return true
        if (move.num !in 0 until n || visited[move.line][move.num] || move.time > move.num || lines[move.line][move.num] == '0') return false
        visited[move.line][move.num] = true
        deque.add(move)
        return false
    }

    while (deque.isNotEmpty()) {
        val move = deque.removeFirst()
        if (
            visit(Move(move.num + 1, move.line, move.time + 1)) ||
            visit(Move(move.num - 1, move.line, move.time + 1)) ||
            visit(Move(move.num + k, (move.line + 1) and 1, move.time + 1))
        ) return print(1)
    }
    print(if (visited.all { it.last().not() }) 0 else 1)
}

/*

*/