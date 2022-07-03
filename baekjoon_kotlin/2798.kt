/*

2798번 - 블랙잭
https://www.acmicpc.net/problem/2798

브루트포스 방식으로 완전 탐색하며 모든 경우를 계산한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {nextToken(); return nval.toInt()}
    val n = i()
    val m = i()
    val cards = IntArray(n) { i() }
    var ans = 0
    for (a in 0 until n) for (b in a + 1 until n) for (c in b + 1 until n){
        val sum = cards[a] + cards[b] + cards[c]
        if (sum in ans + 1..m) ans = sum
    }
    print(ans)
}

/*

*/