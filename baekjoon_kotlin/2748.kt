/*

2748번 - 피보나치 수
https://www.acmicpc.net/problem/2748

DP 문제에 약한 거 같아서 다시 공부할 겸 풀었다.
이미 나온 결과를 저장해서 나중에 다시 쓸 수 있다.

*/

package baekjoon_kotlin

fun main() {
    val fib = arrayOf(0, 1) + Array(readLine()!!.toInt() - 1){0}
    for (i in 2 until fib.size) {
        fib[i] = fib[i - 1] + fib[i - 2]
    }
    println(fib.last())
}