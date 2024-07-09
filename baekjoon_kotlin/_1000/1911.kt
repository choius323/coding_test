package baekjoon_kotlin._1000

/*

1911번 - 흙길 보수하기
https://www.acmicpc.net/problem/1911
분류 : 그리디 알고리즘, 정렬, 스위핑

널빤지를 자를 수 없고 웅덩이가 겹치지 않는다.
따라서 앞에 있는 웅덩이의 처음에 널빤지를 놓는 방법이 가장 적은 널빤지를 사용하게 된다.
단, 이전에 놓은 널빤지와 겹치면 그 이후부터 놓아야 한다.
시작 지점을 기준으로 놓기 때문에 웅덩이의 좌표에 따라 미리 정렬해야 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pool(val start: Int, val end: Int)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val l = r()
    val pools = Array(n) { Pool(r(), r()) }.sortedBy { it.start }
    var count = 0
    var coveredEnd = 0
    for (pool in pools) {
        if (pool.end > coveredEnd) {
            val length = pool.end - maxOf(pool.start, coveredEnd)
            val add = length / l + (if (length % l != 0) 1 else 0)
            count += add
            coveredEnd = maxOf(pool.start, coveredEnd) + add * l
        }
    }
    println(count)
}

/*
4 8
0 2
2 3
5 6
6 8
*/