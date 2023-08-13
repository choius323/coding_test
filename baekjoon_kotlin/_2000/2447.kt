package baekjoon_kotlin._2000

/*

2447번 - 별 찍기 - 10
https://www.acmicpc.net/problem/2447
분류 : 분할 정복, 재귀

분할 정복으로 가로 세로를 1/3씩 나누며 별을 채운다.
재귀로 탐색할 때 가운데를 제외하고 탐색해야 한다.

*/

fun main() {
    val n = readln().toInt()
    val array = Array(n) { CharArray(n) { ' ' } }
    fun draw(l: Int, t: Int, d: Int) {
        if (d == 0) {
            array[t][l] = '*'
            return
        }
        for (y in 0 until 3) for (x in 0 until 3) {
            if (y == 1 && x == 1) continue
            draw(l + d * x, t + d * y, d / 3)
        }
    }
    draw(0, 0, n / 3)
    print(array.joinToString("\n") { it.joinToString("") })
}

/*

*/