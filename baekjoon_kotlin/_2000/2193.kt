/*

2193번 - 이친수
https://www.acmicpc.net/problem/2193

이번 문제도 DP와 피보나치 수열을 이용하면 된다.
피보나치인 이유는 5자리일 때 1010_과 100__으로 합으로 나타낼 수 있고, 이는 10_(3자리)과 10__(4자리)의 합과 같다.
따라서 f(n)=f(n-1)+f(n-2)가 된다.

*/

package baekjoon_kotlin._2000

fun main() {
    val n = readLine()!!.toInt()
    var a = (1).toBigInteger()
    var b = a
    repeat(n - 2) {
        a = b.also { b += a }
    }
    println(b)

}