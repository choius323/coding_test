package baekjoon_kotlin._10000/*

10812번 - 바구니 순서 바꾸기
https://www.acmicpc.net/problem/10812
분류 : 구현, 시뮬레이션

k~j와 i~k번째 공의 번호를 미리 저장한 뒤, 다시 원래 바구니 배열에 각 공의 번호를 저장한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val baskets = IntArray(n) { it + 1 }
    repeat(r()) {
        val i = r() - 1
        val j = r() - 1
        val k = r() - 1
        val moved = baskets.slice(k..j) + baskets.slice(i until k)
        for (idx in i..j) baskets[idx] = moved[idx - i]
    }
    print(baskets.joinToString(" "))
}

/*

*/