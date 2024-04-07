package baekjoon_kotlin._2000

/*

2190번 - 점 고르기 2
https://www.acmicpc.net/problem/2190
분류 : 브루트포스 알고리즘, 기하학

.*.
*.*
.*.

이렇게 점(*)이 있으면 모든 점을 포함하기 위해선 모든 빈 공간을 꼭짓점으로 하는 직사각형이 필요하다.
따라서 모든 x,y좌표의 조합을 꼭짓점으로 하고 넓이가 a*b인 직사각형 안에 몇개의 점이 있는지 확인한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Point(val x: Long, val y: Long)

    val r = { nextToken();nval.toLong() }
    val n = r().toInt()
    val a = r()
    val b = r()
    val points = Array(n) { Point(r(), r()) }
    val xList = points.map { it.x }
    val yList = points.map { it.y }

    var answer = 0
    for (x in xList) {
        for (y in yList) {
            answer = maxOf(answer, points.count { it.x in x..x + a && it.y in y..y + b })
        }
    }
    print(answer)
}

/*

*/