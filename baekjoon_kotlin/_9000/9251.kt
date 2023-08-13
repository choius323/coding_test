/*

9251번 - LCS
https://www.acmicpc.net/problem/9251

LCS(Longest Common Subsequence, 최장 공통 부분 수열)을 활용하는 가장 기본적인 문제이다.
같은 문자일 때 dp[y][x] = dp[y-1][x-1] + 1이고 다르면 max(dp[y-1][x], dp[y][x-1]이다.

*/

package baekjoon_kotlin._9000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    nextToken()
    val str1 = sval
    nextToken()
    val str2 = sval
    val n = str1.length
    val m = str2.length
    val dp = Array(m + 1) { IntArray(n + 1) }

    for (y in 1..m) for (x in 1..n)
        dp[y][x] = if (str1[x - 1] == str2[y - 1]) dp[y - 1][x - 1] + 1
        else maxOf(dp[y][x - 1], dp[y - 1][x])

    print(dp[m][n])
}

/*
ACAYKP
CAPCAK

4



AA
A

1
*/