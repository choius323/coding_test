/*

11055번 - 가장 큰 증가하는 부분 수열
https://www.acmicpc.net/problem/11055
분류 : 다이나믹 프로그래밍

DP를 사용해 2중 for문에서 증가하는 부분 수열을 찾고, 그 수열이 증가하는 경우 DP의 값을 갱신했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val nums = IntArray(n) { r() }
    val dp = IntArray(n) { nums[it] }
    var answer = nums[0]
    repeat(n) { a ->
        repeat(a) { b ->
            if (nums[a] > nums[b]) {
                dp[a] = maxOf(dp[a], dp[b] + nums[a])
                if (answer < dp[a]) answer = dp[a]
            }
        }
    }
    print(answer)
}

/*

*/