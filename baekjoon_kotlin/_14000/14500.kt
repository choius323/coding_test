/*

14500번 - 테트로미노
https://www.acmicpc.net/problem/14500

if(value1<value2) value1 = value2를 value1.coerceAtLeast(value2)로 대채할 수 있다. value1=max(value1, value2)와 같음.
블록을 직접 만들지 않고 규칙을 찾아서 하는 것도 가능하다.

*/

package baekjoon_kotlin._14000

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val paper = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    fun ia(a: Int, b: Int, c: Int, d: Int): IntArray = intArrayOf(a, b, c, d)
    val blockX = arrayOf(
        ia(0, 1, 2, 3), ia(0, 0, 0, 0), // 1 블록
        ia(0, 1, 0, 1), // ㅁ 블록
        ia(0, 0, 0, 1), ia(0, 0, 0, -1), ia(0, -1, -2, -2), ia(0, -1, -2, -2),// ㄴ 블록
        ia(0, 0, 0, 1), ia(0, 0, 0, -1), ia(0, 1, 2, 2), ia(0, 1, 2, 2),
        ia(0, 0, 1, 1), ia(0, 0, -1, -1), ia(0, 1, 1, 2), ia(0, 1, 1, 2),// ㄱㄴ 블록
        ia(-1, 0, 1, 0), ia(0, 0, 0, -1), ia(-1, 0, 1, 0), ia(0, 0, 0, 1)// ㅗ 블록
    )
    val blockY = arrayOf(
        ia(0, 0, 0, 0), ia(0, 1, 2, 3), // 1 블록
        ia(0, 0, 1, 1), // ㅁ 블록
        ia(0, 1, 2, 2), ia(0, 1, 2, 2), ia(0, 0, 0, 1), ia(0, 0, 0, -1), // ㄴ 블록
        ia(0, -1, -2, -2), ia(0, -1, -2, -2), ia(0, 0, 0, 1), ia(0, 0, 0, -1),
        ia(0, 1, 1, 2), ia(0, 1, 1, 2), ia(0, 0, 1, 1), ia(0, 0, -1, -1), // ㄱㄴ 블록
        ia(0, 0, 0, -1), ia(-1, 0, 1, 0), ia(0, 0, 0, 1), ia(-1, 0, 1, 0) // ㅗ 블록
    )

    fun inPaper(x: Int, y: Int, i: Int): Boolean {
        blockX[i].forEach { if (it + x !in 0 until m) return false }
        blockY[i].forEach { if (it + y !in 0 until n) return false }
        return true
    }

    var max = 0
    for (y in 0 until n) for (x in 0 until m) {
        for (i in blockX.indices) {
            if (inPaper(x, y, i)) {
                var value = 0
                repeat(4) { value += paper[y + blockY[i][it]][x + blockX[i][it]] }
                if (max < value) max = value
            }
        }
    }

    print(max)


}

/*
4 4
2 1 1 3
9 2 1 1
3 1 8 5
5 1 1 4
 */