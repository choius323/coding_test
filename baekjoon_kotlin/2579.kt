/*

2579번 - 계단 오르기
https://www.acmicpc.net/problem/2579

DP(Dynamic Programing)을 사용했다.
처음에는 DFS를 사용했지만 시간 초과가 발생했고, 가장 높은 것들만 골라서 더해 보기도 했지만 원하는 답이 나오지 않았다.
그리고 DP에 대한 지식이 부족한 것 같아서 다른 문제 통해 공부하고 다시 풀었다.

점화식은 dp[i] = scores[i] + max(dp[i - 3] + scores[i - 1], dp[i - 2])이다.
i번째 계단을 가는 방법은 i-3,i-1,i 혹은 i-2,i 순서이다.
전자는 i-3까지 점수와 i-1,i를 더하면 되고 이후에는 다음 칸을 밟지 못하고, 후자는 i-2까지 점수와 i를 더하면 된다.
여기서 중요한 점은 i-1을 dp가 아닌 해당 칸의 점수만 사용한다는 점이다.
그러면 3칸 연속으로 밟게 되는 경우를 따로 처리하지 않아도 되기 때문이다.

*/

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val scores = IntArray(n) { br.readLine().toInt() }
    val dp = IntArray(n)
    dp[0] = scores[0]
    if (n > 1) dp[1] = scores[0] + scores[1]
    if (n > 2) dp[2] = scores[2] + max(scores[0], scores[1])

    for (i in 3 until n) {
        dp[i] = scores[i] + max(dp[i - 3] + scores[i - 1], dp[i - 2])
    }
    print(dp.last())
}

//lateinit var upToDownScore: IntArray
//lateinit var floor: IntArray
//var maxScore = 0
//var n = 0
//
//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    n = br.readLine().toInt() + 1
//    floor = intArrayOf(0) + IntArray(n - 1) { br.readLine().toInt() }  // 시작지점 index : 0
//    upToDownScore = intArrayOf(0) + IntArray(n - 1)
//    upToDownScore[n - 1] = floor[n - 1]
//    for (i in n - 2 downTo 1) {
//        upToDownScore[i] = upToDownScore[i + 1] + floor[i]
//    }
//
//    dfs(0, 0, 0)
//
//    println(maxScore)
//}
//
//private fun dfs(score: Int, f: Int, lastJump: Int) {
//    if (f == n - 1) {
//        maxScore = score
//    }
//    for (jump in 1..2) {
//        if (f + jump < n && score + upToDownScore[f + jump] > maxScore) {
//            if (jump != 1 || lastJump != 1 || f <= 2) {
//                dfs(score + floor[f + jump], f + jump, jump)
//            }
//        }
//    }
//}

/*
6
10
20
15
25
10
20

75


4
1
2
3
4

8


5
1
2
3
4
5

12
 */