/*

11660번 - 구간 합 구하기 5
https://www.acmicpc.net/problem/11660

DP를 활용해서 합을 미리 계산하고 원하는 부분만 출력하면 된다.

*/

package baekjoon_kotlin._11000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Int, val y: Int)

    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val m = i()
    val arr = Array(n + 1) { IntArray(n + 1) }

    fun getValue(pos1: Pos, pos2: Pos = pos1) =
        arr[pos2.x][pos2.y] - arr[pos2.x][pos1.y - 1] - arr[pos1.x - 1][pos2.y] + arr[pos1.x - 1][pos1.y - 1]
    for (x in 1..n) {
        for (y in 1..n) {
            arr[x][y] = i() - getValue(Pos(x, y))
        }
    }
    val sb = StringBuilder()
    repeat(m) {
        sb.appendLine(getValue(Pos(i(), i()), Pos(i(), i())))
    }
    print(sb)
}

/*
4 7
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7

2 2 3 4
3 4 3 4
1 1 4 4
2 2 3 2
2 2 2 3
4 1 4 1
1 4 1 4



3 6
1 2 3
4 5 6
7 8 9

1 1 1 1
3 3 3 3
1 1 3 3
1 2 2 3
1 3 1 3
3 2 3 2


2 4
1 2
3 4
1 1 1 1
1 2 1 2
2 1 2 1
2 2 2 2

*/