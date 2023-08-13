/*

12685번 - 평범한 배낭
https://www.acmicpc.net/problem/12685

문제 그대로 평범하고 기초적인 0/1 배낭 문제이며 DP로 풀면 된다.
dp[n][w]에서 n이 넣은 개수, w를 무게라고 할 때, dp[n-1][w](n번째 물품 넣지 않음)와 dp[n - 1][w - w[n]] + v[n](n번째 물품 넣음) 중 더 큰 값이 된다.
dp[n-1][w]는 n-1개를 최대 w무게 만큼 넣었을 때이고, dp[n - 1][w - w[n]]는 n번째 물품을 넣기 전 무게인 w - w[n]에서 최대값이다.
따라서 그 두 개 중 더 큰 값이 dp[n][w]가 된다.

단, 2차원 배열로 만들면 크기가 n*k가 되므로 dp는 k개 만큼 1차원 배열만 사용한다.
그리고 dp[w]를 갱신할 때는 dp[0]에서 dp[w] 사이의 값만 참조하기 때문에 k->0 순으로 dp를 갱신하면 배열을 하나 더 만들지 않아도 된다.

*/

package baekjoon_kotlin._12000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val k = i()
    val goods = Array(n) { intArrayOf(i(), i()) } // 무게, 가치
    val dp = IntArray(k + 1)
    goods.forEach {
        for (weight in k downTo 0) {
            if (it[0] <= weight) {
//                val nv = dp[weight - it[0]] + it[1]
//                if (dp[weight] < nv) dp[weight] = nv
                dp[weight] = maxOf(dp[weight], dp[weight - it[0]] + it[1])
            }
        }
    }
    print(dp.last())
}

/*
4 7
2 1
1 3
3 8
5 6


*/