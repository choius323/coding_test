/*

11576번 - Base Conversion
https://www.acmicpc.net/problem/11576

A진법->10진법->B진법 순으로 바꾸면 된다.
10진법으로 바꿀 때는 a^(자리수-1) * 숫자를 전부 더하면 된다.
B진법으로 바꿀 때는 10진법 숫자를 b로 나누면서 나온 나머지를 역순으로 출력하면 된다.

*/

package baekjoon_kotlin

import kotlin.math.pow

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val a = i().toDouble()
    val b = i()
    val m = i()
    var num = 0

    for (p in m - 1 downTo 0) {
        num += a.pow(p).toInt() * i()
    }

    val answer = ArrayList<Int>()
    val sb = StringBuilder()
    while (num > 0) {
        answer.add(num % b)
        num /= b
    }

    for (i in answer.size -1 downTo 0) sb.append("${answer[i]} ")
    print(sb)
}

/*

*/