package baekjoon_kotlin._14000

/*

14719번 - 빗물
https://www.acmicpc.net/problem/14719
분류 : 구현, 시뮬레이션

각 블럭의 왼쪽과 오른쪽 각각 가장 높은 블럭의 높이를 구한다.
구한 높이에서 현재 블럭의 높이를 빼면 해당 블럭에 차는 높이의 물이 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Column(val height: Int, var leftMax: Int, var rightMax: Int)

    val r = { nextToken();nval.toInt() }
    val h = r()
    val w = r()
    val columns = Array(w) { Column(r(), 0, 0) }

    var max = 0
    for (column in columns) {
        column.leftMax = max
        max = maxOf(column.height, max)
    }
    max = 0
    for (column in columns.reversed()) {
        column.rightMax = max
        max = maxOf(column.height, max)
    }

    print(columns.sumOf { maxOf(0, minOf(it.leftMax, it.rightMax) - it.height) })
}

/*

*/