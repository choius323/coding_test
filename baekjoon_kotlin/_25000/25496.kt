package baekjoon_kotlin._25000/*

25496번 - 장신구 명장 임스
https://www.acmicpc.net/problem/25496

가장 적은 피로도인 장신구 순으로 제작하는 그리디 알고리즘 문제이다.
모든 장신구를 입력받고 피로도 순으로 정렬하여 피로도가 200이상이 될 때 까지 제작하고 그 개수를 확인한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    var p = r()
    val n = r()
    var count = 0
    for (it in List(n) { r() }.sorted()) {
        if (p > 199) break
        p += it
        count++
    }
    print(count)
}

/*
190 5
20 1 8 1 10

1 1
200
*/