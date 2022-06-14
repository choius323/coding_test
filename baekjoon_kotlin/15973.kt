/*

15973번 - 두 박스
https://www.acmicpc.net/problem/15973

2527번과 같은 문제이다.
https://www.acmicpc.net/problem/2527

*/

package baekjoon_kotlin

private data class Rect(val x1: Int, val y1: Int, val x2: Int, val y2: Int)

fun main() = print(java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val r1 = Rect(i(), i(), i(), i())
    val r2 = Rect(i(), i(), i(), i())
    when {
        r1.x1 > r2.x2 || r1.x2 < r2.x1 || r1.y1 > r2.y2 || r1.y2 < r2.y1 -> "NULL"
        (r1.x1 == r2.x2 || r1.x2 == r2.x1) && (r1.y1 == r2.y2 || r1.y2 == r2.y1) -> "POINT"
        r1.x1 == r2.x2 || r1.x2 == r2.x1 || r1.y1 == r2.y2 || r1.y2 == r2.y1 -> "LINE"
        else -> "FACE"
    }
})

/*

*/