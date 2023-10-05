package baekjoon_kotlin._17000

/*

17070번 - 파이프 옮기기
https://www.acmicpc.net/problem/17070
분류 : 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색

각 파이프의 모양이 도착할 수 있는 경우의 수를 값으로 갖는 3차원 dp 배열을 사용했다.
모든 칸을 확인하며 다음 위치에 이동할 수 있는 파이프 경우의 수를 모두 더했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val house = Array(n) { IntArray(n) { r() } }
    val dp = Array(n) { Array(n) { IntArray(3) } }
    val range = 0 until n
    dp[0][1][0] = 1

    fun move(x: Int, y: Int) {
        if (house[y][x] == 1) return
        // 파이프 가로 이동
        var nx = x + 1
        var ny = y
        if (nx in range && ny in range && house[ny][nx] == 0) {
            dp[ny][nx][0] += dp[y][x][0] + dp[y][x][1]
        }

        // 파이프 대각선 이동
        nx = x + 1
        ny = y + 1
        if (nx in range && ny in range && house[ny][nx] == 0 && house[y][nx] == 0 && house[ny][x] == 0) {
            dp[ny][nx][1] += dp[y][x][0] + dp[y][x][1] + dp[y][x][2]
        }

        // 파이프 세로 이동
        nx = x
        ny = y + 1
        if (nx in range && ny in range && house[ny][nx] == 0) {
            dp[ny][nx][2] += dp[y][x][1] + dp[y][x][2]
        }
    }

    for (i in range) {
        for (y in 0 until i) {
            move(i, y)
        }
        for (x in 0..i) {
            move(x, i)
        }
    }

    print(dp[n - 1][n - 1].sum())
}


/*
6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 1 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 1 0 0 0 0

10


6
0 0 0 0 0 0
0 0 0 0 1 0
0 0 0 1 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 1 0 0 0 0

3



*/