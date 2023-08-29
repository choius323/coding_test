package baekjoon_kotlin._28000

/*

28136번 - 원, 탁!
https://www.acmicpc.net/problem/28136
분류 : 구현, 그리디 알고리즘

모든 숫자를 입력받으며 이전 숫자가 다음 숫자보다 작거나 같으면 count를 1 증가시킨다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val first = r()
    var now = first
    var count = 0
    repeat(n - 1) {
        val next = r()
        if (now >= next) count++
        now = next
    }
    if (now >= first) count++
    print(count)
}

/*

*/