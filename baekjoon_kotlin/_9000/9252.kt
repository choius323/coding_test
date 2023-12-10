package baekjoon_kotlin._9000

/*

9252번 - LCS 2
https://www.acmicpc.net/problem/9252
분류 : 다이나믹 프로그래밍

DP를 사용해 LCS를 풀면 된다.
제한 시간이 짧기 때문에 문자열을 더하는 식으로 기록하면 시간 초과가 발생한다.

*/

fun main() = System.`in`.bufferedReader().run {
    val str1 = " " + readLine()
    val str2 = " " + readLine()
    val dp = Array(str1.length) { IntArray(str2.length) }
    for (idx1 in 1..str1.lastIndex) {
        for (idx2 in 1..str2.lastIndex) {
            dp[idx1][idx2] = maxOf(
                dp[idx1 - 1][idx2],
                dp[idx1][idx2 - 1],
                dp[idx1 - 1][idx2 - 1] + (if (str1[idx1] == str2[idx2]) 1 else 0)
            )
        }
    }

    var idx1 = str1.lastIndex
    var idx2 = str2.lastIndex
    val sb = StringBuilder()
    while (idx1 > 0 && idx2 > 0) {
        if (str1[idx1] == str2[idx2]) {
            sb.append(str1[idx1])
            idx1--
            idx2--
        } else if (dp[idx1 - 1][idx2] > dp[idx1][idx2 - 1]) {
            idx1--
        } else {
            idx2--
        }
    }

    print("${dp.last().last()}\n${sb.reversed()}")
}

/*

*/