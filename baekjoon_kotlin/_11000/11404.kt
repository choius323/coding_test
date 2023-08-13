/*

11404번 - 플로이드
https://www.acmicpc.net/problem/11404

플로이드-와샬 문제의 기본 형태이다.
초기값은 최대 비용*노드 수 보다 크게 정해야 하며, 이 문제에서는 a->a로 가는 비용을 0으로 설정해야 한다.

*/

package baekjoon_kotlin._11000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val arr = Array(n) { IntArray(n) { 10000001 } }
    repeat(i()) {
        val a = i() - 1
        val b = i() - 1
        arr[a][b] = minOf(arr[a][b], i())
    }
    repeat(n) {
        arr[it][it] = 0
    }
    for (b in 0 until n) for (a in 0 until n) for (c in 0 until n) {
        arr[a][c] = minOf(arr[a][c], arr[a][b] + arr[b][c])
    }
    val sb = StringBuilder()
    arr.forEach { it.forEach { i -> sb.append("${if (i < 10000001) i else 0} ") };sb.appendLine() }
    print(sb)
}

/*
5
2
1 2 100000
2 3 100000

*/