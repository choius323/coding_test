/*

11726번 - 2xn 타일링
https://www.acmicpc.net/problem/11726

길이가 n인 블록을 채우려면 처음 오늘 블록을 세우거나 눕히면 되고 세웠을 경우 n-1일 때, 눕혔을 경우 n-2일 때와 같다.
따라서 f(n)=f(n-1)+f(n-2)가 되고 피보나치 수열과 같다.

*/

package baekjoon_kotlin

fun main() {
    val n = readLine()!!.toInt()
    var a = 1
    var b = 1
    repeat(n - 1) {
        a = (b%10_007).also { b += a }
    }
    println(b % 10_007)
}