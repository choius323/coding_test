package baekjoon_kotlin._16000

/*

16938번 - 캠프 준비
https://www.acmicpc.net/problem/16938
분류 : 브루트포스 알고리즘, 비트마스킹, 백트래킹

2개 이상의 문제를 고르는 모든 부분집합을 만들면서 각 집합이 조건을 만족하는지 확인한다.

*/

fun main() {
    val (n, l, r, x) = readln().split(" ").map { it.toInt() }
    val diffArray = readln().split(" ").map { it.toInt() }.sorted()
    var count = 0

    fun combi(left: Int?, right: Int, nextIdx: Int, sum: Int) {
        if (sum in l..r && left != null  && left != right && diffArray[right] - diffArray[left] >= x) {
            count++
        }
        for (idx in nextIdx until n) {
            combi(left ?: idx, idx, idx + 1, sum + diffArray[idx])
        }
    }
    combi(null, 0, 0, 0)
    print(count)
}

/*

*/