package baekjoon_kotlin._18000/*

18110번 - solved.ac
https://www.acmicpc.net/problem/18110
분류 : 수학, 구현, 정렬

점수 n개를 입력 받은 뒤 정렬해서 앞뒤 각각 n개를 제외한 합을 구한다.
그 후에 남은 수 만큼 나눠서 출력한다.

*/

import kotlin.math.roundToInt

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    if (n == 0) return print(0)
    val prev = (.15 * n).roundToInt()
    val sum = IntArray(n) { r() }.sorted().subList(prev, n - prev).sum()
    print((sum.toDouble() / (n - prev * 2)).roundToInt())
}

/*

*/