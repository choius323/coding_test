/*

2407번 - 조합
https://www.acmicpc.net/problem/2407

n이 커지면 재귀함수의 스택이 너무 커질 수 있기 때문에 반복문으로 작성하는게 좋다.

*/

package baekjoon_kotlin

import java.math.BigInteger

fun main() = (System.`in`.bufferedReader()).run {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    fun fact(a: Int): BigInteger {
        var num = BigInteger.ONE
        repeat(a) {
            num *= (it + 1).toBigInteger()
        }
        return num
    }
    println(fact(n) / fact(n - m) / fact(m))
}

/*

*/