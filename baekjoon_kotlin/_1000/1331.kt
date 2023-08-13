package baekjoon_kotlin._1000/*

1331번 - 나이트 투어
https://www.acmicpc.net/problem/1331

이전 지점과 현재 지점 사이의 거리가 가로=2,세로=1 이거나 가로=1,세로=2 이면 된다.
또, 모든 지점을 방문해야 하고 횟수가 딱 맞기 때문에 중복이 있으면 안 되고 마지막 지점에서 시작 지점으로 다시 올 수 있는지 확인해야 한다.

*/

import kotlin.math.abs

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Pair<Int, Int> {
        nextToken()
        return sval[0] - 'A' to sval[1] - '1'
    }

    fun canMove(p1: Pair<Int, Int>, p2: Pair<Int, Int>) =
        (abs(p1.first - p2.first) == 2 && abs(p1.second - p2.second) == 1) ||
                (abs(p1.first - p2.first) == 1 && abs(p1.second - p2.second) == 2)

    val visited = BooleanArray(36)
    val first = i()
    var last = first
    repeat(35) {
        visited[last.first * 6 + last.second] = true
        val now = i()
        if (canMove(last, now) && !visited[now.first * 6 + now.second]) last = now
        else return print("Invalid")
    }
    print(if (canMove(first, last)) "Valid" else "Invalid")
}

/*

*/