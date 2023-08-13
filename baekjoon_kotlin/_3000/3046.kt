package baekjoon_kotlin._3000/*

3046번 - R2
https://www.acmicpc.net/problem/3046

(R1+R2)/2=S 이므로 R2 = -R1+2*S이다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    print(-r() + 2 * r())
}

/*

*/