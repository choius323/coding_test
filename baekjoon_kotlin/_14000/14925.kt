package baekjoon_kotlin._14000
/*

14925번 - 목장 건설하기
https://www.acmicpc.net/problem/14925

4095번(최대 정사각형) 문제와 같다.
오른쪽 아래로 탐색하며 자신의 왼쪽, 왼쪽위, 위에 있는 숫자 중 가장 작은 수에 1을 더하면, 그 칸에서 만들 수 있는 가장 큰 정사각형의 변의 길이가 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val m = r()
    val n = r()
    val land = Array(m) { IntArray(n) { if (r() == 0) 1 else 0 } }
    for (y in 1 until m) for (x in 1 until n) {
        if (land[y][x] > 0) {
            land[y][x] = minOf(land[y - 1][x - 1], land[y][x - 1], land[y - 1][x]) + 1
        }
    }
    print(land.maxOf { it.max() })
}

/*
5 3
1 0 0
0 0 0
2 0 1
1 0 0
0 0 0
*/