package baekjoon_kotlin._14000

/*

14002번 - 가장 긴 증가하는 부분 수열 4
https://www.acmicpc.net/problem/14002
분류 : 다이나믹 프로그래밍

11053번-가장 긴 증가하는 부분 수열을 우선 구한다.
그 뒤에 가장 긴 수열부터 하나씩 리스트에 저장하며 수열의 이전 숫자를 찾는다.
마지막에 리스트를 반전시킨 뒤 출력한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val nums = IntArray(n) { r() }
    val dp = IntArray(n) { 1 }
    var max = 1
    repeat(n) { a ->
        repeat(a) {
            if (dp[a] <= dp[it] && nums[a] > nums[it])
                dp[a] = dp[it] + 1
        }
        if (max < dp[a]) {
            max = dp[a]
        }
    }
    val list = mutableListOf<Int>()
    println(max)
    var maxNum = 1001
    for (i in n - 1 downTo 0) {
        if (max == dp[i] && nums[i] < maxNum) {
            list += (nums[i])
            maxNum = nums[i]
            max--
        }
    }
    print(list.reversed().joinToString(" "))
}

/*

*/