package baekjoon_kotlin._11000

/*

11722번 - 가장 긴 감소하는 부분 수열
https://www.acmicpc.net/problem/11722
분류 : 다이나믹 프로그래밍

dp[i]는 i번째까지의 `가장 긴 감소하는 부분 수열`의 길이를 저장한다.
그 뒤에 배열의 모든 값을 확인하며 dp[i]를 갱신한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val nums = IntArray(n) { r() }
    val dp = IntArray(n) { 1 }
    var answer = 1
    repeat(n) { a ->
        repeat(a) { b ->
            if (nums[a] < nums[b]) {
                dp[a] = maxOf(dp[a], dp[b] + 1)
                answer = maxOf(answer, dp[a])
            }
        }
    }
    print(answer)
}

/*

*/