/*

11659번 - 구간 합 구하기 4
https://www.acmicpc.net/problem/11659

1~n까지 합을 미리 계산해놓고 원하는 구간의 값을 출력하면 된다.
sum(0..n)-sum(0..m-1)=sum(m-1..n)

*/

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val num = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val sum = IntArray(n)
    sum[0] = num[0]
    for (i in 1 until n) {
        sum[i] = num[i] + sum[i - 1]
    }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        sb.appendLine(sum[b - 1] - (sum.getOrNull(a-2)?:0))
    }
    println(sb)
}

/*
5 5
5 4 3 2 1
1 3
2 4
5 5
1 1
1 5

12
9
1
5
15


1 1
1
1 1

1
 */