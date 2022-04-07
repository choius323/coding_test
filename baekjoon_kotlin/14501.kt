/*

14501번 - 퇴사
https://www.acmicpc.net/problem/14501

DP를 활용한 문제이다.
매번 피보나치만 봐서 다른 유형을 보고 싶었는데 잘 찾은 것 같다.
Ti가 5이면 그 날을 포함해 5일이 걸린다.
work 배열은 따로 만들지 않아도 될 거 같다.

참고 링크:
https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-14501-%ED%87%B4%EC%82%AC-exjyfr5vgj

*/

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val work = Array(n + 1) { intArrayOf(0, 0) }
    for (i in 1..n) {
        work[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val dp = IntArray(n + 2)
    var maxDp = 0
    for (i in 1..n) {
        dp[i] = max(dp[i - 1], dp[i])  // 전날까지 최대값 비교
        if (i + work[i][0] - 1 <= n) {  // 퇴사 전에 끝나는지 확인
            // 일이 끝나는 날에 일을 할 경우 받는 돈의 최대값을 비교한다.
            dp[i + work[i][0]] = max(dp[i + work[i][0]], dp[i] + work[i][1])
        }
        maxDp = max(maxDp, dp[i])
    }
    println(dp.maxOf { it } )
}

/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

45


10
5 50
4 40
3 30
2 20
1 10
1 10
2 20
3 30
4 40
5 50

10
5 80
4 70
3 60
2 50
1 40
1 30
2 20
3 30
4 0
5 0

 */