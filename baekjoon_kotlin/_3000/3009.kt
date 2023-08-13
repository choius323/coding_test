package baekjoon_kotlin._3000/*

3009번 - 네 번째 점
https://www.acmicpc.net/problem/3009

Set을 사용해 중복을 제거하고 x, y좌표에서 각각 한 번만 나온 값을 출력한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val x = HashSet<Int>()
    val y = HashSet<Int>()
    repeat(3) {
        val a = r()
        if (a in x) x -= a
        else x += a
        val b = r()
        if (b in y) y -= b
        else y += b
    }
    print("${x.toList()[0]} ${y.toList()[0]}")
}

/*

*/