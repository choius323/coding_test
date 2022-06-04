/*

11052번 - 카드 구매하기
https://www.acmicpc.net/problem/11052

DP를 활용하는 문제이다.
dp[d]가 카드를 d개 뽑을 때 최대 가격이라고 하면, dp[1]~dp[d]에 부족한 카드를 채운 가격의 최대값이 dp[d]가 된다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val price = intArrayOf(0) + IntArray(n) { i() }
    val dp = IntArray(n + 1)

    for (d in 1..n)
        for (i in 0..d)
            dp[d] = maxOf(dp[d], price[d - i] + dp[i])
    print(dp[n])
}

/*
4
2 5 6 7
*/