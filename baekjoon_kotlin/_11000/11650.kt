package baekjoon_kotlin._11000

/*

11650번 - 좌표 정렬하기
https://www.acmicpc.net/problem/11650

sortedWith는 Comparator 객체를 파라미터로 받는다.
compareBy는 비교할 방법을 지정할 수 있으며, 앞에 전달하는 함수의 우선 순위가 더 높다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    print(List(r()) { r() to r() }
        .sortedWith(compareBy({ it.first }, { it.second }))
        .joinToString("\n") { "${it.first} ${it.second}" })
}

/*

*/