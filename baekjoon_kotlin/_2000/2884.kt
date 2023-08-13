package baekjoon_kotlin._2000/*

2884번 - 알람 시계
https://www.acmicpc.net/problem/2884

분을 45 빼고 0보다 작으면 시를 1 빼고 분을 45 더한다.
그 뒤에 시가 0보다 작다면 24를 더한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val i = { nextToken(); nval.toInt() }
    var h = i()
    var m = i() - 45
    if (m < 0) {
        h -= 1
        if (h < 0) h += 24
        m += 60
    }
    print("$h $m")
}

/*

*/