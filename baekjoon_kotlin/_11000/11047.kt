/*

11047번 - 동전 0
https://www.acmicpc.net/problem/11047

보통 이런 문제는 DP를 해결해야 한다. 100원을 모으려고 하면 90+5+5 보다 50+50이 더 적기 때문이다.
하지만 이 문제는 특이한 조건이 있다.
-> A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수
이 조건 때문에 앞서 말했던 경우가 발생하지 않게 되고, 따라서 그리디 알고리즘으로 해결할 수 있다.

*/

package baekjoon_kotlin._11000

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n, k) = br.readLine().split(" ").map { it.toInt() }
    val coin = IntArray(n){br.readLine().toInt()}
    var answer = 0
    for (c in coin.reversed()){
        answer += k / c
        k %= c
    }
    print(answer)
}