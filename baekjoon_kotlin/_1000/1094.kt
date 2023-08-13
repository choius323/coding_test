package baekjoon_kotlin._1000/*

1094번 - 막대기
https://www.acmicpc.net/problem/1094

배열을 사용해서 값을 추가하며 판별하거나, 여러 막대를 자르지 않기 때문에 변수 3개만 이용해도 된다.

*/

fun main() {
    val x = System.`in`.bufferedReader().readLine().toInt()
    var count = 1 // 막대의 개수
    var stick = 64 // 막대의 총 길이
    var last = 64 // 잘라진 막대의 길이
    while (stick > x) {
        last /= 2
        if (stick - last < x) count += 1
        else stick -= last
    }
    print(count)
}

/*

*/