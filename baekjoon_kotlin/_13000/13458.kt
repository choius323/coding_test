package baekjoon_kotlin._13000

/*

13458번 - 시험 감독
https://www.acmicpc.net/problem/13458
분류 : 수학, 사칙연산

총감독관은 최소 n명이 필요하다.
또 a명을 감독하는 부감독관은 (a-b)/c명 이상 필요하다.
(a-b)/c가 소수일 경우 올림을 해야 한다. -> 감독관이 최소 0.2명 필요하면 1명으로 계산해야 한다.

*/

import kotlin.math.ceil

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val aArray = IntArray(n) { r() }
    val b = r()
    val c = r()
    var answer = n.toLong()
    for (a in aArray) {
        answer += ceil(maxOf(0, a - b).toDouble() / c).toLong()
    }
    print(answer)
}

/*
5
9 10 11 12 13
7 3
*/