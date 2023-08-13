/*

6064번 - 카잉 달력
https://www.acmicpc.net/problem/6064



*/

package baekjoon_kotlin._6000

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    repeat(br.readLine().toInt()) {
        var (m, n, x, y) = br.readLine().split(" ").map { it.toInt() }
        if (m > n) {
            m = n.also { n = m }
            x = y.also { y = x }
        }
        var day = x
        val bool = BooleanArray(n + 1)
        bool[day] = true
        var count = 0
        while (true) {
            if (day == y) {
                println(count * m + x)
                break
            } else {
                bool[day] = true
            }
            day = (day + m - 1) % n + 1
            count += 1
            if (bool[day]) {
                println(-1)
                break
            }
        }
    }
}

/*
7
10 12 3 9
10 12 7 2
13 11 5 6
15 5 1 1
5 1 3 1
1 6 1 5
10 12 10 12

33
-1
83
1
3
5
60
 */