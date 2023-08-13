/*

1654번 - 랜선 자르기
https://www.acmicpc.net/problem/1654

이분탐색을 활용했다.
while문 조건은 left<=right, 출력은 right
Int의 범위는 2^31-1 까지이므로 BigInteger를 사용하지 않아도 된다.. 범위는 기억해두자.

 */

package baekjoon_kotlin._1000

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (k, n) = br.readLine().split(" ").map { it.toInt() }
    val line = Array(k) { br.readLine().toBigInteger() }
    var left = (1).toBigInteger()
    var right = line.maxOrNull()!!
    var mid = right
    while (left <= right) {
        var sum = (0).toBigInteger()
        line.forEach { sum += it / mid }
        if (sum >= n.toBigInteger()) {
            left = mid + (1).toBigInteger()
        } else {
            right = mid - (1).toBigInteger()
        }
        mid = (right + left) / (2).toBigInteger()
//        println("$left $right")
    }
    print(right)
}
