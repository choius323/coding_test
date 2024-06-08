package baekjoon_kotlin._2000

/*

2140번 - 지뢰찾기
https://www.acmicpc.net/problem/2140
분류 : 구현, 그리디 알고리즘

순차적으로 보드를 탐색하며 #에 폭탄을 놓는다.
#일 때 주변에 0이 있으면 놓을 수 없고, 놓을 때는 주변에 있는 숫자를 1씩 감소 시켜야 한다.

바깥쪽에 있는 칸만 숫자가 있기 때문에 붙어있는 #만 세도 된다.

*/

fun main() {
    data class Pos(val x: Int, val y: Int)

    val dx = intArrayOf(-1, 1, 0, 0, -1, 1, 1, -1)
    val dy = intArrayOf(0, 0, -1, 1, -1, -1, 1, 1)
    val n = readln().toInt()
    val board = Array(n) { readln().toCharArray() }
    var count = 0

    fun Pos.around(lambda: (Pos) -> Unit) {
        for (d in 0..7) {
            val nPos = Pos(x + dx[d], y + dy[d])
            if (x !in 0 until n || y !in 0 until n) continue
            lambda(nPos)
        }
    }

    for (y in 0 until n) for (x in 0 until n) {
        if (board[y][x] != '#') continue
        var foundZero = false
        val pos = Pos(x, y)
        pos.around { nPos ->
            if (board[nPos.y][nPos.x] == '0') {
                foundZero = true
            }
        }
        if (foundZero) continue
        pos.around { nPos ->
            val char = board[nPos.y][nPos.x]
            if (char in '1'..'9') {
                board[nPos.y][nPos.x] = char - 1
            }
        }
        board[pos.y][pos.x] = '.'
        count++
    }

    print(count)
}

/*

*/