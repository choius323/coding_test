/*

2775번 - 부녀회장이 될테야
https://www.acmicpc.net/problem/2775

반복문은 until, .., step, downto 등등을 잘 활용하자.
Array는 val로 선언해도 각 배열의 내용은 바꿀 수 있다.

 */
package baekjoon_kotlin._2000

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    for (i in 0 until scanner.nextInt()) {
        val k = scanner.nextInt()
        val n = scanner.nextInt()
        val sum = Array(n + 1) { it }
        for (a in 1 until k+1) {
            var value = 0
            for (b in 1 until n + 1) {
                value += sum[b]
                sum[b] = value
            }
        }
        println(sum[n])
    }

}