package baekjoon_kotlin._1000/*

1225번 - 이상한 곱셈
https://www.acmicpc.net/problem/1225

각 자리의 숫자를 모두 한번씩 곱한다.
10000 이하의 정수인 줄 알고 Int로 풀었다가 틀렸는데 10000 '자리'이하였다.
문제를 잘 읽고 풀자.

*/

fun main() = System.`in`.bufferedReader().run {
    var sum = 0L
    val (s, r) = readLine().split(" ")
    s.forEach { c -> r.forEach { d -> sum += c.digitToInt() * d.digitToInt() } }
    print(sum)
}

/*

*/