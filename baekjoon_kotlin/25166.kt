/*

25166번 - 배고픈 아리의 샌드위치 구매하기
https://www.acmicpc.net/problem/25166

동전의 금액이 모두 2의 제곱수이기 때문에 그리디로 쉽게 풀 수 있다.
가격이 1023보다 적을 때는 언제나 낼 수 있고(이진법을 생각해보면 된다.) 1023이 넘을 때는 쿠기의 돈으로 그리디를 사용하면 된다.

*/

import kotlin.math.pow

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken(); nval.toInt() }
    fun Int.pow(a: Int) = toDouble().pow(a).toInt()
    val s = r()
    var m = r()
    if (s <= 1023) print("No thanks")
    else {
        var need = s - 1023
        for (i in 9 downTo 0) {
            val p = 2.pow(i)
            if (m >= p) {
                m -= p
                if (need >= p) need -= p
            }
        }
        print(if (need == 0) "Thanks" else "Impossible")
    }
}

/*

*/