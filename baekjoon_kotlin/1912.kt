/*

1912번 - 연속합
https://www.acmicpc.net/problem/1912

DP를 활용하는 문제이다.
i-1번째 까지의 합이 음수이면 i번째부터 합을 구하는 게 더 크기 때문에 dp[i] = max(dp[i-1]+input[i], input[i])이다.
여기서는 합의 최대값을 기억하는 변수와, 현재 합계를 기억하는

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    var sum = i()
    var answer = sum
    repeat(n - 1) {
        sum = i() + if (sum < 0) 0 else sum
        if (sum > answer) answer = sum
    }
    print(answer)
}

/*
10
10 -4 3 1 5 6 -35 12 21 -1
*/