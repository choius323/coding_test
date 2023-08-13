package baekjoon_kotlin._2000/*

2495번 - 연속구간
https://www.acmicpc.net/problem/2495

이전 글자와 연속 구간을 매번 갱신하며 입력 문자열을 전부 확인한다.
그 중 가장 긴 구간을 저장했다가 출력한다.

*/

fun main() = repeat(3) {
    var c = ' '
    var ans = 1
    var len = 1
    for (r in readln())
        if (r == c) ans = maxOf(ans, ++len)
        else {
            len = 1
            c = r
        }
    println(ans)
}

/*

*/