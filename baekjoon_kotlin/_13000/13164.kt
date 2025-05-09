package baekjoon_kotlin._13000

/*

13164번 - 행복 유치원
https://www.acmicpc.net/problem/13164
분류 : 그리디 알고리즘, 정렬

서로 인접한 원생끼리 조를 만들 수 있으므로, 인접한 원생끼리의 키 차이가 가장 많이 나는 지점을 (k - 1)개 찾는다.
그 지점을 모두 구하면 직전 지점과 현재 지점을 조로 만들어서 해당 조의 비용을 계산한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Diff(val index: Int, val value: Int)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val k = r()
    val heights = IntArray(n) { r() }
    val maxDiffs = Array(n - 1) { Diff(it, heights[it + 1] - heights[it]) }
        .sortedByDescending(Diff::value).take(k - 1).sortedBy(Diff::index)
    var lastIndex = -1
    var sum = 0
    for (diff in maxDiffs) {
        sum += heights[diff.index] - heights[lastIndex + 1]
        lastIndex = diff.index
    }
    sum += heights.last() - heights[lastIndex + 1]
    print(sum)
}

/*
5 3
1 3 5 6 10

3


3 3
1 2 3

0

9 4
1 2 3 5 7 12 15 16 17

6

1 2 3 / 5 7 / 12 / 15 16 17
2 + 2 + 0 + 2 = 6
*/