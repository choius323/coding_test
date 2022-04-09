/*

5430번 - AC
https://www.acmicpc.net/problem/5430



*/

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    repeat(br.readLine().toInt()) {
        val input = br.readLine().toCharArray()
        val n = br.readLine().toInt()
        val num = ArrayDeque<Int>()
        num.addAll(br.readLine().split("[", ",", "]").filter { it.isNotEmpty() }.map { it.toInt() })
        var isLeft = true
        var isError = false
        for (i in input) {
            if (i == 'D') {
                if (num.size < 1) {
                    sb.appendLine("error")
                    isError = true
                    break
                }
                if (isLeft) num.removeFirst() else num.removeLast()
            } else {
                isLeft = !isLeft
            }
        }

        if (!isLeft) num.reverse()
        if (!isError) sb.appendLine(num.toString().replace(" ", ""))
    }
    println(sb)
}