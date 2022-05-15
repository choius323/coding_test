/*

25191번 - 치킨댄스를 추는 곰곰이를 본 임스
https://www.acmicpc.net/problem/25191

답은 두 경우의 최솟값이다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken(); return nval.toInt()
    }
    print(minOf(i(), i() / 2 + i()))
}

/*

*/