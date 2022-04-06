/*

9461번 - 파도반 수열
https://www.acmicpc.net/problem/9461

규칙을 찾고 DP를 활용해서 풀면 된다.
항상 엣지 케이스(이번엔 1, 100)를 테스트 해보자.
이 문제는 배열에 값을 저장해 두고 100,1,100 순으로 들어와도 100을 2번 연산하지 않도록 한다.

*/

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val arr = ArrayDeque<BigInteger>()
    arr.addAll(listOf(1, 1, 1, 2, 2).map { it.toBigInteger() })
    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        if (arr.size <= n) {
            repeat(n - arr.size) {
                arr.add(arr[arr.size - 1] + arr[arr.size - 5])
            }
        }
        sb.appendLine(arr[n - 1])
    }
    println(sb)
}
