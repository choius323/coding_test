package baekjoon_kotlin._3000/*

3024번 - 마라톤 틱택토
https://www.acmicpc.net/problem/3024

n*n으로 모든 문자열을 확인하며 가로, 세로, 대각선으로 같은 글자가 3번 연속 나오는지 확인한다.
각 항목에서 오른쪽, 아래, 우측하단 대각선, 좌측하단 대각선 총 4가지 방향을 확인하면 된다.
대각선이 2가지 방향인 점을 유의해야 하고, n이 최대 30이라서 크지 않으므로 시간 안에 풀이가 가능하다.

*/

fun main() = System.`in`.bufferedReader().run {
    val n = readLine().toInt()
    val board = Array(n) { readLine() }
    for (y in 0 until n) for (x in 0 until n) {
        val c = board[y][x]
        if (c == '.') continue
        if ((y + 2 < n && c == board[y + 1][x] && c == board[y + 2][x])
            || (x + 2 < n && c == board[y][x + 1] && c == board[y][x + 2])
            || (y + 2 < n && x + 2 < n && c == board[y + 1][x + 1] && c == board[y + 2][x + 2])
            || (y + 2 < n && x - 2 >= 0 && c == board[y + 1][x - 1] && c == board[y + 2][x - 2])
        ) return print(c)
    }
    print("ongoing")
}

/*

*/