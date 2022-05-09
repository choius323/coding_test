/*

1002번 - 터렛
https://www.acmicpc.net/problem/1002

부동 소수점을 잘 기억하자.

참고 링크:
https://www.acmicpc.net/board/view/85530
https://www.acmicpc.net/board/view/38854

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun pow(n: Int) = n * n
    val sb = StringBuilder()
    nextToken()
    repeat(nval.toInt()) {
        val t = Array(2) { IntArray(3) { nextToken();nval.toInt() } }
        val d = pow(t[0][0] - t[1][0]) + pow(t[0][1] - t[1][1])
        val s = pow(t[0][2] + t[1][2])
        val m = pow(kotlin.math.abs(t[0][2] - t[1][2]))
        sb.appendLine(if (d == 0 && m == 0) -1 else if (d == m || d == s) 1 else if (d in m..s) 2 else 0)
    }
    print(sb)
}

/*
12
3 3 5 0 0 3
0 0 3 0 3 3
1 1 5 1 2 5
0 0 3 0 7 4
0 0 1 0 2 3
-500 0 700 0 1200 600
-493 -2347 4676 -2338 1653 9081
0 0 4 0 1 2
0 0 1 0 0 2
0 0 5 9 0 3
0 0 3 0 3 7
1 2 3 1 2 3

2
2
2
1
1
1
1
0
0
0
0
-1


1
1 0 1 3 0 3
*/