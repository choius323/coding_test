package baekjoon_kotlin._1000/*

1913번 - 달팽이
https://www.acmicpc.net/problem/1913
분류 : 구현

n*n부터 (0, 0)에 채우며 시계방향으로 돌며 다음 저장할 위치를 탐색한다.
값을 저장하려는 곳이 이미 채워져 있으면 방향으로 바꾼 뒤 이동한다.

*/

fun main() {
    val n = readln().toInt()
    val goal = readln().toInt()
    var answer = ""
    val array = Array(n) { IntArray(n) }
    var num = n * n
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    var x = 0
    var y = 0
    var d = 0
    while (num != 0) {
        array[y][x] = num
        if (num == goal) answer = "${y + 1} ${x + 1}"
        x += dx[d]
        y += dy[d]
        if (x !in 0 until n || y !in 0 until n || array[y][x] != 0) {
            x -= dx[d]
            y -= dy[d]
            d = (d + 1) % 4
            x += dx[d]
            y += dy[d]
        }
        num--
    }
    val sb = StringBuilder()
    for (y in 0 until n) {
        for (x in 0 until n) {
            sb.append("${array[y][x]} ")
        }
        sb.appendLine()
    }
    print("$sb$answer")
}

/*

*/